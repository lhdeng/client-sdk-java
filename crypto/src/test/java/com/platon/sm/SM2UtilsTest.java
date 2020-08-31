package com.platon.sm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.web3j.utils.Numeric;

public class SM2UtilsTest {
	static final String SM2_PRIVATE_KEY = "0xc6b832bdbbfa61e970c921d9a09fa89337458db65c2c293fd7e18490bacdf681";
	static final String SM2_PUBLIC_KEY = "0x4f1b58d1c43d9b96eef6dff1655f4d82847453bc6a1a56528bc3919ada7a5583ba41c16e6f9dfd63e765725e075315e13c3038c42ee7f057723a334ecf114605";

	@Test
	public void testGenerate() {
		SM2Utils.Sm2KeyPair sm2KeyPair = SM2Utils.generate();
		assertTrue(sm2KeyPair.getPrivateKey().length == 32);
		assertTrue(sm2KeyPair.getPublicKey().length == 64);
	}

	@Test
	public void testPubKeyFromPrivateKey() {
		byte[] pubKey = SM2Utils.pubKeyFromPrivateKey(Numeric.hexStringToByteArray(SM2_PRIVATE_KEY));
		assertTrue(Numeric.toHexString(pubKey).equals(SM2_PUBLIC_KEY));
	}

	@Test
	public void testSign() {
		byte[] msg = SM3Utils.sm3("123456789".getBytes());

		// sign
		byte[] sign = SM2Utils.sign(msg, Numeric.hexStringToByteArray(SM2_PRIVATE_KEY));

		// verify signature
		assertTrue(SM2Utils.verifySignature(Numeric.hexStringToByteArray(SM2_PUBLIC_KEY), msg, sign));
	}

	@Test
	public void testRecoverPubKey() {
		byte[] msg = SM3Utils.sm3("123456789".getBytes());
		
		// sign
		byte[] sign = SM2Utils.sign(msg, Numeric.hexStringToByteArray(SM2_PRIVATE_KEY));
		
		byte[] pubKey = SM2Utils.recoverPubKey(msg, sign);
		
		assertTrue(Numeric.toHexString(pubKey).equals(SM2_PUBLIC_KEY));
	}

}
