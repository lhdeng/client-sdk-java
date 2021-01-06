package org.web3j.abi.datatypes;

import java.math.BigInteger;

import org.web3j.abi.datatypes.generated.Uint160;
import org.web3j.utils.Numeric;

import com.platone.sdk.utlis.Bech32;
import com.platone.sdk.utlis.NetworkParameters;

/**
 * Address type, which is equivalent to uint160.
 */
public class Address implements Type<String> {

	public static final String TYPE_NAME = "address";
	public static final int LENGTH = 160;
	public static final int LENGTH_IN_HEX = LENGTH >> 2;

	private final Uint160 value;
	private final String address;

	public Address(Uint160 value, String hrp) {
		this.value = value;
		this.address = Bech32.addressEncode(hrp, Numeric.toHexStringWithPrefixZeroPadded(value.getValue(), LENGTH_IN_HEX));
	}

	public Address(Uint160 value) {
		this(value, NetworkParameters.getHrp());
	}

	public Address(BigInteger inputValue) {
		this(new Uint160(inputValue), NetworkParameters.getHrp());
	}

	public Address(String bechValue) {
		this.value = new Uint160(Numeric.toBigInt(Bech32.addressDecodeHex(bechValue)));
		this.address = bechValue;
	}

	@Deprecated
	public Address(Uint160 value, long chainId) {
		this(value, NetworkParameters.getHrp(chainId));
	}

	@Deprecated
	public Address(BigInteger inputValue, long chainId) {
		this(new Uint160(inputValue), NetworkParameters.getHrp(chainId));
	}

	public Uint160 toUint160() {
		return value;
	}

	@Override
	public String getTypeAsString() {
		return TYPE_NAME;
	}

	@Override
	public String toString() {
		return address;
	}

	@Override
	public String getValue() {
		return toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Address address = (Address) o;

		return value != null ? value.equals(address.value) : address.value == null;
	}

	@Override
	public int hashCode() {
		return value != null ? value.hashCode() : 0;
	}
}
