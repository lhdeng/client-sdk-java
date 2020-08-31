package com.platon.sm;

import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.web3j.utils.Numeric;
import static org.hamcrest.core.Is.is;

public class SM3UtilsTest {
	@Test
	public void testSm3() {
		String str = "123456789";
		byte[] bs = str.getBytes();
		String hex = Numeric.toHexString(bs);

		assertThat(SM3Utils.sm3String(str), is("0xc7ae0aec3d2f9beb84dc1885aa7a576baa7a07b38060afc64c5600f93a5456b5"));

		assertThat(Numeric.toHexString(SM3Utils.sm3(bs)),
				is("0xc7ae0aec3d2f9beb84dc1885aa7a576baa7a07b38060afc64c5600f93a5456b5"));

		assertThat(SM3Utils.sm3(hex), is("0xc7ae0aec3d2f9beb84dc1885aa7a576baa7a07b38060afc64c5600f93a5456b5"));

	}
}
