package org.platone.inner.contracts.dto;

import java.math.BigInteger;

@Deprecated
public class UserRegReq {
	private String name;
	private String mobile;
	private String email;
	private String remark;
	private BigInteger roles;

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

	public BigInteger getRoles() {
		return roles;
	}

	public void setRoles(BigInteger roles) {
		this.roles = roles;
	}

}
