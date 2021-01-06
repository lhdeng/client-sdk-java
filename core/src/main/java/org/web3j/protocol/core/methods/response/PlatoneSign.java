package org.web3j.protocol.core.methods.response;

import org.web3j.protocol.core.Response;

/**
 * eth_sign.
 */
public class PlatoneSign extends Response<String> {
    public String getSignature() {
        return getResult();
    }
}
