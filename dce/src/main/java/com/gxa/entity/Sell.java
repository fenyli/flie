package com.gxa.entity;

import java.sql.Date;

public class Sell {
    private String id;
    private Date datetime;
    private String price;
    private String yuangong;
    private String remark;

    public Sell(String id, Date datetime, String price, String yuangong, String remark) {
        this.id = id;
        this.datetime = datetime;
        this.price = price;
        this.yuangong = yuangong;
        this.remark = remark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getYuangong() {
        return yuangong;
    }

    public void setYuangong(String yuangong) {
        this.yuangong = yuangong;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
