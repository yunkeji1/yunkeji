package com.cloudclass.course.entity;

import java.util.Date;

public class User {
    private String id;
    private String nickName;
    private String phone;
    private String avatar;
    private String userType;
    private Integer balance;
    private String vipEndTime;
    private String adviceNumber;
    private String verificationCode;
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getVipEndTime() {
        return vipEndTime;
    }

    public void setVipEndTime(String vipEndTime) {
        this.vipEndTime = vipEndTime;
    }

    public String getAdviceNumber() {
        return adviceNumber;
    }

    public void setAdviceNumber(String adviceNumber) {
        this.adviceNumber = adviceNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
