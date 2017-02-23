/*
 * CategoryOneMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-17 Created
 */
package org.zn.category.dao;

import java.util.List;

import org.zn.category.entity.CategoryOne;

public interface CategoryOneDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CategoryOne record);

    int insertSelective(CategoryOne record);

    CategoryOne selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CategoryOne record);

    int updateByPrimaryKey(CategoryOne record);
    
    List<CategoryOne> getCategoryList();
}