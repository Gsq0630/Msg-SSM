package org.lanqiao.entity;

import java.io.Serializable;

public class SmallClass implements Serializable {
    private Integer sclassId;

    private String sclassName;

    private Integer bclassId;

    public Integer getSclassId() {
        return sclassId;
    }

    public void setSclassId(Integer sclassId) {
        this.sclassId = sclassId;
    }

    public String getSclassName() {
        return sclassName;
    }

    public void setSclassName(String sclassName) {
        this.sclassName = sclassName == null ? null : sclassName.trim();
    }

    public Integer getBclassId() {
        return bclassId;
    }

    public void setBclassId(Integer bclassId) {
        this.bclassId = bclassId;
    }

    @Override
    public String toString() {
        return "SmallClass{" +
                "sclassId=" + sclassId +
                ", sclassName='" + sclassName + '\'' +
                ", bclassId=" + bclassId +
                '}';
    }
}