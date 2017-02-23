/*
 * AlbumImageMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-16 Created
 */
package org.zn.photos.dao;

import java.util.List;

import org.zn.photos.entity.AlbumImage;

public interface AlbumImageDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AlbumImage record);

    int insertSelective(AlbumImage record);

    AlbumImage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AlbumImage record);

    int updateByPrimaryKey(AlbumImage record);
    
    public List<AlbumImage> getAlbumImageList(String parentId);
}