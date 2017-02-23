/*
 * CategoryThreeMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-17 Created
 */
package org.zn.category.dao;

import org.zn.category.entity.CategoryThree;

public interface CategoryThreeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CategoryThree record);

    int insertSelective(CategoryThree record);

    CategoryThree selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CategoryThree record);

    int updateByPrimaryKey(CategoryThree record);
}