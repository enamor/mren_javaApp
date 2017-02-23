package org.zn.photos.service.impl;

import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestParam;
import org.zn.common.LocalResource;
import org.zn.photos.dao.AlbumImageDao;
import org.zn.photos.entity.AlbumImage;
import org.zn.photos.service.AlbumImageService;
import org.zn.util.PropertiesUtil;

@Service
public class AlbumImageServiceImpl implements AlbumImageService {
	private static Logger log = Logger.getLogger(AlbumImageServiceImpl.class.getName());

	@Autowired
	private AlbumImageDao albumImageDao;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return albumImageDao.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional
	public int insert(AlbumImage record) {
		// TODO Auto-generated method stub
		return albumImageDao.insert(record);
	}

	@Override
	public int insertSelective(AlbumImage record) {
		// TODO Auto-generated method stub
		return albumImageDao.insertSelective(record);
	}

	@Override
	public AlbumImage selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return albumImageDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(AlbumImage record) {
		// TODO Auto-generated method stub
		return albumImageDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(AlbumImage record) {
		// TODO Auto-generated method stub
		return albumImageDao.updateByPrimaryKey(record);
	}

	@Transactional
	public List<AlbumImage> batchInsertImage(// 需要判断 startIndex 从 00 开始 还是 0 开始
		String photoUuid,String albumPath, String url, String startIndex, Integer endIndex ,String suffix) {
		String path = PropertiesUtil.getProperty(LocalResource.RE_PHOTO_ALBUM);
		List<AlbumImage> list = new ArrayList<AlbumImage>();
		int index = Integer.parseInt(startIndex);
		for (int i = index; i < endIndex + 1; i++) {
			String imgUrl = url + i + suffix;
			if (startIndex.length()>1 && i < 10) {
				imgUrl = url + "0" + i + suffix;
			}
		    String imagePath = grabUrlImageToLocal(albumPath, imgUrl,i);
		    if (null == imagePath) {
				continue;
			}
			AlbumImage image = new AlbumImage();
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			image.setUuid(uuid);
			image.setPhotoUuid(photoUuid);
			image.setImageUrl(imagePath);
			File picture = new File(path + imagePath);
			try {
				BufferedImage sourceImg = ImageIO.read(new FileInputStream(picture));
				image.setImageHeight(sourceImg.getHeight());
				image.setImageWidth(sourceImg.getWidth());
				image.setImageSize(picture.length()/1024);
				//插入图片
				albumImageDao.insert(image);
				list.add(image);
			} catch (Exception e) {
				// TODO: handle exception
				log.error("插入图片失败"+i, e);
				picture.delete();
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			}
		}
		return list;
	}
	
	//抓取网络图片到本地
	public String grabUrlImageToLocal(String albumPath, String urlStr ,int index){
		
		String path = PropertiesUtil.getProperty(LocalResource.RE_PHOTO_ALBUM);
		String jpgName = (System.currentTimeMillis() + String.valueOf(index) + ".jpg");
		String imgPath = albumPath + jpgName;
		path += imgPath;
		try {
			URL url = new URL(urlStr);
			DataInputStream dataInputStream = new DataInputStream(url.openStream());
			FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
			byte[] buffer = new byte[1024];
			int length;
			while ((length = dataInputStream.read(buffer)) > 0) {
				fileOutputStream.write(buffer, 0, length);
			}
			dataInputStream.close();
			fileOutputStream.close();
		} catch (Exception e) {
			log.error("相册插入图片失败", e);
			imgPath = null;
		}
		return imgPath;
		
	}

	@Override
	public List<AlbumImage> getAlbumImageList(String photoUuid) {
		// TODO Auto-generated method stub
		return albumImageDao.getAlbumImageList(photoUuid);
	}

}
