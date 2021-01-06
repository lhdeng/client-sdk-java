package org.web3j.protocol.core.methods.response;

import org.web3j.platone.bean.Evidences;
import org.web3j.protocol.core.Response;

import com.alibaba.fastjson.JSON;

/**
 * platon_evidences.
 */
public class PlatoneEvidences extends Response<String> {

    public String getEvidencesStr() {
        return getResult();
    }
    
    public Evidences getEvidences() {    	
    	return JSON.parseObject(getResult(), Evidences.class); 
    }
}
