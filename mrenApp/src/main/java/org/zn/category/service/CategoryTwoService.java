package org.zn.category.service;

import java.util.List;

import org.zn.category.entity.CategoryTwo;

public interface CategoryTwoService {
	int deleteByPrimaryKey(Integer id);

    int insert(CategoryTwo record);

    int insertSelective(CategoryTwo record);

    CategoryTwo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CategoryTwo record);

    int updateByPrimaryKey(CategoryTwo record);
    
    List<CategoryTwo> getAllCategoryList();
    
    /*
     * 传入一级分类的ID 获取二级分类
     */
    List<CategoryTwo> getCategoryList(String parentId);
}
