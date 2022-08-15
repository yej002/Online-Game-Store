package com.jing.storeweb.entity;

import java.io.Serializable;

/**
 * This class defined the entity of address, and the properties of the address
 */
public class Address extends BaseEntity implements Serializable {
    private Integer aid;
    private Integer uid;
    private String name;
    private String stateName;
    private String cityName;
    private String zip;
    private String address;
    private String phone;
    private Integer isDefault;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String StateName) {
        this.stateName = StateName;
    }
    
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address1 = (Address) o;

        if (getAid() != null ? !getAid().equals(address1.getAid()) : address1.getAid() != null) return false;
        if (getUid() != null ? !getUid().equals(address1.getUid()) : address1.getUid() != null) return false;
        if (getName() != null ? !getName().equals(address1.getName()) : address1.getName() != null) return false;
        if (getStateName() != null ? !getStateName().equals(address1.getStateName()) : address1.getStateName() != null)
            return false;
        if (getCityName() != null ? !getCityName().equals(address1.getCityName()) : address1.getCityName() != null)
            return false;
        if (getZip() != null ? !getZip().equals(address1.getZip()) : address1.getZip() != null) return false;
        if (getAddress() != null ? !getAddress().equals(address1.getAddress()) : address1.getAddress() != null)
            return false;
        if (getPhone() != null ? !getPhone().equals(address1.getPhone()) : address1.getPhone() != null) return false;
        return getIsDefault() != null ? getIsDefault().equals(address1.getIsDefault()) : address1.getIsDefault() == null;
    }

    @Override
    public int hashCode() {
        int result = getAid() != null ? getAid().hashCode() : 0;
        result = 31 * result + (getUid() != null ? getUid().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getStateName() != null ? getStateName().hashCode() : 0);
        result = 31 * result + (getCityName() != null ? getCityName().hashCode() : 0);
        result = 31 * result + (getZip() != null ? getZip().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + (getIsDefault() != null ? getIsDefault().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "aid=" + aid +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", StateName='" + stateName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", zip='" + zip + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", isDefault=" + isDefault +
                "} " + super.toString();
    }
}


