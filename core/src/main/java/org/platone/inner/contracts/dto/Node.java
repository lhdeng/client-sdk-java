package org.platone.inner.contracts.dto;

public class Node {
    private String name;
    private String owner;
    private String desc;
    private int nodeType;
    private String publicKey;
    private String blsPubKey;
    private String hostAddress;
    private int rpcPort;
    private int p2pPort;
    private int status;
    private boolean root;
    private long createTime;
    private long updateTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getNodeType() {
        return nodeType;
    }

    public void setNodeType(int nodeType) {
        this.nodeType = nodeType;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getBlsPubKey() {
        return blsPubKey;
    }

    public void setBlsPubKey(String blsPubKey) {
        this.blsPubKey = blsPubKey;
    }

    public String getHostAddress() {
        return hostAddress;
    }

    public void setHostAddress(String hostAddress) {
        this.hostAddress = hostAddress;
    }

    public int getRpcPort() {
        return rpcPort;
    }

    public void setRpcPort(int rpcPort) {
        this.rpcPort = rpcPort;
    }

    public int getP2pPort() {
        return p2pPort;
    }

    public void setP2pPort(int p2pPort) {
        this.p2pPort = p2pPort;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isRoot() {
        return root;
    }

    public void setRoot(boolean root) {
        this.root = root;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Node [name=" + name + ", owner=" + owner + ", desc=" + desc + ", nodeType=" + nodeType + ", publicKey="
            + publicKey + ", blsPubKey=" + blsPubKey + ", hostAddress=" + hostAddress + ", rpcPort=" + rpcPort
            + ", p2pPort=" + p2pPort + ", status=" + status + ", root=" + root + ", createTime=" + createTime
            + ", updateTime=" + updateTime + "]";
    }

}
