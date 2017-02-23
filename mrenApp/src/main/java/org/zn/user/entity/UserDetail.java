/*
 * UserDetail.java
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
public class UserDetail {

    private Long id;
    private String userUuid;
    //头像
    private String headPortrait;
    private String nickname;
    //0 男 ， 1 女
    private Integer sex;
    private String birthday;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserUuid() {
        return userUuid;
    }
    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid == null ? null : userUuid.trim();
    }
    public String getHeadPortrait() {
        return headPortrait;
    }
    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait == null ? null : headPortrait.trim();
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }
    public Integer getSex() {
        return sex;
    }
    public void setSex(Integer sex) {
        this.sex = sex;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }
}