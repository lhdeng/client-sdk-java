package org.platone.common;

import java.math.BigInteger;

/**
 * User role enum
 * 
 * The value of the user role uses the uint64 type.
 * 
 * @author lhdeng
 *
 */
public enum RoleEnum {
	ChainCreator(new BigInteger("8000000000000000", 16)),
	ChainAdmin(new BigInteger("8000000000000000", 16).shiftRight(1)),
	NodeAdmin(new BigInteger("8000000000000000", 16).shiftRight(2)),
	ContractAdmin(new BigInteger("8000000000000000", 16).shiftRight(3)),
	ContractDeployer(new BigInteger("8000000000000000", 16).shiftRight(4));

	private RoleEnum(BigInteger value) {
		this.value = value;
	}

	private BigInteger value;

	public BigInteger value() {
		return value;
	}

	public static RoleEnum getByVal(BigInteger val) {
		for (RoleEnum tmp : values()) {
			if (tmp.value().compareTo(val) == 0) {
				return tmp;
			}
		}
		return null;
	}

}
