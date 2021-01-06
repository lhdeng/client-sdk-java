package org.web3j.protocol.core.methods.response;

import org.web3j.protocol.core.Response;

/**
 * eth_protocolVersion.
 */
public class PlatoneProtocolVersion extends Response<String> {
    public String getProtocolVersion() {
        return getResult();
    }
}
