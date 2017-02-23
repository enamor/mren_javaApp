package org.zn.user.service;

import org.zn.user.entity.VersionControl;

public interface VersionService {
	int deleteByPrimaryKey(Integer id);

    int insert(VersionControl record);

    int insertSelective(VersionControl record);

    VersionControl selectByPrimaryKey(Integer id);
    
    VersionControl selectByAppVersion(String appVersion , String appDevice);

    int updateByPrimaryKeySelective(VersionControl record);

    int updateByPrimaryKey(VersionControl record);
}
