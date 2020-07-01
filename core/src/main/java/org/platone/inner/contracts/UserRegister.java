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
public class UserRegister extends Contract {
	private static final String BINARY = "";

	public static final String FUNC_APPROVE = "Approve";

	public static final String FUNC_GETALLREGUSER = "GetAllRegUser";

	public static final String FUNC_GETREGUSERBYADDR = "GetRegUserByAddr";

	public static final String FUNC_GETREGUSERBYNAME = "GetRegUserByName";

	public static final String FUNC_GETREGUSERBYSTAT = "GetRegUserByStat";

	public static final String FUNC_REGISTER = "Register";

	protected UserRegister(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
		super(BINARY, InnerContractEnum.UserRegister.getAddress(), web3j, credentials, contractGasProvider, chainId);
	}

	protected UserRegister(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider,
			Long chainId) {
		super(BINARY, InnerContractEnum.UserRegister.getAddress(), web3j, transactionManager, contractGasProvider,
				chainId);
	}

	public RemoteCall<TransactionReceipt> Approve(String addr, BigInteger auditStatus) {
		final Function function = new Function(FUNC_APPROVE,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(addr),
						new org.web3j.abi.datatypes.generated.Uint8(auditStatus)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<String> GetAllRegUser(BigInteger pageNum, BigInteger pageSize) {
		final Function function = new Function(FUNC_GETALLREGUSER,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint32(pageNum),
						new org.web3j.abi.datatypes.generated.Uint32(pageSize)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteCall<String> GetRegUserByAddr(String addr) {
		final Function function = new Function(FUNC_GETREGUSERBYADDR,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(addr)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteCall<String> GetRegUserByName(String name) {
		final Function function = new Function(FUNC_GETREGUSERBYNAME,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteCall<String> GetRegUserByStat(BigInteger pageNum, BigInteger pageSize, BigInteger status) {
		final Function function = new Function(FUNC_GETREGUSERBYSTAT,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint32(pageNum),
						new org.web3j.abi.datatypes.generated.Uint32(pageSize),
						new org.web3j.abi.datatypes.generated.Uint8(status)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteCall<TransactionReceipt> Register(String userRegJson) {
		final Function function = new Function(FUNC_REGISTER,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(userRegJson)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public static UserRegister load(Web3j web3j, Credentials credentials, GasProvider contractGasProvider,
			Long chainId) {
		return new UserRegister(web3j, credentials, contractGasProvider, chainId);
	}

	public static UserRegister load(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider,
			Long chainId) {
		return new UserRegister(web3j, transactionManager, contractGasProvider, chainId);
	}
}
