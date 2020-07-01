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
public class UserManager extends Contract {
	private static final String BINARY = "";

	public static final String FUNC_ADDUSER = "AddUser";

	public static final String FUNC_DELETEUSER = "DeleteUser";

	public static final String FUNC_DISABLEUSER = "DisableUser";

	public static final String FUNC_ENABLEUSER = "EnableUser";

	public static final String FUNC_GETALL = "GetAll";

	public static final String FUNC_GETBYADDR = "GetByAddr";

	public static final String FUNC_GETBYNAME = "GetByName";

	public static final String FUNC_GETBYSTATUS = "GetByStatus";

	public static final String FUNC_UPDATEUSER = "UpdateUser";

	protected UserManager(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
		super(BINARY, InnerContractEnum.UserManager.getAddress(), web3j, credentials, contractGasProvider, chainId);
	}

	protected UserManager(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider,
			Long chainId) {
		super(BINARY, InnerContractEnum.UserManager.getAddress(), web3j, transactionManager, contractGasProvider,
				chainId);
	}

	public RemoteCall<TransactionReceipt> AddUser(String addr) {
		final Function function = new Function(FUNC_ADDUSER,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(addr)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<TransactionReceipt> DeleteUser(String addr) {
		final Function function = new Function(FUNC_DELETEUSER,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(addr)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<TransactionReceipt> DisableUser(String addr) {
		final Function function = new Function(FUNC_DISABLEUSER,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(addr)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<TransactionReceipt> EnableUser(String addr) {
		final Function function = new Function(FUNC_ENABLEUSER,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(addr)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<String> GetAll(BigInteger pageNum, BigInteger pageSize) {
		final Function function = new Function(FUNC_GETALL,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint32(pageNum),
						new org.web3j.abi.datatypes.generated.Uint32(pageSize)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteCall<String> GetByAddr(String addr) {
		final Function function = new Function(FUNC_GETBYADDR,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(addr)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteCall<String> GetByName(String name) {
		final Function function = new Function(FUNC_GETBYNAME,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteCall<String> GetByStatus(BigInteger status, BigInteger pageNum, BigInteger pageSize) {
		final Function function = new Function(FUNC_GETBYSTATUS,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(status),
						new org.web3j.abi.datatypes.generated.Uint32(pageNum),
						new org.web3j.abi.datatypes.generated.Uint32(pageSize)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteCall<TransactionReceipt> UpdateUser(String addr, String email, String mobile) {
		final Function function = new Function(FUNC_UPDATEUSER,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(addr),
						new org.web3j.abi.datatypes.Utf8String(email), new org.web3j.abi.datatypes.Utf8String(mobile)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public static UserManager load(Web3j web3j, Credentials credentials, GasProvider contractGasProvider,
			Long chainId) {
		return new UserManager(web3j, credentials, contractGasProvider, chainId);
	}

	public static UserManager load(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider,
			Long chainId) {
		return new UserManager(web3j, transactionManager, contractGasProvider, chainId);
	}
}
