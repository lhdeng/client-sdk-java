package org.web3j.protocol.core.methods.response;

import org.web3j.protocol.core.Response;

/**
 * eth_uninstallFilter.
 */
public class PlatoneUninstallFilter extends Response<Boolean> {
    public boolean isUninstalled() {
        return getResult();
    }
}
