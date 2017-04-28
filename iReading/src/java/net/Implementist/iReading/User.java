/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.Implementist.iReading;

/**
 *
 * @author Implementist
 */
public class User {

    /**
     * 用户ID
     */
    private int userID;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户手机号码
     */
    private String phoneNumber;

    /**
     * 用户手机号码是否已验证
     */
    private Boolean phoneNumberVerified;

    /**
     * 用户邮箱地址
     */
    private String emailAddress;

    /**
     * 用户邮箱地址是否已验证
     */
    private Boolean emailAddressVerified;

    /**
     * 用户密码哈希值
     */
    private String passwordHash;

    /**
     * 用户密码安全戳
     */
    private String securityStamp;

    /**
     * 账号注册的日期时间
     */
    private String registrationDateTime;

    /**
     * 上次登录的日期时间
     */
    private String lastLoginDateTime;

    /**
     * 无参数构造函数
     *
     */
    public User() {

    }

    /**
     * SSS三参构造函数
     *
     * @param passwordHash
     * @param securityStamp
     * @param userName
     */
    public User(String userName, String passwordHash, String securityStamp) {
        this.passwordHash = passwordHash;
        this.securityStamp = securityStamp;
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getPhoneNumberVerified() {
        return phoneNumberVerified;
    }

    public void setPhoneNumberVerified(Boolean phoneNumberVerified) {
        this.phoneNumberVerified = phoneNumberVerified;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Boolean getEmailAddressVerified() {
        return emailAddressVerified;
    }

    public void setEmailAddressVerified(Boolean emailAddressVerified) {
        this.emailAddressVerified = emailAddressVerified;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getSecurityStamp() {
        return securityStamp;
    }

    public void setSecurityStamp(String securityStamp) {
        this.securityStamp = securityStamp;
    }

    public String getRegistrationDateTime() {
        return registrationDateTime;
    }

    public void setRegistrationDateTime(String registrationDateTime) {
        this.registrationDateTime = registrationDateTime;
    }

    public String getLastLoginDateTime() {
        return lastLoginDateTime;
    }

    public void setLastLoginDateTime(String lastLoginDateTime) {
        this.lastLoginDateTime = lastLoginDateTime;
    }
}
