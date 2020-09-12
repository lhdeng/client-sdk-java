package org.platone.inner.contracts.dto;

import java.math.BigInteger;

@Deprecated
public class RoleApplyInfo {
	private String address;
	private String name;
	private BigInteger roles;
	private byte auditStatus;
	private String auditor;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigInteger getRoles() {
		return roles;
	}

	public void setRoles(BigInteger roles) {
		this.roles = roles;
	}

	public byte getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(byte auditStatus) {
		this.auditStatus = auditStatus;
	}

}
