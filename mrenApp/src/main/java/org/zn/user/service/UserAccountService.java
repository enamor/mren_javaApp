package org.zn.user.service;

import org.springframework.web.multipart.MultipartFile;
import org.zn.user.entity.UserAccount;

public interface UserAccountService {
	int deleteByPrimaryKey(Integer id);

    int insert(UserAccount record);

    int insertSelective(UserAccount record);

    UserAccount selectByPrimaryKey(Integer id);
    
    UserAccount selectByPhoneNumber(String phoneNumber);

    int updateByPrimaryKeySelective(UserAccount record);

    int updateByPrimaryKey(UserAccount record);
    
 
}
