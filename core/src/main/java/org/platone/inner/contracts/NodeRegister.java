package org.platone.inner.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

import org.platone.common.InnerContractEnum;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.GasProvider;

/**
 * <p>
 * Auto generated code.
 * <p>
 * <strong>Do not modify!</strong>
 * <p>
 * Please use the <a href=
 * "https://github.com/PlatONnetwork/client-sdk-java/releases">platon-web3j
 * command line tools</a>, or the
 * org.web3j.codegen.SolidityFunctionWrapperGenerator in the <a href=
 * "https://github.com/PlatONnetwork/client-sdk-java/tree/master/codegen">codegen
 * module</a> to update.
 *
 * <p>
 * Generated with web3j version 0.13.0.9-SNAPSHOT.
 */
@SuppressWarnings("rawtypes")
public class NodeRegister extends Contract {
	private static final String BINARY = "";

	public static final String FUNC_APPROVENODE = "ApproveNode";

	public static final String FUNC_PAGEGETBYSTATUS = "PageGetByStatus";

	public static final String FUNC_REGISTER = "Register";

	public static final String FUNC_GETBYPUBKEY = "GetByPubKey";

	public static final String FUNC_GETBYOWNERADDR = "GetByOwnerAddr";

	protected NodeRegister(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
		super(BINARY, InnerContractEnum.NodeRegister.getAddress(), web3j, credentials, contractGasProvider, chainId);
	}

	protected NodeRegister(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider,
			Long chainId) {
		super(BINARY, InnerContractEnum.NodeRegister.getAddress(), web3j, transactionManager, contractGasProvider,
				chainId);
	}

	public RemoteCall<TransactionReceipt> ApproveNode(String publicKey, BigInteger status) {
		final Function function = new Function(FUNC_APPROVENODE,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(publicKey),
						new org.web3j.abi.datatypes.generated.Uint8(status)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<String> PageGetByStatus(BigInteger status, BigInteger pageNum, BigInteger pageSize) {
		final Function function = new Function(FUNC_PAGEGETBYSTATUS,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(status),
						new org.web3j.abi.datatypes.generated.Uint32(pageNum),
						new org.web3j.abi.datatypes.generated.Uint32(pageSize)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteCall<TransactionReceipt> Register(String registerJson) {
		final Function function = new Function(FUNC_REGISTER,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(registerJson)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<String> GetByPubKey(String publicKey) {
		final Function function = new Function(FUNC_GETBYPUBKEY,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(publicKey)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteCall<String> GetByOwnerAddr(String owner) {
		final Function function = new Function(FUNC_GETBYOWNERADDR,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(owner)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public static NodeRegister load(Web3j web3j, Credentials credentials, GasProvider contractGasProvider,
			Long chainId) {
		return new NodeRegister(web3j, credentials, contractGasProvider, chainId);
	}

	public static NodeRegister load(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider,
			Long chainId) {
		return new NodeRegister(web3j, transactionManager, contractGasProvider, chainId);
	}
}
