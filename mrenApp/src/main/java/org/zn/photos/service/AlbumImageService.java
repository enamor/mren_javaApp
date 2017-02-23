package org.zn.photos.service;

import java.util.List;

import org.zn.photos.entity.AlbumImage;

public interface AlbumImageService {
	int deleteByPrimaryKey(Integer id);

    int insert(AlbumImage record);

    int insertSelective(AlbumImage record);

    AlbumImage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AlbumImage record);

    int updateByPrimaryKey(AlbumImage record);
    
    public List<AlbumImage> getAlbumImageList(String photoUuid);
    
    public List<AlbumImage> batchInsertImage(String photoUuid ,String albumPath, String url, String startIndex, Integer endIndex,String suffix);
}
