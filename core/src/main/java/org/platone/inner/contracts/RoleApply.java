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
public class RoleApply extends Contract {
	private static final String BINARY = "";

	public static final String FUNC_GETBYSTATUS = "GetByStatus";

	public static final String FUNC_APPROVE = "Approve";

	public static final String FUNC_GETBYNAME = "GetByName";

	public static final String FUNC_GETBYADDR = "GetByAddr";

	public static final String FUNC_APPLY = "Apply";

	protected RoleApply(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
		super(BINARY, InnerContractEnum.RoleApply.getAddress(), web3j, credentials, contractGasProvider, chainId);
	}

	protected RoleApply(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider,
			Long chainId) {
		super(BINARY, InnerContractEnum.RoleApply.getAddress(), web3j, transactionManager, contractGasProvider,
				chainId);
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

	public RemoteCall<TransactionReceipt> Approve(String addr, BigInteger status) {
		final Function function = new Function(FUNC_APPROVE,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(addr),
						new org.web3j.abi.datatypes.generated.Uint8(status)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<String> GetByName(String name) {
		final Function function = new Function(FUNC_GETBYNAME,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name)),
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

	public RemoteCall<TransactionReceipt> Apply(BigInteger roles) {
		final Function function = new Function(FUNC_APPLY,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint64(roles)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public static RoleApply load(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
		return new RoleApply(web3j, credentials, contractGasProvider, chainId);
	}

	public static RoleApply load(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider,
			Long chainId) {
		return new RoleApply(web3j, transactionManager, contractGasProvider, chainId);
	}
}
