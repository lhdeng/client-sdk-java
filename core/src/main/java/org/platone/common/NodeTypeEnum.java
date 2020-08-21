package org.platone.common;

public enum NodeTypeEnum {
	ConsensusNode(1), ObserverNode(2);

	private int type;

	private NodeTypeEnum(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public static NodeTypeEnum getByType(int type) {
		for (NodeTypeEnum tmp : values()) {
			if (tmp.getType() == type) {
				return tmp;
			}
		}
		return null;
	}
}
