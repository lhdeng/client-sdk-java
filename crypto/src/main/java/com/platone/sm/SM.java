package com.platone.sm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SM {
	static final String LIBRARY_PATH = "library/platon_sm";
	static final String LIBRARY_NAME = "platon_sm";
	static final String LIBRARY_SUFFIX_WIN = ".dll";
	static final String LIBRARY_SUFFIX_LINUX = ".so";

	static {
		loadLibrary();
	}

	private static void loadLibrary() {
		String osName = System.getProperty("os.name");
		osName = osName.toLowerCase();

		String suffix;
		if (osName.contains("linux")) {
			suffix = LIBRARY_SUFFIX_LINUX;
		} else if (osName.contains("windows")) {
			suffix = LIBRARY_SUFFIX_WIN;
		} else {
			throw new UnsupportedOperationException("Operating system not supported by SM:" + osName);
		}

		try {
			File tmpLibrary = File.createTempFile(LIBRARY_NAME, suffix);
			tmpLibrary.deleteOnExit();

			InputStream in = SM.class.getClassLoader().getResourceAsStream(LIBRARY_PATH + suffix);
			FileOutputStream out = new FileOutputStream(tmpLibrary);
			int i;
			byte[] buf = new byte[1024];
			while ((i = in.read(buf)) != -1) {
				out.write(buf, 0, i);
			}
			in.close();
			out.close();

			String libPath = tmpLibrary.getAbsolutePath();
			System.load(libPath);
		} catch (IOException e) {
			e.printStackTrace();
			// throw new RuntimeException(e);
		}
	}

	public static native GenResult generate();

	public static native PubKeyFromPrivateKeyResult pubKeyFromPrivateKey(byte[] secKey);

	public static native SignResult sign(byte[] msg, byte[] secKey);

	public static native RecoverPubKeyResult recoverPubKey(byte[] msg, byte[] sign);

	public static native boolean verifySignature(byte[] pubKey, byte[] msg, byte[] sign);

	public static native HashResult sm3(byte[] msg);

	public static class GenResult {
		public byte[] pubKey;
		public byte[] privateKey;
		public int code;
		public String msg;
	}

	public static class PubKeyFromPrivateKeyResult {
		public byte[] pubKey;
		public int code;
		public String msg;
	}

	public static class SignResult {
		public byte[] sign;
		public int code;
		public String msg;
	}

	public static class RecoverPubKeyResult {
		public byte[] pubKey;
		public int code;
		public String msg;
	}

	public static class HashResult {
		public byte[] hash;
		public int code;
		public String msg;
	}

	public static byte[] hexStringToByteArray(String s) {
		int len = s.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
		}
		return data;
	}

	private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

	public static String bytesToHex(byte[] bytes) {
		char[] hexChars = new char[bytes.length * 2];
		for (int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = HEX_ARRAY[v >>> 4];
			hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
		}
		return new String(hexChars);
	}

}
