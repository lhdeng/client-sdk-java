package org.web3j.crypto;

import com.platon.sdk.utlis.Bech32;
import com.platon.sdk.utlis.NetworkParameters;
import org.web3j.utils.Numeric;

import java.math.BigInteger;

/**
 * Keys generated for unit testing purposes.
 */
public class SampleKeys {

	public static final String PRIVATE_KEY_STRING = "a392604efc2fad9c0b3da43b5f698a2e3f270f170d859912be0d54742275c5f6";
	static final String PUBLIC_KEY_STRING = "0x506bc1dc099358e5137292f4efdd57e400f29ba5132aa5d12b18dac1c1f6aab"
			+ "a645c0b7b58158babbfa6c6cd5a48aa7340a8749176b120e8516216787a13dc76";
	public static final String HEX_ADDRESS = "0xef678007d18427e6022059dbc264f27507cd1ffc";
	public static final String HEX_ADDRESS_NO_PREFIX = Numeric.cleanHexPrefix(HEX_ADDRESS);
	public static final String MAINNET_BECH32_ADDRESS = Bech32.addressEncode(NetworkParameters.getMainNetHrp(),
			HEX_ADDRESS);
	public static final String TESTNET_BECH32_ADDRESS = Bech32.addressEncode(NetworkParameters.getTestNetHrp(),
			HEX_ADDRESS);

	public static final String PASSWORD = "Insecure Pa55w0rd";

	static final BigInteger PRIVATE_KEY = Numeric.toBigInt(PRIVATE_KEY_STRING);
	static final BigInteger PUBLIC_KEY = Numeric.toBigInt(PUBLIC_KEY_STRING);

	static final ECKeyPair KEY_PAIR = new ECKeyPair(PRIVATE_KEY, PUBLIC_KEY);

	public static final Credentials CREDENTIALS = Credentials.create(KEY_PAIR);

	public static final String SM2_PRIVATE_KEY_HEX = "bb50060e79da3245e2fb6df7e67828fd04d113ea2d992ddccbdfda7f18ed9627";
	public static final String SM2_PUBLIC_KEY_HEX = "64f6514513c00ffde322fb23b61904bfff3dd76356cb1d397635360c7124eec99ad27da074315eb224bad9a71c8ec5ad213ee0656913205c29e69d57d6de8149";
	public static final String SM2_BECH32_ADDRESS = "lax1mdflvtnmwh786q8fs9v9n05ymt3lafy9pmfypn";
	public static final String SM2_HEX_ADDRESS = Bech32.addressDecodeHex(SM2_BECH32_ADDRESS);
	public static final String SM2_HEX_ADDRESS_NO_PREFIX = Numeric.cleanHexPrefix(SM2_HEX_ADDRESS);

	static final BigInteger SM2_PRIVATE_KEY = Numeric.toBigInt(SM2_PRIVATE_KEY_HEX);
	static final BigInteger SM2_PUBLIC_KEY = Numeric.toBigInt(SM2_PUBLIC_KEY_HEX);

	static final ECKeyPair SM2_KEY_PAIR = new ECKeyPair(SM2_PRIVATE_KEY, SM2_PUBLIC_KEY, ECAlgorithm.SM2);

	public static final Credentials SM2_CREDENTIALS = Credentials.create(SM2_KEY_PAIR);

	private SampleKeys() {
	}
}
