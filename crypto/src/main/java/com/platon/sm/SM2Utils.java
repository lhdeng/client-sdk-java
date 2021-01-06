package com.platon.sm;

public class SM2Utils {

	/**
	 * Use sm2 algorithm to generate public and private keys
	 * 
	 * @return Sm2KeyPair
	 */
	public static Sm2KeyPair generate() {
		SM.GenResult genResult = SM.generate();
		if (null != genResult && genResult.code == 0) {
			return new Sm2KeyPair(genResult.privateKey, genResult.pubKey);
		} else {
			String msg;
			if (null == genResult)
				msg = "the return value is null";
			else
				msg = "code=[" + genResult.code + "],msg=[" + genResult.msg + "]";
			throw new RuntimeException(
					"An exception occurs when using sm2 algorithm to generate public and private keys: " + msg);
		}
	}

	/**
	 * Use the private key to derive the public key
	 * 
	 * @param secKey the private key
	 * @return the public key
	 */
	public static byte[] pubKeyFromPrivateKey(byte[] secKey) {
		SM.PubKeyFromPrivateKeyResult result = SM.pubKeyFromPrivateKey(secKey);
		if (null != result && result.code == 0) {
			return result.pubKey;
		} else {
			String msg;
			if (null == result)
				msg = "the return value is null";
			else
				msg = "code=[" + result.code + "],msg=[" + result.msg + "]";
			throw new RuntimeException(
					"An exception occurred while using the private key to derive the public key: " + msg);
		}
	}

	/**
	 * Use sm2 algorithm to sign message
	 * 
	 * @param msg the byte array of the signed message
	 * @param secKey the private key
	 * @return the byte array of successfully signed message
	 */
	public static byte[] sign(byte[] msg, byte[] secKey) {
		SM.SignResult result = SM.sign(msg, secKey);
		if (null != result && result.code == 0) {
			return result.sign;
		} else {
			String errMsg;
			if (null == result)
				errMsg = "the return value is null";
			else
				errMsg = "code=[" + result.code + "],msg=[" + result.msg + "]";
			throw new RuntimeException("An exception occurred when using sm2 algorithm signature: " + errMsg);
		}
	}

	/**
	 * Derive the public key from the plaintext of the signed data and the signed data
	 * 
	 * @param msg the plaintext of the signed
	 * @param sign signed data
	 * @return the public key
	 */
	public static byte[] recoverPubKey(byte[] msg, byte[] sign) {
		SM.RecoverPubKeyResult result = SM.recoverPubKey(msg, sign);
		if (null != result && result.code == 0) {
			return result.pubKey;
		} else {
			String errMsg;
			if (null == result)
				errMsg = "the return value is null";
			else
				errMsg = "code=[" + result.code + "],msg=[" + result.msg + "]";
			throw new RuntimeException(
					"An exception occurred when deriving the public key from the plaintext of the signed data and the signed data: "
							+ errMsg);
		}
	}

	/**
	 * Verify signature
	 * 
	 * @param pubKey the public key
	 * @param msg the plaintext of signed data
	 * @param sign the signed data
	 * @return Validation results: true-success,false-failed
	 */
	public static boolean verifySignature(byte[] pubKey, byte[] msg, byte[] sign) {
		return SM.verifySignature(pubKey, msg, sign);
	}

	public static class Sm2KeyPair {
		private byte[] privateKey;
		private byte[] publicKey;

		public Sm2KeyPair() {
		}

		public Sm2KeyPair(byte[] privateKey, byte[] publicKey) {
			this.privateKey = privateKey;
			this.publicKey = publicKey;
		}

		public byte[] getPrivateKey() {
			return privateKey;
		}

		public byte[] getPublicKey() {
			return publicKey;
		}
	}
}
