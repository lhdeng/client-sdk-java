package org.web3j.protocol.core;

import java.math.BigInteger;

import org.web3j.protocol.core.methods.request.ShhFilter;
import org.web3j.protocol.core.methods.response.*;

/**
 * Core Ethereum JSON-RPC API.
 */
public interface Platone {
    Request<?, Web3ClientVersion> web3ClientVersion();

    Request<?, Web3Sha3> web3Sha3(String data);

    Request<?, NetVersion> netVersion();

    Request<?, NetListening> netListening();

    Request<?, NetPeerCount> netPeerCount();

    Request<?, PlatoneProtocolVersion> platoneProtocolVersion();

    Request<?, PlatoneSyncing> platoneSyncing();

    Request<?, PlatoneGasPrice> platoneGasPrice();

    Request<?, PlatoneAccounts> platoneAccounts();

    Request<?, PlatoneBlockNumber> platoneBlockNumber();

    Request<?, PlatoneGetBalance> platoneGetBalance(
            String address, DefaultBlockParameter defaultBlockParameter);

    Request<?, PlatoneGetStorageAt> platoneGetStorageAt(
            String address, BigInteger position,
            DefaultBlockParameter defaultBlockParameter);

    Request<?, PlatoneGetTransactionCount> platoneGetTransactionCount(
            String address, DefaultBlockParameter defaultBlockParameter);

    Request<?, PlatoneGetBlockTransactionCountByHash> platoneGetBlockTransactionCountByHash(
            String blockHash);

    Request<?, PlatoneGetBlockTransactionCountByNumber> platoneGetBlockTransactionCountByNumber(
            DefaultBlockParameter defaultBlockParameter);

    Request<?, PlatoneGetCode> platoneGetCode(String address, DefaultBlockParameter defaultBlockParameter);

    Request<?, PlatoneSign> platoneSign(String address, String sha3HashOfDataToSign);

    Request<?, PlatoneSendTransaction> platoneSendTransaction(
            org.web3j.protocol.core.methods.request.Transaction transaction);

    Request<?, PlatoneSendTransaction> platoneSendRawTransaction(
            String signedTransactionData);

    Request<?, PlatoneCall> platoneCall(
            org.web3j.protocol.core.methods.request.Transaction transaction,
            DefaultBlockParameter defaultBlockParameter);

    Request<?, PlatoneEstimateGas> platoneEstimateGas(
            org.web3j.protocol.core.methods.request.Transaction transaction);

    Request<?, PlatoneBlock> platoneGetBlockByHash(String blockHash, boolean returnFullTransactionObjects);

    Request<?, PlatoneBlock> platoneGetBlockByNumber(
            DefaultBlockParameter defaultBlockParameter,
            boolean returnFullTransactionObjects);

    Request<?, PlatoneTransaction> platoneGetTransactionByHash(String transactionHash);

    Request<?, PlatoneTransaction> platoneGetTransactionByBlockHashAndIndex(
            String blockHash, BigInteger transactionIndex);

    Request<?, PlatoneTransaction> platoneGetTransactionByBlockNumberAndIndex(
            DefaultBlockParameter defaultBlockParameter, BigInteger transactionIndex);

    Request<?, PlatoneGetTransactionReceipt> platoneGetTransactionReceipt(String transactionHash);

    Request<?, PlatoneFilter> platoneNewFilter(org.web3j.protocol.core.methods.request.PlatoneFilter ethFilter);

    Request<?, PlatoneFilter> platoneNewBlockFilter();

    Request<?, PlatoneFilter> platoneNewPendingTransactionFilter();

    Request<?, PlatoneUninstallFilter> platoneUninstallFilter(BigInteger filterId);

    Request<?, PlatoneLog> platoneGetFilterChanges(BigInteger filterId);

    Request<?, PlatoneLog> platoneGetFilterLogs(BigInteger filterId);

    Request<?, PlatoneLog> platoneGetLogs(org.web3j.protocol.core.methods.request.PlatoneFilter ethFilter);

    Request<?, PlatonePendingTransactions> platonePendingTx();

    Request<?, DbPutString> dbPutString(String databaseName, String keyName, String stringToStore);

    Request<?, DbGetString> dbGetString(String databaseName, String keyName);

    Request<?, DbPutHex> dbPutHex(String databaseName, String keyName, String dataToStore);

    Request<?, DbGetHex> dbGetHex(String databaseName, String keyName);

    Request<?, org.web3j.protocol.core.methods.response.ShhPost> shhPost(
            org.web3j.protocol.core.methods.request.ShhPost shhPost);

    Request<?, ShhVersion> shhVersion();

    Request<?, ShhNewIdentity> shhNewIdentity();

    Request<?, ShhHasIdentity> shhHasIdentity(String identityAddress);

    Request<?, ShhNewGroup> shhNewGroup();

    Request<?, ShhAddToGroup> shhAddToGroup(String identityAddress);

    Request<?, ShhNewFilter> shhNewFilter(ShhFilter shhFilter);

    Request<?, ShhUninstallFilter> shhUninstallFilter(BigInteger filterId);

    Request<?, ShhMessages> shhGetFilterChanges(BigInteger filterId);

    Request<?, ShhMessages> shhGetMessages(BigInteger filterId);

    Request<?, PlatoneEvidences> platoneEvidences();
    
    Request<?, AdminProgramVersion> getProgramVersion();
    
    Request<?, AdminSchnorrNIZKProve> getSchnorrNIZKProve();
    
    Request<?, DebugEconomicConfig> getEconomicConfig();
}
