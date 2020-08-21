package org.platone.common;

public enum AuditStatusEnum {
	Passed(1), Rejected(2);

	private int status;

	private AuditStatusEnum(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public static AuditStatusEnum getByStat(int status) {
		for (AuditStatusEnum tmp : values()) {
			if (tmp.getStatus() == status) {
				return tmp;
			}
		}
		return null;
	}
}
