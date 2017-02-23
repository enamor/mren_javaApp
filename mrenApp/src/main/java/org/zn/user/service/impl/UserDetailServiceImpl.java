package org.zn.user.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.zn.common.LocalResource;
import org.zn.photos.service.impl.PhotoAlbumServiceImpl;
import org.zn.user.dao.UserDetailDao;
import org.zn.user.entity.UserDetail;
import org.zn.user.service.UserDetailService;
import org.zn.util.CustomUUID;
import org.zn.util.PropertiesUtil;

@Service
public class UserDetailServiceImpl implements UserDetailService {

	private static Logger log = Logger.getLogger(UserDetailServiceImpl.class.getName());
	
	@Autowired
	private UserDetailDao userDetailDao;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return userDetailDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(UserDetail record) {
		// TODO Auto-generated method stub
		return userDetailDao.insert(record);
	}

	@Override
	public int insertSelective(UserDetail record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserDetail selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(UserDetail record) {
		// TODO Auto-generated method stub
		return userDetailDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(UserDetail record) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public UserDetail selectByUUID(String uuid) {
		// TODO Auto-generated method stub
		return userDetailDao.selectByUUID(uuid);
	}
	
	@Transactional
	public String uploadAvatar(MultipartFile file ,String uuid) {
		// 获得文件名：
		String filename = file.getOriginalFilename();
		filename = filename.substring(filename.lastIndexOf("."));
		filename = CustomUUID.generateShortUuid() + filename;
		String path = PropertiesUtil.getProperty(LocalResource.RE_HEADER_IMAGE);
		File fl = new File(path, filename);
		// 获得输入流：
		InputStream input;
		try {
			input = file.getInputStream();
			OutputStream out = new FileOutputStream(fl);
			int length = 0;
			byte[] buf = new byte[1024];
			System.out.println("获取文件总量的容量:" + file.getSize());
			while ((length = input.read(buf)) != -1) {
				out.write(buf, 0, length);
			}
			input.close();
			out.close();
			
			UserDetail detail = userDetailDao.selectByUUID(uuid);
			File oldHeader = null;
			if (null != detail && null != detail.getHeadPortrait()) {
				oldHeader = new File(path, detail.getHeadPortrait());
			} else {
				detail = new UserDetail();
			}
			detail.setUserUuid(uuid);
			detail.setHeadPortrait(filename);
			userDetailDao.updateByPrimaryKeySelective(detail);
			if (null != oldHeader) {
				oldHeader.delete();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("上传头像失败", e);
			fl.delete();
			filename = null;
		}
		return filename;
	}

}
