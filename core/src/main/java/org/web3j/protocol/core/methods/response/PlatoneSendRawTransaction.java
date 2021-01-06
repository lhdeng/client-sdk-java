package org.web3j.protocol.core.methods.response;

import org.web3j.protocol.core.Response;

/**
 * eth_sendRawTransaction.
 */
public class PlatoneSendRawTransaction extends Response<String> {
    public String getTransactionHash() {
        return getResult();
    }
}
