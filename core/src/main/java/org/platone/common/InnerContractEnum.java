package org.platone.common;

public enum InnerContractEnum {
	NodeRegister("lax1zqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqp3yp7hw"),
	NodeManager("lax1zqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqzlh5ge3"),
	UserRegister("lax1zqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqrzpqayr"),
	UserManager("lax1zqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqyrchd9x"), 
	RoleApply("lax1zqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq97wrcc5"),
	RoleManager("lax1zqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqxsakwkt"),
	ParamManager("lax1zqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq8dtzmte"), 
	Cns("lax1zqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqgjx385p");

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
