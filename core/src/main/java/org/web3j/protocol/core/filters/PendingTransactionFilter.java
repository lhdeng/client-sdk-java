package org.web3j.protocol.core.filters;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.response.PlatoneFilter;
import org.web3j.protocol.core.methods.response.PlatoneLog;

/**
 * Handler for working with transaction filter requests.
 */
public class PendingTransactionFilter extends Filter<String> {

    public PendingTransactionFilter(Web3j web3j, Callback<String> callback) {
        super(web3j, callback);
    }

    @Override
    PlatoneFilter sendRequest() throws IOException {
        return web3j.platoneNewPendingTransactionFilter().send();
    }

    @Override
    void process(List<PlatoneLog.LogResult> logResults) {
        for (PlatoneLog.LogResult logResult : logResults) {
            if (logResult instanceof PlatoneLog.Hash) {
                String transactionHash = ((PlatoneLog.Hash) logResult).get();
                callback.onEvent(transactionHash);
            } else {
                throw new FilterException(
                        "Unexpected result type: " + logResult.get() + ", required Hash");
            }
        }
    }

    /**
     * Since the pending transaction filter does not support historic filters,
     * the filterId is ignored and an empty optional is returned
     * @param filterId
     * Id of the filter for which the historic log should be retrieved
     * @return
     * Optional.empty()
     */
    @Override
    protected Optional<Request<?, PlatoneLog>> getFilterLogs(BigInteger filterId) {
        return Optional.empty();
    }
}

