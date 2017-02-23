/*
 * UserAccount.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-12 Created
 */
package org.zn.user.entity;

/**
 * 
 * 
 * @author 
 * @version 1.0 2016-12-12
 */
public class UserAccount {

    private Long id;
    private String uuid;
    //账号
    private String account;
    //手机号
    private String phoneNumber;
    //密码
    private String password;
    private String token;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }
}