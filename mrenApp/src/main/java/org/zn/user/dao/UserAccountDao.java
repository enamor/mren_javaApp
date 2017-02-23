/*
 * UserAccountMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-10 Created
 */
package org.zn.user.dao;

import org.zn.user.entity.UserAccount;

public interface UserAccountDao {
    int deleteByPrimaryKey(Integer id);

    int insert(UserAccount record);

    int insertSelective(UserAccount record);

    UserAccount selectByPrimaryKey(Integer id);
    
    UserAccount selectByPhoneNumber(String phoneNumber);

    int updateByPrimaryKeySelective(UserAccount record);

    int updateByPrimaryKey(UserAccount record);
}