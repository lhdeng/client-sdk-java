package org.web3j.crypto;

import org.web3j.utils.Numeric;

import com.platone.sdk.utlis.Bech32;
import com.platone.sdk.utlis.NetworkParameters;

/**
 * Credentials wrapper.
 */
public class Credentials {

	private final ECKeyPair ecKeyPair;
	private String address;

	private Credentials(ECKeyPair ecKeyPair, String address) {
		this.ecKeyPair = ecKeyPair;
		this.address = address;
	}

	public ECKeyPair getEcKeyPair() {
		return ecKeyPair;
	}

	public String getAddress() {
		return this.address;
	}

	public static Credentials create(ECKeyPair ecKeyPair) {
		String hexAddress = Numeric.prependHexPrefix(Keys.getAddress(ecKeyPair));
		String bech32Address = Bech32.addressEncode(NetworkParameters.getHrp(), hexAddress);
		return new Credentials(ecKeyPair, bech32Address);
	}

	public static Credentials create(String privateKey, String publicKey) {
		return create(new ECKeyPair(Numeric.toBigInt(privateKey), Numeric.toBigInt(publicKey)));
	}

	public static Credentials create(String privateKey) {
		return create(ECKeyPair.create(Numeric.toBigInt(privateKey)));
	}

	public static Credentials createSm2(String privateKey, String publicKey) {
		return create(new ECKeyPair(Numeric.toBigInt(privateKey), Numeric.toBigInt(publicKey), ECAlgorithm.SM2));
	}

	public static Credentials createSm2(String privateKey) {
		return create(ECKeyPair.createSm2(Numeric.toBigInt(privateKey)));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Credentials that = (Credentials) o;

		if (ecKeyPair != null ? !ecKeyPair.equals(that.ecKeyPair) : that.ecKeyPair != null) {
			return false;
		}

		return address != null ? address.equals(that.address) : that.address == null;
	}

	@Override
	public int hashCode() {
		int result = ecKeyPair != null ? ecKeyPair.hashCode() : 0;
		result = 31 * result + (address != null ? address.hashCode() : 0);
		return result;
	}
}
