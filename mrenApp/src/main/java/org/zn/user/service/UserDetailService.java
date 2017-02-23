package org.zn.user.service;

import org.springframework.web.multipart.MultipartFile;
import org.zn.common.BaseMapper;
import org.zn.user.entity.UserDetail;

public interface UserDetailService extends BaseMapper<UserDetail> {
	UserDetail selectByUUID(String uuid);
	String uploadAvatar(MultipartFile file ,String uuid);
}
