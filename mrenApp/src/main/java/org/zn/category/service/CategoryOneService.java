package org.zn.category.service;

import java.util.List;

import org.zn.category.entity.CategoryOne;

public interface CategoryOneService {
	int deleteByPrimaryKey(Integer id);

    int insert(CategoryOne record);

    int insertSelective(CategoryOne record);

    CategoryOne selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CategoryOne record);

    int updateByPrimaryKey(CategoryOne record);
    
    List<CategoryOne> getCategoryList();
}
