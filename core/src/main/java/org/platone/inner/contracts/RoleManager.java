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
public class RoleManager extends Contract {
	private static final String BINARY = "";

	public static final String FUNC_ADDROLE = "AddRole";

	public static final String FUNC_GETINFOBYADDR = "GetInfoByAddr";

	public static final String FUNC_GETINFOBYNAME = "GetInfoByName";

	public static final String FUNC_GETINFOSBYROLE = "GetInfosByRole";

	public static final String FUNC_HASROLE = "HasRole";

	public static final String FUNC_REMOVEROLE = "RemoveRole";

	protected RoleManager(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
		super(BINARY, InnerContractEnum.RoleManager.getAddress(), web3j, credentials, contractGasProvider, chainId);
	}

	protected RoleManager(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider,
			Long chainId) {
		super(BINARY, InnerContractEnum.RoleManager.getAddress(), web3j, transactionManager, contractGasProvider,
				chainId);
	}

	public RemoteCall<TransactionReceipt> AddRole(String userAddr, BigInteger roles) {
		final Function function = new Function(FUNC_ADDROLE,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(userAddr),
						new org.web3j.abi.datatypes.generated.Uint64(roles)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<String> GetInfoByAddr(String userAddr) {
		final Function function = new Function(FUNC_GETINFOBYADDR,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(userAddr)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteCall<String> GetInfoByName(String name) {
		final Function function = new Function(FUNC_GETINFOBYNAME,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteCall<String> GetInfosByRole(BigInteger roles) {
		final Function function = new Function(FUNC_GETINFOSBYROLE,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint64(roles)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteCall<String> HasRole(String userAddr, BigInteger roles) {
		final Function function = new Function(FUNC_HASROLE,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(userAddr),
						new org.web3j.abi.datatypes.generated.Uint64(roles)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteCall<TransactionReceipt> RemoveRole(String userAddr, BigInteger roles) {
		final Function function = new Function(FUNC_REMOVEROLE,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(userAddr),
						new org.web3j.abi.datatypes.generated.Uint64(roles)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public static RoleManager load(Web3j web3j, Credentials credentials, GasProvider contractGasProvider,
			Long chainId) {
		return new RoleManager(web3j, credentials, contractGasProvider, chainId);
	}

	public static RoleManager load(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider,
			Long chainId) {
		return new RoleManager(web3j, transactionManager, contractGasProvider, chainId);
	}
}
