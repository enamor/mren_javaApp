package org.zn.category.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zn.category.dao.CategoryTwoDao;
import org.zn.category.entity.CategoryTwo;
import org.zn.category.service.CategoryTwoService;

@Service
public class CategoryTwoServiceImpl implements CategoryTwoService {

	@Autowired
	private CategoryTwoDao categoryTwoDao;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return categoryTwoDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(CategoryTwo record) {
		// TODO Auto-generated method stub
		return categoryTwoDao.insert(record);
	}

	@Override
	public int insertSelective(CategoryTwo record) {
		// TODO Auto-generated method stub
		return categoryTwoDao.insertSelective(record);
	}

	@Override
	public CategoryTwo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return categoryTwoDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(CategoryTwo record) {
		// TODO Auto-generated method stub
		return categoryTwoDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(CategoryTwo record) {
		// TODO Auto-generated method stub
		return categoryTwoDao.updateByPrimaryKey(record);
	}

	@Override
	public List<CategoryTwo> getCategoryList(String parentId) {
		// TODO Auto-generated method stub
		return categoryTwoDao.getCategoryList(parentId);
	}

	@Override
	public List<CategoryTwo> getAllCategoryList() {
		// TODO Auto-generated method stub
		return categoryTwoDao.getAllCategoryList();
	}

}
