package org.platone.common;

public enum ErrorCodeEnum {
	Ret_OK(0, "success"),

	ErrNodeInternal(301001, "Node manager contract internal error"), 
	ErrNodeNameEmpty(301002, "the node name is empty"),
	ErrNodeNameTooLong(301003, "the length of node name is too long"), 
	ErrNodeNameTooShort(301004, "the length of node name is too short"),
	ErrNodeNameHasUsed(301005, "The node name has already used"), 
	ErrNodeTypeError(301006, "the value of node type is wrong"),
	ErrNodeOwnerEmpty(301007, "the node owner is empty"), 
	ErrNodeDescTooLong(301008, "the length of node desc is too long"),
	ErrNodePubKeyEmpty(301009, "the node publicKey is empty"), 
	ErrNodePubKeyFmtError(301010, "the node publicKey value format error"),
	ErrNodePubKeyHasUsed(301011, "The node publicKey has already used"), 
	ErrNodeBlsPubKeyEmpty(301012, "the node blsPubKey is empty"),
	ErrNodeBlsPubKeyFmtError(301013, "the node blsPubKey value format error"), 
	ErrNodeHostAddrEmpty(301014, "the node host address is empty"),
	ErrNodeHostAndPortHasUsed(301015, "The host address and port has already used"), 
	ErrNodeRpcPortEmpty(301016, "the node rpc port is empty"),
	ErrNodeP2pPortEmpty(301017, "the node p2p port is empty"), 
	ErrNodeAuditStatError(301018, "the value of the audit status is wrong"),
	ErrNodeNotExists(301019, "The node does not exists"),
	ErrNodeNotValid(301020, "The node is not valid"),
	ErrNodeStatNotUnaudited(301021, "The node status is not unaudited"),
	ErrNodeStatNotDisabled(301022, "The node status is not disabled"),
	ErrNodeNotSupportUpd(301023, "The root node does not support update"), 
	ErrNodeStatusError(301024, "The node status value error"),
	ErrNodeOwnerNotExists(301025, "The node owner does not exists"), 
	ErrNodeOwnerNotValid(301026, "The node owner is not valid"),
	ErrNodeOwnerNoPermission(301027, "The node owner has no permission"),

	// User manager contract error code definition
	ErrUserInternal(302001, "User manager contract internal error"),
	ErrUserAddrEmpty(302002, "the user address is empty"),
	ErrUserNameEmpty(302003, "the user name is empty"), 
	ErrUserNameTooLong(302004, "the length of user name is too long"),
	ErrUserNameTooShort(302005, "the length of user name is too short"), 
	ErrUserMobileEmpty(302006, "the user mobile is empty"),
	ErrUserMobileFmt(302007, "the user mobile format is wrong"), 
	ErrUserEmailEmpty(302008, "the user email is empty"),
	ErrUserEmailTooLong(302009, "the length of user email is too long"),
	ErrUserEmailFmt(302010, "the user email format is wrong"),
	ErrUserDescTooLong(302011, "the length of user desc is too long"), 
	ErrUserRolesValueError(302012, "the value of the roles is wrong"),
	ErrUserAddrRegistered(302013, "The user address has already registered"), 
	ErrUserNameRegistered(302014, "The user name has already registered"),
	ErrUserAuditStatError(302015, "the value of the audit status is wrong"), 
	ErrUserNotExists(302016, "The user does not exist"),
	ErrUserNotValid(302017, "The user is not a valid user"), 
	ErrUserStatNotUnaudited(302018, "The user status is not unaudited"),
	ErrUserStatNotDisabled(302019, "The user status is not disabled"), 
	ErrUserCallerNotExists(302020, "The caller does not exist"),
	ErrUserCallerNotValid(302021, "The caller is not a valid user"), 
	ErrUserCallerNoPermission(302022, "The caller has no permission"),
	ErrUserHasNoRoles(302023, "The user has no roles"), 
	ErrUserStatusError(302024, "The user status value error"),

	// System parameter contract error code definition
	ErrParamMgrParam(303001, "parameter error"), 
	ErrParamMgrInternal(303002, "Internal error"), 
	ErrParamMgrPermission(303003, " permission deny"),

	// CNS contract error code definition
	ErrCnsInternal(304001, " Internal error"), 
	ErrCnsWrongName(304002, "Wrong contract name"),
	ErrCnsWrongVersion(304003, "Wrong contract version"),
	ErrCnsWrongAddress(304004, "Wrong contract address"),
	ErrCnsNotContractOwner(304005, "The caller is not the contract owner"),
	ErrCnsContractHasRegistered(304006, "Contract name and version already registered"),
	ErrCnsNameHasRegistered(304007, "Contract name already registered"), 
	ErrCnsCompareVersionError(304008, "Compare contract version error"),
	ErrCnsLowerVersion(304009, "Version is lower than registered version"),
	ErrCnsContractNotExists(304010, "The contract is does not exists");

	private Integer code;
	private String msg;

	private ErrorCodeEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return this.code;
	}

	public String getMsg() {
		return this.msg;
	}

	public static ErrorCodeEnum getByCode(Integer code) {
		for (ErrorCodeEnum tmp : values()) {
			if (tmp.getCode().equals(code)) {
				return tmp;
			}
		}
		return null;
	}

}
