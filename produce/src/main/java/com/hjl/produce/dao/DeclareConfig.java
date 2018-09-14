package com.hjl.produce.dao;

import java.io.Serializable;

/**
 * Created   on 2018/8/30.
 *
 * @author hjl
 */
public class DeclareConfig implements Serializable {

    private Long id;

    private String areaId;

    private String areaName;

    private Integer supportTaxCheck;

    private Integer supportUndoSb;

    private Integer taxCheckStartDay;

    private Integer taxCheckEndDay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getSupportTaxCheck() {
        return supportTaxCheck;
    }

    public void setSupportTaxCheck(Integer supportTaxCheck) {
        this.supportTaxCheck = supportTaxCheck;
    }

    public Integer getSupportUndoSb() {
        return supportUndoSb;
    }

    public void setSupportUndoSb(Integer supportUndoSb) {
        this.supportUndoSb = supportUndoSb;
    }

    public Integer getTaxCheckStartDay() {
        return taxCheckStartDay;
    }

    public void setTaxCheckStartDay(Integer taxCheckStartDay) {
        this.taxCheckStartDay = taxCheckStartDay;
    }

    public Integer getTaxCheckEndDay() {
        return taxCheckEndDay;
    }

    public void setTaxCheckEndDay(Integer taxCheckEndDay) {
        this.taxCheckEndDay = taxCheckEndDay;
    }

    @Override
    public String toString() {
        return "DeclareConfig{" +
            "id=" + id +
            ", areaId='" + areaId + '\'' +
            ", areaName='" + areaName + '\'' +
            ", supportTaxCheck=" + supportTaxCheck +
            ", supportUndoSb=" + supportUndoSb +
            ", taxCheckStartDay=" + taxCheckStartDay +
            ", taxCheckEndDay=" + taxCheckEndDay +
            '}';
    }
}
