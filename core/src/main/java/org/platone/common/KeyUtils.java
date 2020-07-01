package org.platone.common;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KeyUtils {

	private static final Logger log = LoggerFactory.getLogger(KeyUtils.class);

	public static BlsKey createBlsKey(String keytoolPath) throws IOException {
		String msg = executeCmd(keytoolPath, "genblskeypair");

		ByteArrayInputStream bis = new ByteArrayInputStream(msg.getBytes());
		BufferedReader reader = new BufferedReader(new InputStreamReader(bis));

		BlsKey blsKey = new BlsKey();
		String line;

		while ((line = reader.readLine()) != null) {
			if (line.indexOf("PrivateKey") != -1) {
				String privateKey = line.substring(line.indexOf("PrivateKey") + 11).trim();
				blsKey.setPrivateKey(privateKey);
			}
			if (line.indexOf("PublicKey") != -1) {
				String publicKey = line.substring(line.indexOf("PublicKey") + 11).trim();
				blsKey.setPublicKey(publicKey);
			}
		}

		if (null != reader)
			reader.close();

		if (null != bis)
			bis.close();

		return blsKey;
	}

	public static NodeKey createNodeKey(String keytoolPath) throws IOException {
		String msg = executeCmd(keytoolPath, "genkeypair");

		ByteArrayInputStream bis = new ByteArrayInputStream(msg.getBytes());
		BufferedReader reader = new BufferedReader(new InputStreamReader(bis));

		NodeKey nodeKey = new NodeKey();
		String line;

		while ((line = reader.readLine()) != null) {
			if (line.indexOf("PrivateKey") != -1) {
				String privateKey = line.substring(line.indexOf("PrivateKey") + 11).trim();
				nodeKey.setPrivateKey(privateKey);
			}
			if (line.indexOf("PublicKey") != -1) {
				String publicKey = line.substring(line.indexOf("PublicKey") + 11).trim();
				nodeKey.setPublicKey(publicKey);
			}
			if (line.indexOf("Address") != -1) {
				String address = line.substring(line.indexOf("Address") + 11).trim();
				nodeKey.setAddress(address);
			}
		}

		if (null != reader)
			reader.close();

		if (null != bis)
			bis.close();

		return nodeKey;
	}

	public static class NodeKey {
		private String address;
		private String privateKey;
		private String publicKey;

		public NodeKey() {

		}

		public NodeKey(String address, String privateKey, String publicKey) {
			this.address = address;
			this.privateKey = privateKey;
			this.publicKey = publicKey;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getPrivateKey() {
			return privateKey;
		}

		public void setPrivateKey(String privateKey) {
			this.privateKey = privateKey;
		}

		public String getPublicKey() {
			return publicKey;
		}

		public void setPublicKey(String publicKey) {
			this.publicKey = publicKey;
		}
	}

	public static class BlsKey {
		private String privateKey;
		private String publicKey;

		public BlsKey() {

		}

		public BlsKey(String privateKey, String publicKey) {
			this.privateKey = privateKey;
			this.publicKey = publicKey;
		}

		public String getPrivateKey() {
			return privateKey;
		}

		public void setPrivateKey(String privateKey) {
			this.privateKey = privateKey;
		}

		public String getPublicKey() {
			return publicKey;
		}

		public void setPublicKey(String publicKey) {
			this.publicKey = publicKey;
		}
	}

	public static String executeCmd(String... cmds) throws IOException {
		ProcessBuilder builder = new ProcessBuilder().redirectErrorStream(true);
		List<String> list = new ArrayList<>();

		String os = System.getProperty("os.name");
		log.debug("The os.name is {}", os);

		if (os.startsWith("Windows")) {
			list.add("cmd");
			list.add("/c");
		} else if (os.startsWith("Linux") || os.startsWith("Mac OS")) {
			list.add("/bin/bash");
			list.add("-c");
		} else {
			throw new UnsupportedOperationException("Unsupported operating system,os.name: " + os);
		}

		list.addAll(Arrays.asList(cmds));
		builder.command(list);
		log.debug("The list of commands executed :{}", list);

		Process process = builder.start();

		BufferedReader reader = new BufferedReader(
				new InputStreamReader(process.getInputStream(), Charset.forName("GB2312")));

		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			log.debug(line);
			sb.append(line).append("\n");
		}

		if (null != reader)
			reader.close();

		if (null != process)
			process.destroy();

		return sb.toString();

	}
}
