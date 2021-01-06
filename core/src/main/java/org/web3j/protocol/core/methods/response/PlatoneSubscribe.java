package org.web3j.protocol.core.methods.response;

import org.web3j.protocol.core.Response;

public class PlatoneSubscribe extends Response<String> {
    public String getSubscriptionId() {
        return getResult();
    }
}
