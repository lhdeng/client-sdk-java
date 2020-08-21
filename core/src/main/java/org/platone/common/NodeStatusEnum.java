package org.platone.common;

public enum NodeStatusEnum {
	Unaudited(0), Valid(1), Invalid(2), Disabled(3), Deleted(4);

	private int status;

	private NodeStatusEnum(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public static NodeStatusEnum getByStat(int status) {
		for (NodeStatusEnum tmp : values()) {
			if (tmp.getStatus() == status) {
				return tmp;
			}
		}
		return null;
	}
}
