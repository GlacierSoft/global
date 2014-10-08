package com.glacier.frame.entity.member;

public class ShipperMemberToken {
    private String memberId;

    private String memberName;

    private String password;

    private String stalt;

    private String tratersPassword;

    private String tratersStalt;

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

    public String getStalt() {
        return stalt;
    }

    public void setStalt(String stalt) {
        this.stalt = stalt;
    }

    public String getTratersPassword() {
        return tratersPassword;
    }

    public void setTratersPassword(String tratersPassword) {
        this.tratersPassword = tratersPassword;
    }

    public String getTratersStalt() {
        return tratersStalt;
    }

    public void setTratersStalt(String tratersStalt) {
        this.tratersStalt = tratersStalt;
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
            && (this.getStalt() == null ? other.getStalt() == null : this.getStalt().equals(other.getStalt()))
            && (this.getTratersPassword() == null ? other.getTratersPassword() == null : this.getTratersPassword().equals(other.getTratersPassword()))
            && (this.getTratersStalt() == null ? other.getTratersStalt() == null : this.getTratersStalt().equals(other.getTratersStalt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getMemberName() == null) ? 0 : getMemberName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getStalt() == null) ? 0 : getStalt().hashCode());
        result = prime * result + ((getTratersPassword() == null) ? 0 : getTratersPassword().hashCode());
        result = prime * result + ((getTratersStalt() == null) ? 0 : getTratersStalt().hashCode());
        return result;
    }
}