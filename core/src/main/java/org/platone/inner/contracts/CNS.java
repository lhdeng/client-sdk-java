package org.platone.inner.contracts;

import java.util.Arrays;
import java.util.Collections;

import org.platone.common.InnerContractEnum;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
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
public class CNS extends Contract {
	private static final String BINARY = "";

	public static final String FUNC_GETALLCONTRACTS = "GetAllContracts";

	public static final String FUNC_GETCONTRACTADDRESS = "GetContractAddress";

	public static final String FUNC_GETCONTRACTSBYADDR = "GetContractsByAddr";

	public static final String FUNC_GETCONTRACTSBYOWNER = "GetContractsByOwner";

	public static final String FUNC_REGISTER = "Register";

	public static final String FUNC_UNREGISTER = "Unregister";

	protected CNS(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
		super(BINARY, InnerContractEnum.Cns.getAddress(), web3j, credentials, contractGasProvider, chainId);
	}

	protected CNS(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
		super(BINARY, InnerContractEnum.Cns.getAddress(), web3j, transactionManager, contractGasProvider, chainId);
	}

	public RemoteCall<String> GetAllContracts() {
		final Function function = new Function(FUNC_GETALLCONTRACTS, Arrays.<Type>asList(),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteCall<String> GetContractAddress(String name, String version) {
		final Function function = new Function(FUNC_GETCONTRACTADDRESS,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name),
						new org.web3j.abi.datatypes.Utf8String(version)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteCall<String> GetContractsByAddr(String addr) {
		final Function function = new Function(FUNC_GETCONTRACTSBYADDR,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(addr)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteCall<String> GetContractsByOwner(String addr) {
		final Function function = new Function(FUNC_GETCONTRACTSBYOWNER,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(addr)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteCall<TransactionReceipt> Register(String name, String version, String addr) {
		final Function function = new Function(FUNC_REGISTER,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name),
						new org.web3j.abi.datatypes.Utf8String(version), new org.web3j.abi.datatypes.Address(addr)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<TransactionReceipt> Unregister(String name, String version) {
		final Function function = new Function(FUNC_UNREGISTER,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name),
						new org.web3j.abi.datatypes.Utf8String(version)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public static CNS load(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
		return new CNS(web3j, credentials, contractGasProvider, chainId);
	}

	public static CNS load(Web3j web3j, TransactionManager transactionManager,
			GasProvider contractGasProvider, Long chainId) {
		return new CNS(web3j, transactionManager, contractGasProvider, chainId);
	}
}
