package org.platone.common;

public enum ErrorCodeEnum {
	Ret_OK(0, "success"),

	ErrNodeRegInternal(301001, "Internal error"), 
	ErrNodeRegJsonFmt(301002, "json format error"),
	ErrNodeRegNameEmpty(301003, "name is empty"), 
	ErrNodeRegNameTooLong(301004, "name is too long"),
	ErrNodeRegDescTooLong(301005, "desc is too long"), 
	ErrNodeRegNodeTypeError(301006, "node type value error"),
	ErrNodeRegPubKeyEmpty(301007, "PublicKey is empty"), 
	ErrNodeRegPubKeyFmt(301008, "PublicKey format error"),
	ErrNodeRegBlsPubKeyFmt(301009, "BlsPubKey format error"),
	ErrNodeRegBlsPubKeyEmpty(301010, "BlsPubKey is empty"), 
	ErrNodeRegExternalIpEmpty(301011, "ExternalIp is empty"),
	ErrNodeRegExternalIpFmt(301012, "ExternalIp format error"),
	ErrNodeRegInternalIpEmpty(301013, "InternalIp is empty"),
	ErrNodeRegInternalIpFmt(301014, "InternalIp format error"), 
	ErrNodeRegRpcPortError(301015, "RpcPort format error"),
	ErrNodeRegP2pPortError(301016, "P2pPort format error"),
	ErrNodeRegPubKeyRegistered(301017, "The publicKey has already registered"),
	ErrNodeRegNameRegistered(301018, "The name has already registered"),
	ErrNodeRegIpAndPortHasUsed(301019, "The ip and port has used"),
	ErrNodeRegCallerNoPermission(301020, "The caller has not permission to operation"),
	ErrNodeRegStatValueError(301021, "status value error"),
	ErrNodeRegInfoNotExists(301022, "The register node info does not exists"),
	ErrNodeRegInfoHasAudited(301023, " The register node info has audited"),

	ErrNodeMgrParam(302001, "Parameter error"), 
	ErrNodeMgrInternal(302002, "Internal error"),
	ErrNodeMgrPermission(302003, " Permission denied"), 
	ErrNodeMgrRegistered(302004, "Already registered"),
	ErrNodeMgrNotFound(302005, " Not found the node"),

	ErrUserRegInternal(303001, "Internal error"), 
	ErrUserRegJsonFmt(303002, "User register info json format error"),
	ErrUserRegAddrEmpty(303003, "Address is empty"), 
	ErrUserRegNameEmpty(303004, "Name is empty"),
	ErrUserRegNameTooLong(303005, "Name is too long"), 
	ErrUserRegEmailFmt(303006, "Email format error"),
	ErrUserRegEmailTooLong(303007, "Email is too long"), 
	ErrUserRegMobileFmt(303008, "Mobile format error"),
	ErrUserRegRemarkTooLong(303009, "Remark is too long"), 
	ErrUserRegRolesValueError(303010, "Roles value error"),
	ErrUserRegAddrRegistered(303011, "The address has already registered"),
	ErrUserRegNameRegistered(303012, "The name has already registered"),
	ErrUserRegStatusError(303013, "Status value error"),
	ErrUserRegUserNotExists(303014, "The user register info does not exist"),
	ErrUserRegUserNotAuditing(303015, "The user register info status is not auditing"),
	ErrUserRegCallerNoPermission(303016, "The caller has not permission to operation"),

	ErrUserMgrInternal(304001, "Internal error"), 
	ErrUserMgrAddrEmpty(304002, "Address is empty"),
	ErrUserMgrEmailFmt(304003, "Email format error"), 
	ErrUserMgrEmailTooLong(304004, "Email is too long"),
	ErrUserMgrMobileFmt(304005, "Mobile format error"),
	ErrUserMgrAddrRegistered(304006, " The address has already registered"),
	ErrUserMgrUserRegNotExists(304007, "The user register info does not exist"),
	ErrUserMgrUserRegNotActive(304008, " The user register info is not active"),
	ErrUserMgrCallerNoPermission(304009, "The caller has not permission to operation"),
	ErrUserMgrUserNotExists(304010, "The user does not exist"),
	ErrUserMgrUserInvalid(304011, "The user is not a valid user"), 
	ErrUserMgrStatusError(304012, "Status value error"),

	ErrRoleApplyInternal(305001, "Internal error"), 
	ErrRoleApplyRolesInvalid(305002, "Invalid roles"),
	ErrRoleApplyUserNotExists(305003, "The user does not exists"),
	ErrRoleApplyUserInvalid(305004, "The user is not a valid user"),
	ErrRoleApplyHasAuditingApply(305005, "The user has auditing role apply info"),
	ErrRoleApplyParamStatus(305006, "Invalid param of status"),
	ErrRoleApplyApplyNotExists(305007, " The role apply info does not exists"),
	ErrRoleApplyCallerNoPermission(305008, "The caller has no permission to approve"),

	ErrRoleMgrInternal(306001, "Internal error"), 
	ErrRoleMgrAddrEmpty(306002, "Address is empty"),
	ErrRoleMgrRolesValueError(306003, " Roles value error"), 
	ErrRoleMgrUserNotExists(306004, " User does not exists"),
	ErrRoleMgrUserInvalid(306005, "User is not a valid user"), 
	ErrRoleMgrUserNoRole(306006, " User has no roles"),
	ErrRoleMgrCallerNoPermission(306007, "Caller has no permission"),

	ErrParamMgrParam(307001, "parameter error"), 
	ErrParamMgrInternal(307002, "Internal error"),
	ErrParamMgrPermission(307003, " permission deny"),

	ErrCnsConName(308001, "Wrong contract name"), 
	ErrCnsConVer(308002, "Wrong contract version"),
	ErrCnsConOwner(308003, " Is not contract owner"),
	ErrCnsConReged(308004, "Contract name and version already registered"),
	ErrCnsNameReged(308005, "Contract name already registered"),
	ErrCnsCompareVer(308006, "Compare contract version error"),
	ErrCnsLowerVer(308007, "Version is lower than registered version"), 
	ErrCnsInternal(308008, "Internal error");

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
