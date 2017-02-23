package org.zn.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zn.user.dao.VersionControlDao;
import org.zn.user.entity.VersionControl;
import org.zn.user.service.VersionService;

@Service
public class VersionServiceImpl implements VersionService {

	@Autowired
	private VersionControlDao versionControlDao;
	
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(VersionControl record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(VersionControl record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public VersionControl selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VersionControl selectByAppVersion(String appVersion , String appDevice) {
		// TODO Auto-generated method stub
		return versionControlDao.selectByAppVersion(appVersion , appDevice);
	}

	@Override
	public int updateByPrimaryKeySelective(VersionControl record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(VersionControl record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
