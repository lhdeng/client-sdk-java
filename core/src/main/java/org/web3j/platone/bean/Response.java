package org.web3j.platone.bean;

public class Response {
    private int Code;
    private Object Ret;

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public Object getRet() {
        return Ret;
    }

    public void setRet(Object ret) {
        Ret = ret;
    }
}
