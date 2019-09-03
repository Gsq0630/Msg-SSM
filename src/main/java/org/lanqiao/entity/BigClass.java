package org.lanqiao.entity;

import java.io.Serializable;
import java.util.List;

public class BigClass implements Serializable {
    private Integer bclassId;

    private String bclassName;

    List<SmallClass> smallClassList;

    public Integer getBclassId() {
        return bclassId;
    }

    public void setBclassId(Integer bclassId) {
        this.bclassId = bclassId;
    }

    public String getBclassName() {
        return bclassName;
    }

    public void setBclassName(String bclassName) {
        this.bclassName = bclassName == null ? null : bclassName.trim();
    }

    public List<SmallClass> getSmallClassList() {
        return smallClassList;
    }

    public void setSmallClassList(List<SmallClass> smallClassList) {
        this.smallClassList = smallClassList;
    }

    @Override
    public String toString() {
        return "BigClass{" +
                "bclassId=" + bclassId +
                ", bclassName='" + bclassName + '\'' +
                '}';
    }
}