package org.zn.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zn.user.dao.UserAccountDao;
import org.zn.user.entity.UserAccount;
import org.zn.user.service.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService {

	@Autowired
	private  UserAccountDao userAccountDao; 
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return userAccountDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(UserAccount record) {
		// TODO Auto-generated method stub
		return userAccountDao.insert(record);
	}

	@Override
	public int insertSelective(UserAccount record) {
		// TODO Auto-generated method stub
		return userAccountDao.insertSelective(record);
	}

	@Override
	public UserAccount selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return userAccountDao.selectByPrimaryKey(id);
	}
	
	public UserAccount selectByPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		return userAccountDao.selectByPhoneNumber(phoneNumber);
	}

	@Override
	public int updateByPrimaryKeySelective(UserAccount record) {
		// TODO Auto-generated method stub
		return userAccountDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(UserAccount record) {
		// TODO Auto-generated method stub
		return userAccountDao.updateByPrimaryKey(record);
	}

}
