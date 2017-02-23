package org.zn.category.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zn.category.dao.CategoryOneDao;
import org.zn.category.entity.CategoryOne;
import org.zn.category.service.CategoryOneService;

@Service
public class CategoryOneServiceImpl implements CategoryOneService {
	@Autowired
	private CategoryOneDao categoryOneDao;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return categoryOneDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(CategoryOne record) {
		// TODO Auto-generated method stub
		return categoryOneDao.insert(record);
	}

	@Override
	public int insertSelective(CategoryOne record) {
		// TODO Auto-generated method stub
		return categoryOneDao.insertSelective(record);
	}

	@Override
	public CategoryOne selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return categoryOneDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(CategoryOne record) {
		// TODO Auto-generated method stub
		return categoryOneDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(CategoryOne record) {
		// TODO Auto-generated method stub
		return categoryOneDao.updateByPrimaryKey(record);
	}

	@Override
	public List<CategoryOne> getCategoryList() {
		// TODO Auto-generated method stub
		return categoryOneDao.getCategoryList();
	}

}
