package org.platone.common;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.platone.common.KeyUtils.BlsKey;
import org.platone.common.KeyUtils.NodeKey;

public class KeyUtilsTest {

	public static String getKeytoolPath() {
		String os = System.getProperty("os.name");

		String path;
		if (os.startsWith("Windows")) {
			path = KeyUtils.class.getClassLoader().getResource("win/keytool.exe").getPath();
		} else if (os.startsWith("Linux") || os.startsWith("Mac OS")) {
			path = KeyUtils.class.getClassLoader().getResource("linux/keytool").getPath();
		} else {
			throw new UnsupportedOperationException("Unsupported operating system,os.name: " + os);
		}

		File file = new File(path);
		return file.getAbsolutePath();
	}

	@Test
	@Ignore
	public void testCreateBlsKey() throws IOException {
		String keytoolPath = getKeytoolPath();
		BlsKey blsKey = KeyUtils.createBlsKey(keytoolPath);

		Assert.assertTrue(blsKey != null);
		Assert.assertTrue(blsKey.getPrivateKey() != null);
		Assert.assertTrue(blsKey.getPublicKey() != null);

		Assert.assertEquals(64, blsKey.getPrivateKey().length());
		Assert.assertEquals(192, blsKey.getPublicKey().length());
	}

	@Test
	@Ignore
	public void testCreatePubKey() throws IOException {
		String keytoolPath = getKeytoolPath();
		NodeKey nodeKey = KeyUtils.createNodeKey(keytoolPath);

		Assert.assertTrue(nodeKey != null);
		Assert.assertTrue(nodeKey.getPrivateKey() != null);
		Assert.assertTrue(nodeKey.getPublicKey() != null);
		Assert.assertTrue(nodeKey.getAddress() != null);

		Assert.assertEquals(64, nodeKey.getPrivateKey().length());
		Assert.assertEquals(128, nodeKey.getPublicKey().length());
		Assert.assertEquals(42, nodeKey.getAddress().length());
	}
}
