package com.glacier.frame.entity.carrier;

import java.util.Date;

public class CarrierMemberCreditworthiness {
    private String tCarrierMemberCreditworthinessId;

    private String carrierMemberId;

    private String creditworthinessTypeId;

    private String remark;

    private String creater;

    private Date createTime;

    private String updater;

    private Date updateTime;

    public String gettCarrierMemberCreditworthinessId() {
        return tCarrierMemberCreditworthinessId;
    }

    public void settCarrierMemberCreditworthinessId(String tCarrierMemberCreditworthinessId) {
        this.tCarrierMemberCreditworthinessId = tCarrierMemberCreditworthinessId;
    }

    public String getCarrierMemberId() {
        return carrierMemberId;
    }

    public void setCarrierMemberId(String carrierMemberId) {
        this.carrierMemberId = carrierMemberId;
    }

    public String getCreditworthinessTypeId() {
        return creditworthinessTypeId;
    }

    public void setCreditworthinessTypeId(String creditworthinessTypeId) {
        this.creditworthinessTypeId = creditworthinessTypeId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CarrierMemberCreditworthiness other = (CarrierMemberCreditworthiness) that;
        return (this.gettCarrierMemberCreditworthinessId() == null ? other.gettCarrierMemberCreditworthinessId() == null : this.gettCarrierMemberCreditworthinessId().equals(other.gettCarrierMemberCreditworthinessId()))
            && (this.getCarrierMemberId() == null ? other.getCarrierMemberId() == null : this.getCarrierMemberId().equals(other.getCarrierMemberId()))
            && (this.getCreditworthinessTypeId() == null ? other.getCreditworthinessTypeId() == null : this.getCreditworthinessTypeId().equals(other.getCreditworthinessTypeId()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreater() == null ? other.getCreater() == null : this.getCreater().equals(other.getCreater()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdater() == null ? other.getUpdater() == null : this.getUpdater().equals(other.getUpdater()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((gettCarrierMemberCreditworthinessId() == null) ? 0 : gettCarrierMemberCreditworthinessId().hashCode());
        result = prime * result + ((getCarrierMemberId() == null) ? 0 : getCarrierMemberId().hashCode());
        result = prime * result + ((getCreditworthinessTypeId() == null) ? 0 : getCreditworthinessTypeId().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreater() == null) ? 0 : getCreater().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdater() == null) ? 0 : getUpdater().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}