package org.web3j.crypto;

import java.math.BigInteger;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.web3j.crypto.ContractUtils.generateContractAddress;
import static org.web3j.crypto.ContractUtils.generateSm3ContractAddress;

public class ContractUtilsTest {

	@Test
	public void testCreateContractAddress() {
		String address = "0x19e03255f667bdfd50a32722df860b1eeaf4d635";

		assertThat(generateContractAddress(address, BigInteger.valueOf(209)),
				is("0xe41e694d8fa4337b7bffc7483d3609ae1ea068d5"));

		assertThat(generateContractAddress(address, BigInteger.valueOf(257)),
				is("0x59c21d36fbe415218e834683cb6616f2bc971ca9"));
	}

	@Test
	public void testCreateSm3ContractAddress() {
		String address = "0x19e03255f667bdfd50a32722df860b1eeaf4d635";

		assertThat(generateSm3ContractAddress(address, BigInteger.valueOf(209)), 
				is("0x28509f563fb1ff1755c8259c033a2f71f1644880"));

		assertThat(generateSm3ContractAddress(address, BigInteger.valueOf(257)), 
				is("0x877a0626865e45c8c219422a774afeccdc509566"));
	}
}
