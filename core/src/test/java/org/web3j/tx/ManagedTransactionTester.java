package org.web3j.tx;

import org.junit.Before;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.SampleKeys;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.utils.TxHashVerifier;

import java.io.IOException;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SuppressWarnings("rawtypes")
public abstract class ManagedTransactionTester {

	static final String ADDRESS = "lat184ktzclhcukjpv8u66a2ukyfx2w38zj2prhd65";
	static final String TRANSACTION_HASH = "0xHASH";
	protected Web3j web3j;
	protected TxHashVerifier txHashVerifier;

	@Before
	public void setUp() throws Exception {
		web3j = mock(Web3j.class);
		txHashVerifier = mock(TxHashVerifier.class);
		when(txHashVerifier.verify(any(), any())).thenReturn(true);
	}

	public TransactionManager getVerifiedTransactionManager(Credentials credentials, int attempts, int sleepDuration) {
		RawTransactionManager transactionManager = new RawTransactionManager(web3j, credentials,
				200L, attempts, sleepDuration);
		transactionManager.setTxHashVerifier(txHashVerifier);
		return transactionManager;
	}

	public TransactionManager getVerifiedTransactionManager(Credentials credentials) {
		RawTransactionManager transactionManager = new RawTransactionManager(web3j, credentials,
				200L);
		transactionManager.setTxHashVerifier(txHashVerifier);
		return transactionManager;
	}

	void prepareTransaction(TransactionReceipt transactionReceipt) throws IOException {
		prepareNonceRequest();
		prepareTransactionRequest();
		prepareTransactionReceipt(transactionReceipt);
	}

	@SuppressWarnings("unchecked")
	void prepareNonceRequest() throws IOException {
		PlatoneGetTransactionCount ethGetTransactionCount = new PlatoneGetTransactionCount();
		ethGetTransactionCount.setResult("0x1");

		Request<?, PlatoneGetTransactionCount> transactionCountRequest = mock(Request.class);
		when(transactionCountRequest.send()).thenReturn(ethGetTransactionCount);
		when(web3j.platoneGetTransactionCount(SampleKeys.CREDENTIALS.getAddress(),
				DefaultBlockParameterName.PENDING)).thenReturn((Request) transactionCountRequest);
	}

	@SuppressWarnings("unchecked")
	void prepareTransactionRequest() throws IOException {
		PlatoneSendTransaction ethSendTransaction = new PlatoneSendTransaction();
		ethSendTransaction.setResult(TRANSACTION_HASH);

		Request<?, PlatoneSendTransaction> rawTransactionRequest = mock(Request.class);
		when(rawTransactionRequest.send()).thenReturn(ethSendTransaction);
		when(web3j.platoneSendRawTransaction(any(String.class))).thenReturn((Request) rawTransactionRequest);
	}

	@SuppressWarnings("unchecked")
	void prepareTransactionReceipt(TransactionReceipt transactionReceipt) throws IOException {
		PlatoneGetTransactionReceipt ethGetTransactionReceipt = new PlatoneGetTransactionReceipt();
		ethGetTransactionReceipt.setResult(transactionReceipt);

		Request<?, PlatoneGetTransactionReceipt> getTransactionReceiptRequest = mock(Request.class);
		when(getTransactionReceiptRequest.send()).thenReturn(ethGetTransactionReceipt);
		when(web3j.platoneGetTransactionReceipt(TRANSACTION_HASH)).thenReturn((Request) getTransactionReceiptRequest);
	}

	@SuppressWarnings("unchecked")
	protected TransactionReceipt prepareTransfer() throws IOException {
		TransactionReceipt transactionReceipt = new TransactionReceipt();
		transactionReceipt.setTransactionHash(TRANSACTION_HASH);
		transactionReceipt.setStatus("0x1");
		prepareTransaction(transactionReceipt);

		PlatoneGasPrice ethGasPrice = new PlatoneGasPrice();
		ethGasPrice.setResult("0x1");

		Request<?, PlatoneGasPrice> gasPriceRequest = mock(Request.class);
		when(gasPriceRequest.send()).thenReturn(ethGasPrice);
		when(web3j.platoneGasPrice()).thenReturn((Request) gasPriceRequest);

		return transactionReceipt;
	}
}
