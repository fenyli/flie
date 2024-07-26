package com.gxa.entity;

import java.sql.Date;

public class Caigou {
    private String id;
    private Date rukushijian;
    private String zongjine;
    private String fuzeren;
    private  String beizhu;
    private String mingxi;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getRukushijian() {
        return rukushijian;
    }

    public void setRukushijian(Date rukushijian) {
        this.rukushijian = rukushijian;
    }

    public String getZongjine() {
        return zongjine;
    }

    public void setZongjine(String zongjine) {
        this.zongjine = zongjine;
    }

    public String getFuzeren() {
        return fuzeren;
    }

    public void setFuzeren(String fuzeren) {
        this.fuzeren = fuzeren;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public String getMingxi() {
        return mingxi;
    }

    public void setMingxi(String mingxi) {
        this.mingxi = mingxi;
    }

    public Caigou(String id, Date rukushijian, String zongjine, String fuzeren,String beizhu,String mingxi) {
        this.id = id;
        this.rukushijian = rukushijian;
        this.zongjine = zongjine;
        this.fuzeren = fuzeren;
        this.beizhu = beizhu;
        this.mingxi = mingxi;
    }


}
