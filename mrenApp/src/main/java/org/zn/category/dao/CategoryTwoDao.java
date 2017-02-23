/*
 * CategoryTwoMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-17 Created
 */
package org.zn.category.dao;

import java.util.List;

import org.zn.category.entity.CategoryTwo;

public interface CategoryTwoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CategoryTwo record);

    int insertSelective(CategoryTwo record);

    CategoryTwo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CategoryTwo record);

    int updateByPrimaryKey(CategoryTwo record);
    
    List<CategoryTwo> getAllCategoryList();
    
    List<CategoryTwo> getCategoryList(String parentId);
}