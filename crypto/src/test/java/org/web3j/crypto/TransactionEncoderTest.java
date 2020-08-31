package org.web3j.crypto;

import java.math.BigInteger;
import java.security.SignatureException;
import java.util.List;

import com.platon.sdk.utlis.NetworkParameters;
import org.junit.Test;
import org.web3j.crypto.Sign.SignatureData;
import org.web3j.rlp.RlpString;
import org.web3j.rlp.RlpType;
import org.web3j.utils.Numeric;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class TransactionEncoderTest {

	private static final int CHAIN_ID_INC = 35;
	private static final int LOWER_REAL_V = 27;

	@Test
	public void testEtherTransactionAsRlpValues() {
		List<RlpType> rlpStrings = TransactionEncoder.asRlpValues(createEtherTransaction(),
				new Sign.SignatureData((byte) 0, new byte[32], new byte[32]));
		assertThat(rlpStrings.size(), is(9));
		assertThat(rlpStrings.get(3),
				equalTo(RlpString.create(new BigInteger("33c98f20dd73d7bb1d533c4aa3371f2b30c6ebde", 16))));
	}

	@Test
	public void testContractAsRlpValues() {
		List<RlpType> rlpStrings = TransactionEncoder.asRlpValues(createContractTransaction(), null);
		assertThat(rlpStrings.size(), is(6));
		assertThat(rlpStrings.get(3), is(RlpString.create("")));
	}

	@Test
	public void testEip155Encode() {
		assertThat(TransactionEncoder.encode(createEip155RawTransaction(), NetworkParameters.MAIN_NET_CHAIN_ID),
				is(Numeric.hexStringToByteArray(
						"0xec098504a817c8008252089433c98f20dd73d7bb1d533c4aa3371f2b30c6ebde880de0b6b3a764000080648080")));
	}

	@Test
	public void testEip155Transaction() {
		// https://github.com/ethereum/EIPs/issues/155
		Credentials credentials = Credentials
				.create("0x4646464646464646464646464646464646464646464646464646464646464646");
		assertThat(
				TransactionEncoder.signMessage(createEip155RawTransaction(), NetworkParameters.MAIN_NET_CHAIN_ID,
						credentials),
				is(Numeric.hexStringToByteArray(
						"0xf86d098504a817c8008252089433c98f20dd73d7bb1d533c4aa3371f2b30c6ebde880de0b6b3a76400008081eba0767f0f54ed49b6078961214a388c73f1e68b885c02cd800b5e3da81b1bf3eba3a048e6fc2d15ca4a8511bb68c3f53e014ca2f7362e98b0a94dc5771708e854bd90")));
	}

	@Test
	public void testEip155TransactionSm2() throws SignatureException {
		// https://github.com/ethereum/EIPs/issues/155
		ECKeyPair ecKeyPair = Keys.createSm2EcKeyPair();
		Credentials credentials = Credentials.create(ecKeyPair);
		byte[] message = TransactionEncoder.signMessage(createEip155RawTransaction(),
				NetworkParameters.MAIN_NET_CHAIN_ID, credentials);

		SignedRawTransaction rawTransaction = (SignedRawTransaction) TransactionDecoder
				.decode(Numeric.toHexString(message));

		long chainId = getChainId(rawTransaction.getSignatureData().getV());

		byte v = getRealV(rawTransaction.getSignatureData().getV());
		Sign.SignatureData signatureData = new SignatureData(v, rawTransaction.getSignatureData().getR(),
				rawTransaction.getSignatureData().getS());

		BigInteger pubKey = Sign.signedMessageToKeySm2(TransactionEncoder.encode(rawTransaction, chainId),
				signatureData);

		assertTrue((ecKeyPair.getPublicKey().compareTo(pubKey)) == 0);
	}

	private static RawTransaction createEtherTransaction() {
		return RawTransaction.createEtherTransaction(BigInteger.ZERO, BigInteger.ONE, BigInteger.TEN,
				"lat1x0yc7gxaw0tmk82n8392xdcl9vcvd6773zg2s0", BigInteger.valueOf(Long.MAX_VALUE));
	}

	static RawTransaction createContractTransaction() {
		return RawTransaction.createContractTransaction(BigInteger.ZERO, BigInteger.ONE, BigInteger.TEN,
				BigInteger.valueOf(Long.MAX_VALUE), "01234566789");
	}

	private static RawTransaction createEip155RawTransaction() {
		return RawTransaction.createEtherTransaction(BigInteger.valueOf(9), BigInteger.valueOf(20000000000L),
				BigInteger.valueOf(21000), "lat1x0yc7gxaw0tmk82n8392xdcl9vcvd6773zg2s0",
				BigInteger.valueOf(1000000000000000000L));
	}

	private byte getRealV(byte[] inputV) {
		long v = Numeric.toBigInt(inputV).longValue();
		if (v == LOWER_REAL_V || v == (LOWER_REAL_V + 1)) {
			return (byte) v;
		}
		byte realV = LOWER_REAL_V;
		int inc = 0;
		if ((int) v % 2 == 0) {
			inc = 1;
		}
		return (byte) (realV + inc);
	}

	public Long getChainId(byte[] inputV) {
		BigInteger bv = Numeric.toBigInt(inputV);
		long v = bv.longValue();
		if (v == LOWER_REAL_V || v == (LOWER_REAL_V + 1)) {
			return null;
		}
		return (v - CHAIN_ID_INC) / 2;
	}
}
