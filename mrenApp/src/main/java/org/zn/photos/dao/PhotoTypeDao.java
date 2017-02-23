/*
 * PhotoTypeMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-16 Created
 */
package org.zn.photos.dao;

import org.zn.photos.entity.PhotoType;

public interface PhotoTypeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(PhotoType record);

    int insertSelective(PhotoType record);

    PhotoType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PhotoType record);

    int updateByPrimaryKey(PhotoType record);
}