package com.platon.sm;

import java.nio.charset.StandardCharsets;

import org.web3j.utils.Numeric;

public class SM3Utils {

	/**
	 * SM3 hash function.
	 *
	 * @param hexInput hex encoded input data with optional 0x prefix
	 * @return hash value as hex encoded string
	 */
	public static String sm3(String hexInput) {
		byte[] bytes = Numeric.hexStringToByteArray(hexInput);
		byte[] result = sm3(bytes);
		return Numeric.toHexString(result);
	}

	/**
	 * SM3 hash function.
	 *
	 * @param input binary encoded input data
	 * @return hash value
	 */
	public static byte[] sm3(byte[] input) {
		SM.HashResult hashResult = SM.sm3(input);
		if (null != hashResult && hashResult.code == 0) {
			return hashResult.hash;
		} else {
			String msg;
			if (null == hashResult)
				msg = "the return value is null";
			else
				msg = "code=[" + hashResult.code + "],msg=[" + hashResult.msg + "]";
			throw new RuntimeException("An exception occurred while invoke the sm3 function:" + msg);
		}
	}

	/**
	 * SM3 hash function that operates on a UTF-8 encoded String.
	 *
	 * @param utf8String UTF-8 encoded string
	 * @return hash value as hex encoded string
	 */
	public static String sm3String(String utf8String) {
		return Numeric.toHexString(sm3(utf8String.getBytes(StandardCharsets.UTF_8)));
	}
}
