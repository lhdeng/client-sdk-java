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
 * Please use the <a href="https://github.com/PlatONnetwork/client-sdk-java/releases">platon-web3j command line
 * tools</a>, or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/PlatONnetwork/client-sdk-java/tree/master/codegen">codegen module</a> to update.
 *
 * <p>
 * Generated with web3j version none.
 */
@SuppressWarnings("rawtypes")
public class NodeManager extends Contract {
    private static final String BINARY = "";

    public static final String FUNC_ADD = "Add";

    public static final String FUNC_APPLY = "Apply";

    public static final String FUNC_AUDIT = "Audit";

    public static final String FUNC_DELETE = "Delete";

    public static final String FUNC_DISABLE = "Disable";

    public static final String FUNC_ENABLE = "Enable";

    public static final String FUNC_GETBYNAME = "GetByName";

    public static final String FUNC_GETBYPUBLICKEY = "GetByPublicKey";

    public static final String FUNC_GETCONSENSUSNODETHRESHOLD = "GetConsensusNodeThreshold";

    public static final String FUNC_LISTALL = "ListAll";

    public static final String FUNC_LISTBYHOSTADDRESS = "ListByHostAddress";

    public static final String FUNC_LISTBYOWNER = "ListByOwner";

    public static final String FUNC_LISTBYSTAT = "ListByStat";

    public static final String FUNC_LISTBYTYPE = "ListByType";

    public static final String FUNC_SETCONSENSUSNODETHRESHOLD = "SetConsensusNodeThreshold";

    public static final String FUNC_UPDATE = "Update";

    public static final String FUNC_UPDATETYPE = "UpdateType";

    protected NodeManager(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, InnerContractEnum.NodeManager.getAddress(), web3j, credentials, contractGasProvider, chainId);
    }

    protected NodeManager(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider,
        Long chainId) {
        super(BINARY, InnerContractEnum.NodeManager.getAddress(), web3j, transactionManager, contractGasProvider,
            chainId);
    }

    public RemoteCall<TransactionReceipt> Add(String name, String owner, String desc, String publicKey,
        String blsPubKey, String hostAddress, BigInteger rpcPort, BigInteger p2pPort) {
        final Function function = new Function(FUNC_ADD,
            Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name),
                new org.web3j.abi.datatypes.Address(owner), new org.web3j.abi.datatypes.Utf8String(desc),
                new org.web3j.abi.datatypes.Utf8String(publicKey), new org.web3j.abi.datatypes.Utf8String(blsPubKey),
                new org.web3j.abi.datatypes.Utf8String(hostAddress),
                new org.web3j.abi.datatypes.generated.Uint16(rpcPort),
                new org.web3j.abi.datatypes.generated.Uint16(p2pPort)),
            Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> Apply(String name, String desc, String publicKey, String blsPubKey,
        String hostAddress, BigInteger rpcPort, BigInteger p2pPort) {
        final Function function = new Function(FUNC_APPLY,
            Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name),
                new org.web3j.abi.datatypes.Utf8String(desc), new org.web3j.abi.datatypes.Utf8String(publicKey),
                new org.web3j.abi.datatypes.Utf8String(blsPubKey), new org.web3j.abi.datatypes.Utf8String(hostAddress),
                new org.web3j.abi.datatypes.generated.Uint16(rpcPort),
                new org.web3j.abi.datatypes.generated.Uint16(p2pPort)),
            Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> Audit(String name, BigInteger auditStat, String auditReason) {
        final Function function = new Function(FUNC_AUDIT,
            Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name),
                new org.web3j.abi.datatypes.generated.Uint8(auditStat),
                new org.web3j.abi.datatypes.Utf8String(auditReason)),
            Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> Delete(String name) {
        final Function function =
            new Function(FUNC_DELETE, Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> Disable(String name) {
        final Function function =
            new Function(FUNC_DISABLE, Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> Enable(String name) {
        final Function function =
            new Function(FUNC_ENABLE, Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> GetByName(String name) {
        final Function function =
            new Function(FUNC_GETBYNAME, Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> GetByPublicKey(String publicKey) {
        final Function function =
            new Function(FUNC_GETBYPUBLICKEY, Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(publicKey)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> GetConsensusNodeThreshold() {
        final Function function = new Function(FUNC_GETCONSENSUSNODETHRESHOLD, Arrays.<Type>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> ListAll() {
        final Function function = new Function(FUNC_LISTALL, Arrays.<Type>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> ListByHostAddress(String hostAddress) {
        final Function function = new Function(FUNC_LISTBYHOSTADDRESS,
            Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(hostAddress)),
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> ListByOwner(String owner) {
        final Function function =
            new Function(FUNC_LISTBYOWNER, Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(owner)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> ListByStat(BigInteger status) {
        final Function function =
            new Function(FUNC_LISTBYSTAT, Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(status)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> ListByType(BigInteger nodeType) {
        final Function function =
            new Function(FUNC_LISTBYTYPE, Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(nodeType)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> SetConsensusNodeThreshold(BigInteger threshold) {
        final Function function = new Function(FUNC_SETCONSENSUSNODETHRESHOLD,
            Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint32(threshold)),
            Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> Update(String name, String hostAddress, BigInteger rpcPort,
        BigInteger p2pPort, String desc) {
        final Function function = new Function(FUNC_UPDATE,
            Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name),
                new org.web3j.abi.datatypes.Utf8String(hostAddress),
                new org.web3j.abi.datatypes.generated.Uint16(rpcPort),
                new org.web3j.abi.datatypes.generated.Uint16(p2pPort), new org.web3j.abi.datatypes.Utf8String(desc)),
            Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> UpdateType(String name, BigInteger nodeType) {
        final Function function =
            new Function(FUNC_UPDATETYPE, Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name),
                new org.web3j.abi.datatypes.generated.Uint8(nodeType)), Collections.<TypeReference<?>>emptyList());
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
