package com.gxa.entity;

public class Goods {
    private Integer id;//编号
    private Integer catelog_id;//药品类别
    private String name;//药品名称
    private Integer gys_id;//供应商
    private String danwei;//单位
    private String baozhiqi;//保质期
    private String beizhu;//备注
    private Integer status;//状态 0 删除  1 正常
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCatelog_id() {
        return catelog_id;
    }

    public void setCatelog_id(Integer catelog_id) {
        this.catelog_id = catelog_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGys_id() {
        return gys_id;
    }

    public void setGys_id(Integer gys_id) {
        this.gys_id = gys_id;
    }

    public String getDanwei() {
        return danwei;
    }

    public void setDanwei(String danwei) {
        this.danwei = danwei;
    }

    public String getBaozhiqi() {
        return baozhiqi;
    }

    public void setBaozhiqi(String baozhiqi) {
        this.baozhiqi = baozhiqi;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
