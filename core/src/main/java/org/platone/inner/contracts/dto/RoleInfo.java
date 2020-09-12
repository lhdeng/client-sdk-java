package org.platone.inner.contracts.dto;

import java.math.BigInteger;

@Deprecated
public class RoleInfo {
	private String address;
	private String name;
	private BigInteger roles;
	private byte status;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

}
