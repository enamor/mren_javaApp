package org.zn.photos.service;

import org.zn.photos.entity.PhotoType;

public interface PhotoTypeService {
	int deleteByPrimaryKey(Integer id);

    int insert(PhotoType record);

    int insertSelective(PhotoType record);

    PhotoType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PhotoType record);

    int updateByPrimaryKey(PhotoType record);
}
