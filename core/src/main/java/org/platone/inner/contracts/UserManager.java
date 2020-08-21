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
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://github.com/PlatONnetwork/client-sdk-java/releases">platon-web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/PlatONnetwork/client-sdk-java/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version none.
 */
@SuppressWarnings("rawtypes")
public class UserManager extends Contract {
	private static final String BINARY = "";

	public static final String FUNC_ADD = "Add";

	public static final String FUNC_ADDROLES = "AddRoles";

	public static final String FUNC_AUDIT = "Audit";

	public static final String FUNC_DELETE = "Delete";

	public static final String FUNC_DISABLE = "Disable";

	public static final String FUNC_ENABLE = "Enable";

	public static final String FUNC_GETBYADDR = "GetByAddr";

	public static final String FUNC_GETBYNAME = "GetByName";

	public static final String FUNC_HASROLES = "HasRoles";

	public static final String FUNC_PAGEALL = "PageAll";

	public static final String FUNC_PAGEBYROLES = "PageByRoles";

	public static final String FUNC_PAGEBYSTAT = "PageByStat";

	public static final String FUNC_REGISTER = "Register";

	public static final String FUNC_REMOVEROLES = "RemoveRoles";

	public static final String FUNC_SETROLES = "SetRoles";

	public static final String FUNC_UPDATE = "Update";

	protected UserManager(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
		super(BINARY, InnerContractEnum.UserManager.getAddress(), web3j, credentials, contractGasProvider, chainId);
	}

	protected UserManager(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
		super(BINARY, InnerContractEnum.UserManager.getAddress(), web3j, transactionManager, contractGasProvider, chainId);
	}

	public RemoteCall<TransactionReceipt> Add(String addr, String name, String mobile, String email, String desc, BigInteger roles) {
		final Function function = new Function(FUNC_ADD,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(addr), new org.web3j.abi.datatypes.Utf8String(name),
						new org.web3j.abi.datatypes.Utf8String(mobile), new org.web3j.abi.datatypes.Utf8String(email),
						new org.web3j.abi.datatypes.Utf8String(desc), new org.web3j.abi.datatypes.generated.Uint64(roles)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<TransactionReceipt> AddRoles(String addr, BigInteger roles) {
		final Function function = new Function(FUNC_ADDROLES,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(addr), new org.web3j.abi.datatypes.generated.Uint64(roles)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<TransactionReceipt> Audit(String addr, BigInteger auditStat, String auditReason) {
		final Function function = new Function(FUNC_AUDIT, Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(addr),
				new org.web3j.abi.datatypes.generated.Uint8(auditStat), new org.web3j.abi.datatypes.Utf8String(auditReason)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<TransactionReceipt> Delete(String addr) {
		final Function function = new Function(FUNC_DELETE, Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(addr)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<TransactionReceipt> Disable(String addr) {
		final Function function = new Function(FUNC_DISABLE, Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(addr)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<TransactionReceipt> Enable(String addr) {
		final Function function = new Function(FUNC_ENABLE, Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(addr)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<String> GetByAddr(String addr) {
		final Function function = new Function(FUNC_GETBYADDR, Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(addr)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteCall<String> GetByName(String name) {
		final Function function = new Function(FUNC_GETBYNAME, Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteCall<String> HasRoles(String addr, BigInteger roles) {
		final Function function = new Function(FUNC_HASROLES,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(addr), new org.web3j.abi.datatypes.generated.Uint64(roles)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteCall<String> PageAll(BigInteger pageNum, BigInteger pageSize) {
		final Function function = new Function(FUNC_PAGEALL,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint32(pageNum), new org.web3j.abi.datatypes.generated.Uint32(pageSize)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteCall<String> PageByRoles(BigInteger roles, BigInteger pageNum, BigInteger pageSize) {
		final Function function = new Function(
				FUNC_PAGEBYROLES, Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint64(roles),
						new org.web3j.abi.datatypes.generated.Uint32(pageNum), new org.web3j.abi.datatypes.generated.Uint32(pageSize)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteCall<String> PageByStat(BigInteger status, BigInteger pageNum, BigInteger pageSize) {
		final Function function = new Function(
				FUNC_PAGEBYSTAT, Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(status),
						new org.web3j.abi.datatypes.generated.Uint32(pageNum), new org.web3j.abi.datatypes.generated.Uint32(pageSize)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteCall<TransactionReceipt> Register(String name, String mobile, String email, String desc, BigInteger roles) {
		final Function function = new Function(FUNC_REGISTER,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), new org.web3j.abi.datatypes.Utf8String(mobile),
						new org.web3j.abi.datatypes.Utf8String(email), new org.web3j.abi.datatypes.Utf8String(desc),
						new org.web3j.abi.datatypes.generated.Uint64(roles)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<TransactionReceipt> RemoveRoles(String addr, BigInteger roles) {
		final Function function = new Function(FUNC_REMOVEROLES,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(addr), new org.web3j.abi.datatypes.generated.Uint64(roles)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<TransactionReceipt> SetRoles(String addr, BigInteger roles) {
		final Function function = new Function(FUNC_SETROLES,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(addr), new org.web3j.abi.datatypes.generated.Uint64(roles)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<TransactionReceipt> Update(String addr, String mobile, String email, String desc) {
		final Function function = new Function(FUNC_UPDATE,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(addr), new org.web3j.abi.datatypes.Utf8String(mobile),
						new org.web3j.abi.datatypes.Utf8String(email), new org.web3j.abi.datatypes.Utf8String(desc)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public static UserManager load(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
		return new UserManager(web3j, credentials, contractGasProvider, chainId);
	}

	public static UserManager load(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
		return new UserManager(web3j, transactionManager, contractGasProvider, chainId);
	}

}
