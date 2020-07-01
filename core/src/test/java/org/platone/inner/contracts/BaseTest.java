package org.platone.inner.contracts;

import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.utils.Numeric;

public class BaseTest {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	static final String URL = "http://10.1.1.9:6789";
	static final long CHAIN_ID = 200L;

	static final String CREATOR_PRIVATEKEY = "983759fe9aac227c535b21d78792d79c2f399b1d43db46ae6d50a33875301557";
	static final String CREATOR_ADDRESS = "0x72390064b9399fdaf1e471973e20bd7da8ac9dc6";

	static final String PRIVATEKEY_1 = "2ef19049c9e5763491bf81989e2a0e03be3c5b51fa5ac68656fd64f05555e9d5";

	static final String PRIVATEKEY_2 = "808522c84e7dee90169d642b4e5413ff66e567c652bdf43ca684190fde4ffb07";

	static final String PRIVATEKEY_3 = "976d1d4809dcdcb0e0b3895bfd79332d3b19b80df448a74b9a0b27f2b93a81b1";

	Web3j web3j;

	ContractGasProvider contractGasProvider;

	Credentials creatorCredentials;

	TransactionManager transactionManager;

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

			logger.info("address >>>> {}", address);
			logger.info("privateKey >>> {}", Numeric.toHexStringNoPrefix(keyPair.getPrivateKey()));

		} catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException e) {
			e.printStackTrace();

			assertTrue(e.getMessage(), false);
		}
	}

}
