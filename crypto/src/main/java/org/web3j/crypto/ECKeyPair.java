package org.web3j.crypto;

import java.math.BigInteger;
import java.security.KeyPair;
import java.util.Arrays;

import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.signers.ECDSASigner;
import org.bouncycastle.crypto.signers.HMacDSAKCalculator;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;
import org.web3j.utils.Numeric;

import com.platon.sm.SM2Utils;
import com.platon.sm.SM2Utils.Sm2KeyPair;

/**
 * Elliptic Curve SECP-256k1 generated key pair.
 */
public class ECKeyPair {
	private final BigInteger privateKey;
	private final BigInteger publicKey;

	/**
	 * Signature algorithm.
	 * 
	 * If the signature algorithm is Secp256k1, the hash algorithm uses SHA3.
	 * If the signature algorithm is SM2, the hash algorithm uses SM3.
	 */
	private ECAlgorithm algorithm;

	public ECKeyPair(BigInteger privateKey, BigInteger publicKey) {
		this(privateKey, publicKey, ECAlgorithm.Secp256k1);
	}

	public ECKeyPair(BigInteger privateKey, BigInteger publicKey, ECAlgorithm algorithm) {
		this.privateKey = privateKey;
		this.publicKey = publicKey;
		this.algorithm = algorithm;
	}

	public BigInteger getPrivateKey() {
		return privateKey;
	}

	public BigInteger getPublicKey() {
		return publicKey;
	}

	public ECAlgorithm getAlgorithm() {
		return algorithm;
	}

	/**
	 * Sign a hash with the private key of this key pair.
	 * Note: Only use Secp256k1.
	 * 
	 * @param transactionHash   the hash to sign
	 * @return  An {@link ECDSASignature} of the hash
	 */
	public ECDSASignature sign(byte[] transactionHash) {
		if (algorithm != ECAlgorithm.Secp256k1) {
			throw new UnsupportedOperationException("This method can only use the Secp256k1 algorithm for signing");
		}

		ECDSASigner signer = new ECDSASigner(new HMacDSAKCalculator(new SHA256Digest()));

		ECPrivateKeyParameters privKey = new ECPrivateKeyParameters(privateKey, Sign.CURVE);
		signer.init(true, privKey);
		BigInteger[] components = signer.generateSignature(transactionHash);

		return new ECDSASignature(components[0], components[1]).toCanonicalised();
	}

	/**
	 * Sign a hash with the private key of this key pair.
	 * Note: Only use sm2.
	 * 
	 * @param transactionHash   the hash to sign
	 * @return Signature value
	 */
	public byte[] sm2Sign(byte[] transactionHash) {
		if (algorithm != ECAlgorithm.SM2) {
			throw new UnsupportedOperationException("This method can only use the SM2 algorithm for signing");
		}

		return SM2Utils.sign(transactionHash, Numeric.toBytesPadded(privateKey, Keys.PRIVATE_KEY_SIZE));
	}

	/**
	 * Generate ECKeyPair of Secp256k1 algorithm according to KeyPair
	 * 
	 * @param keyPair Keypair of Secp256k1 algorithm
	 * @return ECKeyPair
	 */
	public static ECKeyPair create(KeyPair keyPair) {
		BCECPrivateKey privateKey = (BCECPrivateKey) keyPair.getPrivate();
		BCECPublicKey publicKey = (BCECPublicKey) keyPair.getPublic();

		BigInteger privateKeyValue = privateKey.getD();

		// Ethereum does not use encoded public keys like bitcoin - see
		// https://en.bitcoin.it/wiki/Elliptic_Curve_Digital_Signature_Algorithm
		// for details
		// Additionally, as the first bit is a constant prefix (0x04) we ignore
		// this value
		byte[] publicKeyBytes = publicKey.getQ().getEncoded(false);
		BigInteger publicKeyValue = new BigInteger(1, Arrays.copyOfRange(publicKeyBytes, 1, publicKeyBytes.length));

		return new ECKeyPair(privateKeyValue, publicKeyValue);
	}

	/**
	 * Generate ECKeyPair of Secp256k1 algorithm according to the private key
	 * 
	 * @param privateKey The private key of the Secp256k1 algorithm
	 * @return ECKeyPair
	 */
	public static ECKeyPair create(BigInteger privateKey) {
		return new ECKeyPair(privateKey, Sign.publicKeyFromPrivate(privateKey));
	}

	/**
	 * Generate ECKeyPair of Secp256k1 algorithm according to the private key
	 * 
	 * @param privateKey The private key of the Secp256k1 algorithm
	 * @return ECKeyPair
	 */
	public static ECKeyPair create(byte[] privateKey) {
		return create(Numeric.toBigInt(privateKey));
	}

	/**
	 * Generate ECKeyPair of SM2 algorithm
	 * 
	 * @param sm2KeyPair Sm2KeyPair
	 * @return ECKeyPair
	 */
	public static ECKeyPair createSm2(Sm2KeyPair sm2KeyPair) {
		return new ECKeyPair(Numeric.toBigInt(sm2KeyPair.getPrivateKey()), Numeric.toBigInt(sm2KeyPair.getPublicKey()),
				ECAlgorithm.SM2);
	}

	/**
	 * Generate ECKeyPair of SM2 algorithm according to the private key
	 * 
	 * @param privateKey The private key of the SM2 algorithm
	 * @return ECKeyPair
	 */
	public static ECKeyPair createSm2(BigInteger privateKey) {
		return createSm2(Numeric.toBytesPadded(privateKey, Keys.PRIVATE_KEY_SIZE));
	}

	/**
	 * Generate ECKeyPair of SM2 algorithm according to the private key
	 * 
	 * @param privateKey The private key of the SM2 algorithm
	 * @return ECKeyPair
	 */
	public static ECKeyPair createSm2(byte[] privateKey) {
		byte[] publicKey = SM2Utils.pubKeyFromPrivateKey(privateKey);
		return new ECKeyPair(Numeric.toBigInt(privateKey), Numeric.toBigInt(publicKey), ECAlgorithm.SM2);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		ECKeyPair ecKeyPair = (ECKeyPair) o;

		if (privateKey != null ? !privateKey.equals(ecKeyPair.privateKey) : ecKeyPair.privateKey != null) {
			return false;
		}

		return publicKey != null ? publicKey.equals(ecKeyPair.publicKey) : ecKeyPair.publicKey == null;
	}

	@Override
	public int hashCode() {
		int result = privateKey != null ? privateKey.hashCode() : 0;
		result = 31 * result + (publicKey != null ? publicKey.hashCode() : 0);
		return result;
	}
}
