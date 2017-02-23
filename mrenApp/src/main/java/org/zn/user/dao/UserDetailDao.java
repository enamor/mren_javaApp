/*
 * UserDetailMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-10 Created
 */
package org.zn.user.dao;

import org.zn.user.entity.UserDetail;

public interface UserDetailDao {
    int deleteByPrimaryKey(Long id);

    int insert(UserDetail record);

    int insertSelective(UserDetail record);

    UserDetail selectByPrimaryKey(Long id);
    
    UserDetail selectByUUID(String uuid);
    

    int updateByPrimaryKeySelective(UserDetail record);

    int updateByPrimaryKey(UserDetail record);
}