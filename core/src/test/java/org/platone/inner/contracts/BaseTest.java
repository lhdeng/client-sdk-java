package org.platone.inner.contracts;

import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.junit.Before;
import org.junit.Test;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.utils.Numeric;

import com.platone.sdk.utlis.Bech32;

public class BaseTest {
	static final String URL = "http://127.0.0.1:6789";
	//static final String URL = "http://10.1.1.5:6789";
	static final long CHAIN_ID = 200L;

	static final String CREATOR_PRIVATEKEY = "35e8b598593710447fe5315113516a369ed7ac4d6c41ee0bfb8f5708bff1787c";
	static final String CREATOR_ADDRESS = "lax1kwu5qpqjrhdkln42ayzrnw3rg3nqj3xnkn4wmd";

	static final String USER_PRIVATEKEY_1 = "beda9d94c55b2993ed00a12b69b8d704407e47c5e7e995680975153b06e63f8c";
	static final String USER_ADDRESS_1 = "lax13jwu9rppzk6ll3hqaykgpxeav4fu6su348uztx";

	static final String USER_PRIVATEKEY_2 = "f8dbdfaa91eef6bf78d6e3fcc9363905e840fb8fd10a267e1df41ea749e46b23";
	static final String USER_ADDRESS_2 = "lax1xyg2x9z5zwsayu8zqlv07yrg6mn77w5v456vk0";

	static final String USER_PRIVATEKEY_3 = "c7f410c1876cf6905759a6ed8632ce791e1429676226057026994b4736db97cc";
	static final String USER_ADDRESS_3 = "lax18smm94mc75jk5lsacjkzwu3339hyd078e5a0x9";

	Web3j web3j;

	ContractGasProvider contractGasProvider;

	Credentials creatorCredentials;

	TransactionManager transactionManager;
	
	static final String SM2_CREATOR_PRIVATEKEY = "376fa4c2dc4fdca15e3435427bc4e056ed87a2c542e5249dc59a18c4e69589c4";
	static final String SM2_CREATOR_ADDRESS = "lax1jfr6ar8dah7ghaxfs4826dyrchhted5784ewpj";
	
	static final String SM2_USER_PRIVATEKEY_1 = "19472082fee30dbe0eef33348caca790cb254ca5c6f465f5e6fbf89ece68a1ac";
	static final String SM2_USER_ADDRESS_1 = "lax1udt3ukry8tg80tcr8usq7myv33r36mpxa5hcpm";

	@Before
	public void init() {
		web3j = Web3j.build(new HttpService(URL));

		contractGasProvider = new ContractGasProvider(BigInteger.valueOf(210000), BigInteger.valueOf(1000000L));

		creatorCredentials = Credentials.create(CREATOR_PRIVATEKEY);

		transactionManager = new RawTransactionManager(web3j, creatorCredentials, CHAIN_ID);
	}

	@Test
	public void createCredentials() {
		try {
			ECKeyPair keyPair = Keys.createEcKeyPair();
			String address = Keys.getAddress(keyPair.getPublicKey());

			System.err.println("Address >>>> " + address);
			System.err.println("Bech32 Address >>>> " + Bech32.addressEncode("lax", address));
			System.err.println("PrivateKey >>> " + Numeric.toHexStringNoPrefix(keyPair.getPrivateKey()));

		} catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException e) {
			e.printStackTrace();

			assertTrue(e.getMessage(), false);
		}
	}

}
