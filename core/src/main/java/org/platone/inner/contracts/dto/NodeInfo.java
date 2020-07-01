package org.platone.inner.contracts.dto;

public class NodeInfo {
	private String name;
	private String owner;
	private String desc;
	private byte nodeType;
	private String publicKey;
	private String blsPubKey;
	private String externalIp;
	private String internalIp;
	private int rpcPort;
	private int p2pPort;
	private byte status;
	private String approver;
	private long registerTime;

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

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public byte getNodeType() {
		return nodeType;
	}

	public void setNodeType(byte nodeType) {
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

	public String getExternalIp() {
		return externalIp;
	}

	public void setExternalIp(String externalIp) {
		this.externalIp = externalIp;
	}

	public String getInternalIp() {
		return internalIp;
	}

	public void setInternalIp(String internalIp) {
		this.internalIp = internalIp;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public long getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(long registerTime) {
		this.registerTime = registerTime;
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

}
