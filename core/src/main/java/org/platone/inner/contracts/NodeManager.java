package org.platone.inner.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

import org.platone.common.InnerContractEnum;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Int32;
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
public class NodeManager extends Contract {
	private static final String BINARY = "";

	public static final String FUNC_ADD = "Add";

	public static final String FUNC_COUNT = "Count";

	public static final String FUNC_GETALL = "GetAll";

	public static final String FUNC_GETDELETEDNODES = "GetDeletedNodes";

	public static final String FUNC_GETNODES = "GetNodes";

	public static final String FUNC_GETNORMALNODES = "GetNormalNodes";

	public static final String FUNC_UPDATE = "Update";

	protected NodeManager(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
		super(BINARY, InnerContractEnum.NodeManager.getAddress(), web3j, credentials, contractGasProvider, chainId);
	}

	protected NodeManager(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider,
			Long chainId) {
		super(BINARY, InnerContractEnum.NodeManager.getAddress(), web3j, transactionManager, contractGasProvider,
				chainId);
	}

	public RemoteCall<TransactionReceipt> Add(String nodeJson) {
		final Function function = new Function(FUNC_ADD,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(nodeJson)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<BigInteger> Count(String name, String owner, BigInteger nodeType, BigInteger status,
			String approver, BigInteger registerTimeBegin, BigInteger registerTimeEnd) {
		final Function function = new Function(FUNC_COUNT, Arrays.<Type>asList(
				new org.web3j.abi.datatypes.Utf8String(name), new org.web3j.abi.datatypes.Address(owner),
				new org.web3j.abi.datatypes.generated.Uint8(nodeType),
				new org.web3j.abi.datatypes.generated.Uint8(status), new org.web3j.abi.datatypes.Address(approver),
				new org.web3j.abi.datatypes.generated.Uint64(registerTimeBegin),
				new org.web3j.abi.datatypes.generated.Uint64(registerTimeEnd)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Int32>() {
				}));
		return executeRemoteCallSingleValueReturn(function, BigInteger.class);
	}

	public RemoteCall<String> GetAll() {
		final Function function = new Function(FUNC_GETALL, Arrays.<Type>asList(),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteCall<String> GetDeletedNodes() {
		final Function function = new Function(FUNC_GETDELETEDNODES, Arrays.<Type>asList(),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteCall<String> GetNodes(String name, String owner, BigInteger nodeType, BigInteger status,
			String approver) {
		final Function function = new Function(FUNC_GETNODES, Arrays.<Type>asList(
				new org.web3j.abi.datatypes.Utf8String(name), new org.web3j.abi.datatypes.Address(owner),
				new org.web3j.abi.datatypes.generated.Uint8(nodeType),
				new org.web3j.abi.datatypes.generated.Uint8(status), new org.web3j.abi.datatypes.Address(approver)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteCall<String> GetNormalNodes() {
		final Function function = new Function(FUNC_GETNORMALNODES, Arrays.<Type>asList(),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteCall<TransactionReceipt> Update(String name, String desc, BigInteger nodeType, BigInteger status) {
		final Function function = new Function(FUNC_UPDATE,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name),
						new org.web3j.abi.datatypes.Utf8String(desc),
						new org.web3j.abi.datatypes.generated.Uint8(nodeType),
						new org.web3j.abi.datatypes.generated.Uint8(status)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public static NodeManager load(Web3j web3j, Credentials credentials, GasProvider contractGasProvider,
			Long chainId) {
		return new NodeManager(web3j, credentials, contractGasProvider, chainId);
	}

	public static NodeManager load(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider,
			Long chainId) {
		return new NodeManager(web3j, transactionManager, contractGasProvider, chainId);
	}
}
