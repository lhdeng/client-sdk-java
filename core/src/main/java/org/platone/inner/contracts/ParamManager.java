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
 * <p>Please use the <a href="https://github.com/PlatONEnetwork/client-sdk-java/releases">platone-web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/PlatONEnetwork/client-sdk-java/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version none.
 */
@SuppressWarnings("rawtypes")
public class ParamManager extends Contract {
	private static final String BINARY = "";

	public static final String FUNC_DISABLEDEPLOY = "DisableDeploy";

	public static final String FUNC_ENABLEDEPLOY = "EnableDeploy";

	public static final String FUNC_GETSYSTEMPARAMETER = "GetSystemParameter";

	public static final String FUNC_UPDATEBLOCKGASLIMIT = "UpdateBlockGasLimit";

	public static final String FUNC_UPDATEISPRODUCEEMPTYBLOCK = "UpdateIsProduceEmptyBlock";

	public static final String FUNC_UPDATEISTXUSEGAS = "UpdateIsTxUseGas";

	public static final String FUNC_UPDATESYSTEMPARAMETER = "UpdateSystemParameter";

	public static final String FUNC_UPDATETXGASLIMIT = "UpdateTxGasLimit";

	protected ParamManager(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
		super(BINARY, InnerContractEnum.ParamManager.getAddress(), web3j, credentials, contractGasProvider, chainId);
	}

	protected ParamManager(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
		super(BINARY, InnerContractEnum.ParamManager.getAddress(), web3j, transactionManager, contractGasProvider, chainId);
	}

	public RemoteCall<TransactionReceipt> DisableDeploy() {
		final Function function = new Function(FUNC_DISABLEDEPLOY, Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<TransactionReceipt> EnableDeploy() {
		final Function function = new Function(FUNC_ENABLEDEPLOY, Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<String> GetSystemParameter() {
		final Function function = new Function(FUNC_GETSYSTEMPARAMETER, Arrays.<Type>asList(),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteCall<TransactionReceipt> UpdateBlockGasLimit(BigInteger blockGasLimit) {
		final Function function = new Function(FUNC_UPDATEBLOCKGASLIMIT,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint64(blockGasLimit)), Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<TransactionReceipt> UpdateIsProduceEmptyBlock(Boolean isProduceEmptyBlock) {
		final Function function = new Function(FUNC_UPDATEISPRODUCEEMPTYBLOCK,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Bool(isProduceEmptyBlock)), Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<TransactionReceipt> UpdateIsTxUseGas(Boolean isTxUseGas) {
		final Function function = new Function(FUNC_UPDATEISTXUSEGAS, Arrays.<Type>asList(new org.web3j.abi.datatypes.Bool(isTxUseGas)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<TransactionReceipt> UpdateSystemParameter(BigInteger blockGasLimit, BigInteger txGasLimit, Boolean isTxUseGas,
			Boolean isProduceEmptyBlock, Boolean enableDeploy) {
		final Function function = new Function(FUNC_UPDATESYSTEMPARAMETER,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint64(blockGasLimit),
						new org.web3j.abi.datatypes.generated.Uint64(txGasLimit), new org.web3j.abi.datatypes.Bool(isTxUseGas),
						new org.web3j.abi.datatypes.Bool(isProduceEmptyBlock), new org.web3j.abi.datatypes.Bool(enableDeploy)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<TransactionReceipt> UpdateTxGasLimit(BigInteger txGasLimit) {
		final Function function = new Function(FUNC_UPDATETXGASLIMIT, Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint64(txGasLimit)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public static ParamManager load(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
		return new ParamManager(web3j, credentials, contractGasProvider, chainId);
	}

	public static ParamManager load(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
		return new ParamManager(web3j, transactionManager, contractGasProvider, chainId);
	}
}
