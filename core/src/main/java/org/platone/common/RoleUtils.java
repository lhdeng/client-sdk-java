package org.platone.common;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class RoleUtils {
    public static final BigInteger ALL_ROLES = RoleEnum.ChainCreator.value().or(RoleEnum.ChainAdmin.value())
        .or(RoleEnum.NodeAdmin.value()).or(RoleEnum.ContractAdmin.value()).or(RoleEnum.ContractDeployer.value());

    public static boolean validRoles(BigInteger roles) {
        if (roles.compareTo(ALL_ROLES) > 0 || roles.compareTo(BigInteger.ZERO) < 0)
            throw new UnsupportedOperationException("the role value is wrong");

        return roles.and(ALL_ROLES).compareTo(BigInteger.ZERO) > 0;
    }

    public static boolean hasRole(BigInteger owner, BigInteger required) {
        validRoles(owner);
        validRoles(required);

        return owner.and(required).compareTo(BigInteger.ZERO) > 0;
    }

    public static boolean isChainCreator(BigInteger roles) {
        validRoles(roles);

        return roles.and(RoleEnum.ChainCreator.value()).compareTo(BigInteger.ZERO) > 0;
    }

    public static boolean isChainAdmin(BigInteger roles) {
        validRoles(roles);

        return roles.and(RoleEnum.ChainAdmin.value()).compareTo(BigInteger.ZERO) > 0;
    }

    public static boolean isNodeAdmin(BigInteger roles) {
        validRoles(roles);

        return roles.and(RoleEnum.NodeAdmin.value()).compareTo(BigInteger.ZERO) > 0;
    }

    public static boolean isContractAdmin(BigInteger roles) {
        validRoles(roles);

        return roles.and(RoleEnum.ContractAdmin.value()).compareTo(BigInteger.ZERO) > 0;
    }

    public static boolean isContractDeployer(BigInteger roles) {
        validRoles(roles);

        return roles.and(RoleEnum.ContractDeployer.value()).compareTo(BigInteger.ZERO) > 0;
    }

    public static BigInteger removeRoles(BigInteger owner, BigInteger removed) {
        validRoles(owner);
        validRoles(removed);

        return owner.andNot(removed);
    }

    public static boolean compareRoles(BigInteger owner, BigInteger compared) {
        validRoles(owner);
        validRoles(compared);

        return owner.andNot(compared).compareTo(compared) > 0;
    }

    public static String getRoleName(BigInteger roles) {
        List<String> list = new ArrayList<String>();
        if (isChainCreator(roles)) {
            list.add("链创建者");
        }
        if (isChainAdmin(roles)) {
            list.add("链管理员");
        }
        if (isNodeAdmin(roles)) {
            list.add("节点管理员");
        }
        if (isContractAdmin(roles)) {
            list.add("合约管理员");
        }
        if (isContractDeployer(roles)) {
            list.add("合约部署者");
        }

        if (list.size() == 0) {
            list.add("游客");
        }

        return JSON.toJSONString(list);
    }
}
