package org.platone.inner.contracts.dto;

import java.math.BigInteger;

@Deprecated
public class UserRegInfo {
	private String address;
	private String name;
	private String mobile;
	private String email;
	private String remark;
	private byte auditStatus;
	private String auditor;
	private BigInteger roles;

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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public byte getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(byte auditStatus) {
		this.auditStatus = auditStatus;
	}

	public BigInteger getRoles() {
		return roles;
	}

	public void setRoles(BigInteger roles) {
		this.roles = roles;
	}

}
