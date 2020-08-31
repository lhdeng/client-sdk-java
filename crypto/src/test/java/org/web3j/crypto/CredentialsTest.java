package org.web3j.crypto;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CredentialsTest {

	@Test
	public void testCredentialsFromString() {
		Credentials credentials = Credentials.create(SampleKeys.KEY_PAIR);
		verify(credentials);
	}

	@Test
	public void testCredentialsFromECKeyPair() {
		Credentials credentials = Credentials.create(SampleKeys.PRIVATE_KEY_STRING, SampleKeys.PUBLIC_KEY_STRING);
		verify(credentials);
	}

	private void verify(Credentials credentials) {
		assertEquals(credentials.getAddress(), SampleKeys.TESTNET_BECH32_ADDRESS);
		assertThat(credentials.getEcKeyPair(), is(SampleKeys.KEY_PAIR));
	}

	@Test
	public void testSm2CredentialsFromString() {
		Credentials credentials = Credentials.createSm2(SampleKeys.SM2_PRIVATE_KEY_HEX);
		verifySm2(credentials);
	}

	@Test
	public void testSm2CredentialsFromECKeyPair() {
		Credentials credentials = Credentials.create(SampleKeys.SM2_KEY_PAIR);
		verifySm2(credentials);
	}

	@Test
	public void testSm2CredentialsFromString2() {
		Credentials credentials = Credentials.createSm2(SampleKeys.SM2_PRIVATE_KEY_HEX, SampleKeys.SM2_PUBLIC_KEY_HEX);
		verifySm2(credentials);
	}

	private void verifySm2(Credentials credentials) {
		assertEquals(credentials.getAddress(), SampleKeys.SM2_BECH32_ADDRESS);
		assertThat(credentials.getEcKeyPair(), is(SampleKeys.SM2_KEY_PAIR));
	}
}
