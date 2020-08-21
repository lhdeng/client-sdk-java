package org.platone.common;

public enum UserStatusEnum {
	Unaudited(0), Valid(1), Invalid(2), Disabled(3), Deleted(4);

	private int status;

	private UserStatusEnum(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public static UserStatusEnum getByStat(int status) {
		for (UserStatusEnum tmp : values()) {
			if (tmp.getStatus() == status) {
				return tmp;
			}
		}
		return null;
	}
}
