package org.platone.inner.contracts.dto;

public class ContractInfo {
    private String name;
    private String version;
    private String address;
    private String owner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "ContractInfo [name=" + name + ", version=" + version + ", address=" + address + ", owner=" + owner
            + "]";
    }

}
