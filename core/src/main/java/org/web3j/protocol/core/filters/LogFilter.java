package org.web3j.protocol.core.filters;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.response.PlatoneFilter;
import org.web3j.protocol.core.methods.response.PlatoneLog;
import org.web3j.protocol.core.methods.response.Log;

/**
 * Log filter handler.
 */
public class LogFilter extends Filter<Log> {

    private final org.web3j.protocol.core.methods.request.PlatoneFilter ethFilter;

    public LogFilter(
            Web3j web3j, Callback<Log> callback,
            org.web3j.protocol.core.methods.request.PlatoneFilter ethFilter) {
        super(web3j, callback);
        this.ethFilter = ethFilter;
    }


    @Override
    PlatoneFilter sendRequest() throws IOException {
        return web3j.platoneNewFilter(ethFilter).send();
    }

    @Override
    void process(List<PlatoneLog.LogResult> logResults) {
        for (PlatoneLog.LogResult logResult : logResults) {
            if (logResult instanceof PlatoneLog.LogObject) {
                Log log = ((PlatoneLog.LogObject) logResult).get();
                callback.onEvent(log);
            } else {
                throw new FilterException(
                        "Unexpected result type: " + logResult.get() + " required LogObject");
            }
        }
    }

    @Override
    protected Optional<Request<?, PlatoneLog>> getFilterLogs(BigInteger filterId) {
        return Optional.of(web3j.platoneGetFilterLogs(filterId));
    }
}
