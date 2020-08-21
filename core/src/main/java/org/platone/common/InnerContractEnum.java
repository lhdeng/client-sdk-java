package org.platone.common;

public enum InnerContractEnum {
	NodeManager("lax1zqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqp3yp7hw"), 
	UserManager("lax1zqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqzlh5ge3"),
	ParamManager("lax1zqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqrzpqayr"), 
	Cns("lax1zqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqyrchd9x");

	private InnerContractEnum(String address) {
		this.address = address;
	}

	private String address;

	public String getAddress() {
		return address;
	}

	public static InnerContractEnum getByAddress(String address) {
		for (InnerContractEnum tmp : values()) {
			if (tmp.getAddress().equals(address)) {
				return tmp;
			}
		}

		return null;
	}

}
