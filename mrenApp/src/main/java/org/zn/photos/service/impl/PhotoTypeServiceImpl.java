package org.zn.photos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zn.photos.dao.PhotoTypeDao;
import org.zn.photos.entity.PhotoType;
import org.zn.photos.service.PhotoTypeService;

@Service
public class PhotoTypeServiceImpl implements PhotoTypeService {

	@Autowired
	private PhotoTypeDao photoTypeDao;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return photoTypeDao.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional
	public int insert(PhotoType record) {
		// TODO Auto-generated method stub
		return photoTypeDao.insert(record);
	}

	@Override
	public int insertSelective(PhotoType record) {
		// TODO Auto-generated method stub
		return photoTypeDao.insertSelective(record);
	}

	@Override
	public PhotoType selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return photoTypeDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(PhotoType record) {
		// TODO Auto-generated method stub
		return photoTypeDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(PhotoType record) {
		// TODO Auto-generated method stub
		return photoTypeDao.updateByPrimaryKey(record);
	}

}
