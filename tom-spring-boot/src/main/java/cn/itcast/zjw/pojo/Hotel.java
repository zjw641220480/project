package cn.itcast.zjw.pojo;

import java.math.BigDecimal;

public class Hotel {
    private BigDecimal cityCode;

    private String name;

    private String address;

    private String zip;

    public BigDecimal getCityCode() {
        return cityCode;
    }

    public void setCityCode(BigDecimal cityCode) {
        this.cityCode = cityCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip == null ? null : zip.trim();
    }
}