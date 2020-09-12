package org.platone.inner.contracts.dto;

import java.math.BigInteger;

import org.platone.common.RoleUtils;

public class User {
    private String address;
    private String name;
    private String mobile;
    private String email;
    private String desc;
    private int status;
    private BigInteger roles;
    private String roleNames;
    private long registerTime;
    private long updateTime;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BigInteger getRoles() {
        return roles;
    }

    public void setRoles(BigInteger roles) {
        this.roles = roles;
        this.roleNames = RoleUtils.getRoleName(roles);
    }

    public String getRoleNames() {
        return roleNames;
    }

    public long getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(long registerTime) {
        this.registerTime = registerTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User [address=" + address + ", name=" + name + ", mobile=" + mobile + ", email=" + email + ", desc="
            + desc + ", status=" + status + ", roles=" + roles + ", registerTime=" + registerTime + ", updateTime="
            + updateTime + "]";
    }

}
