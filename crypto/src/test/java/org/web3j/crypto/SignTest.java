package org.web3j.crypto;

import java.math.BigInteger;
import java.security.SignatureException;

import org.junit.Ignore;
import org.junit.Test;

import org.web3j.utils.Numeric;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class SignTest {

	private static final byte[] TEST_MESSAGE = "A test message".getBytes();

	@Test
	@Ignore
	public void testSignMessage() {
		Sign.SignatureData signatureData = Sign.signMessage(TEST_MESSAGE, SampleKeys.KEY_PAIR);

		Sign.SignatureData expected = new Sign.SignatureData((byte) 27,
				Numeric.hexStringToByteArray("0x9631f6d21dec448a213585a4a41a28ef3d4337548aa34734478b563036163786"),
				Numeric.hexStringToByteArray("0x2ff816ee6bbb82719e983ecd8a33a4b45d32a4b58377ef1381163d75eedc900b"));

		assertThat(signatureData, is(expected));
	}

	@Test
	@Ignore
	public void testSignMessageSm2() {
		Sign.SignatureData signatureData = Sign.signMessage(TEST_MESSAGE, SampleKeys.SM2_KEY_PAIR);

		Sign.SignatureData expected = new Sign.SignatureData((byte) 28,
				Numeric.hexStringToByteArray("0xaf990b391008ac6094a19d0a1ec7048fdd50752b76871bb8f95cb7398e7d9f1b"),
				Numeric.hexStringToByteArray("0xbc571e6c62755e684e170ae32236b70e0f2d2da3c26c583c684fa4471621357b"));

		assertThat(signatureData, is(expected));
	}

	@Test
	public void testSignedMessageToKey() throws SignatureException {
		Sign.SignatureData signatureData = Sign.signMessage(TEST_MESSAGE, SampleKeys.KEY_PAIR);
		BigInteger key = Sign.signedMessageToKey(TEST_MESSAGE, signatureData);
		assertThat(key, equalTo(SampleKeys.PUBLIC_KEY));
	}

	@Test
	public void testSignedMessageToKeySm2() throws SignatureException {
		Sign.SignatureData signatureData = Sign.signMessage(TEST_MESSAGE, SampleKeys.SM2_KEY_PAIR);
		BigInteger key = Sign.signedMessageToKeySm2(TEST_MESSAGE, signatureData);
		assertThat(key, equalTo(SampleKeys.SM2_PUBLIC_KEY));
	}

	@Test
	public void testPublicKeyFromPrivateKey() {
		assertThat(Sign.publicKeyFromPrivate(SampleKeys.PRIVATE_KEY), equalTo(SampleKeys.PUBLIC_KEY));
	}

	@Test
	public void testPublicKeyFromPrivateKeySm2() {
		assertThat(Sign.publicKeyFromPrivateSm2(SampleKeys.SM2_PRIVATE_KEY), equalTo(SampleKeys.SM2_PUBLIC_KEY));
	}

	@Test(expected = RuntimeException.class)
	public void testInvalidSignature() throws SignatureException {
		Sign.signedMessageToKey(TEST_MESSAGE, new Sign.SignatureData((byte) 27, new byte[] { 1 }, new byte[] { 0 }));
	}
}
