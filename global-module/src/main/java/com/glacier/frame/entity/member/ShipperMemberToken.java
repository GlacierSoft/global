package com.glacier.frame.entity.member;

public class ShipperMemberToken {
    private String memberId;

    private String memberName;

    private String password;

    private String salt;

    private String tratersPassword;

    private String tratersSalt;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getTratersPassword() {
        return tratersPassword;
    }

    public void setTratersPassword(String tratersPassword) {
        this.tratersPassword = tratersPassword;
    }

    public String getTratersSalt() {
        return tratersSalt;
    }

    public void setTratersSalt(String tratersSalt) {
        this.tratersSalt = tratersSalt;
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
        ShipperMemberToken other = (ShipperMemberToken) that;
        return (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
            && (this.getMemberName() == null ? other.getMemberName() == null : this.getMemberName().equals(other.getMemberName()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getSalt() == null ? other.getSalt() == null : this.getSalt().equals(other.getSalt()))
            && (this.getTratersPassword() == null ? other.getTratersPassword() == null : this.getTratersPassword().equals(other.getTratersPassword()))
            && (this.getTratersSalt() == null ? other.getTratersSalt() == null : this.getTratersSalt().equals(other.getTratersSalt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getMemberName() == null) ? 0 : getMemberName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getSalt() == null) ? 0 : getSalt().hashCode());
        result = prime * result + ((getTratersPassword() == null) ? 0 : getTratersPassword().hashCode());
        result = prime * result + ((getTratersSalt() == null) ? 0 : getTratersSalt().hashCode());
        return result;
    }
}