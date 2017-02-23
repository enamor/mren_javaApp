package org.zn.photos.service.impl;

import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.zn.category.dao.CategoryTwoDao;
import org.zn.category.entity.CategoryTwo;
import org.zn.common.LocalResource;
import org.zn.photos.dao.PhotoAlbumDao;
import org.zn.photos.dao.PhotoTypeDao;
import org.zn.photos.entity.PhotoAlbum;
import org.zn.photos.entity.PhotoType;
import org.zn.photos.service.PhotoAlbumService;
import org.zn.util.PropertiesUtil;

@Service
public class PhotoAlbumServiceImpl implements PhotoAlbumService {
	
	@Autowired
	private CategoryTwoDao categoryTwoDao;
	@Autowired
	private PhotoAlbumDao photoAlbumDao;
	@Autowired
	private PhotoTypeDao photoTypeDao;

	private static Logger log = Logger.getLogger(PhotoAlbumServiceImpl.class.getName());

	private static HashMap<String, String> map = new HashMap<String, String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("推荐", "c1_01");
			put("诱惑", "c1_02");
			put("制服", "c1_03");
			put("美腿", "c1_04");
			put("美胸", "c1_05");
			put("美臀", "c1_06");
			put("职业", "c1_07");
			put("多样", "c1_08");
			put("清纯", "c1_09");
			put("居家", "c1_10");
			put("香车", "c1_11");
			// put("明星", "c1_12");
			// put("自拍", "c1_13");

			put("大胆", "c2_01");
			put("情趣", "c2_02");
			put("大尺度", "c2_03");
			put("湿身", "c2_04");
			put("风骚", "c2_05");
			put("透明", "c2_06");
			put("走光", "c2_07");
			put("性感", "c2_08");
			put("前凸后翘", "c2_09");
			
			put("蕾丝", "c2_10");
			put("比基尼", "c2_11");
			put("丁字裤", "c2_12");
			put("情趣内衣", "c2_13");
			put("皮裤", "c2_14");
			put("连体衣", "c2_15");
			put("内衣", "c2_16");
			put("透视", "c2_17");
			put("睡衣", "c2_18");
			put("包臀裙", "c2_19");
			put("吊带", "c2_20");
			put("热裤", "c2_21");
			put("连体裙", "c2_22");
			put("泳衣", "c2_23");
			put("泳装", "c2_24");
			put("短裙", "c2_25");

			put("黑丝", "c2_26");
			put("丝袜", "c2_27");
			put("网袜", "c2_28");
			put("大长腿", "c2_29");

			put("巨乳", "c2_30");
			put("酥胸", "c2_31");
			put("豪乳", "c2_32");
			put("爆乳", "c2_33");
			put("大胸", "c2_34");
			put("美乳", "c2_35");
			put("大波", "c2_36");
			put("事业线", "c2_37");
			put("大奶", "c2_38");
			put("半球", "c2_39");
			put("深沟", "c2_40");

			put("翘臀", "c2_41");
			put("电臀", "c2_42");

			put("护士", "c2_43");
			put("空姐", "c2_44");
			put("女仆", "c2_45");
			put("学生妹", "c2_46");
			put("嫩模", "c2_47");
			put("秘书", "c2_48");
			put("办公室", "c2_49");
			put("校花", "c2_50");

			put("气质", "c2_51");
			put("小清新", "c2_52");
			put("素颜", "c2_53");
			put("私房", "c2_54");
			put("极品", "c2_55");
			put("御姐", "c2_56");
			put("萝莉", "c2_57");
			put("可爱", "c2_58");
		}
	};

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return photoAlbumDao.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional
	public int insert(PhotoAlbum record) {
		// TODO Auto-generated method stub
		return photoAlbumDao.insert(record);
	}

	@Override
	public int insertSelective(PhotoAlbum record) {
		// TODO Auto-generated method stub
		return photoAlbumDao.insertSelective(record);
	}

	@Override
	public PhotoAlbum selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return photoAlbumDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(PhotoAlbum record) {
		// TODO Auto-generated method stub
		return photoAlbumDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(PhotoAlbum record) {
		// TODO Auto-generated method stub
		return photoAlbumDao.updateByPrimaryKey(record);
	}
	
	@Override
	public PhotoAlbum getLatestPhotoAlbum() {
		// TODO Auto-generated method stub
		return photoAlbumDao.getLatestPhotoAlbum();
	}

	@Override
	public List<PhotoAlbum> getPhotoAlbumList(String categoryId ,Integer start ,Integer rows ,Integer state) {
		// TODO Auto-generated method stub
		return photoAlbumDao.getPhotoAlbumList(categoryId ,start ,rows ,state);
	}
	
	@Override
	public List<PhotoAlbum> getAlbumList(String categoryId ,Integer start ,Integer rows) {
		
		return photoAlbumDao.getAlbumList(categoryId ,start ,rows);
	}
	
	@Override
	public List<PhotoAlbum> fuzzyQueryAlbumList(String title ,Integer start ,Integer rows ,Integer state) {
		// TODO Auto-generated method stub
		return photoAlbumDao.fuzzyQueryAlbumList(title ,start ,rows ,state);
	}

	@Transactional
	public PhotoAlbum createPhotoAlbum(String imageUrl, String title, String source ,Integer state) {
		
		//获取所有二级目录
		List<CategoryTwo> category = categoryTwoDao.getAllCategoryList();
		
		String path = PropertiesUtil.getProperty(LocalResource.RE_PHOTO_ALBUM);
		Calendar now = Calendar.getInstance();

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateNowStr = sdf.format(d);
		String albumName = ("album" + dateNowStr + "/");

		// image 为数据库需要存储的路径
		String imagePath = uploadImgFromUrl(imageUrl, path, albumName);
		if (null == imagePath) {
			return null;
		}
		String sqlAlbumPath = imagePath.substring(0, imagePath.lastIndexOf("/")+1);
		// 相册路径
		String albumPath = path + sqlAlbumPath;

		// 创建相册
		PhotoAlbum photoAlbum = new PhotoAlbum();
		photoAlbum.setTitle(title);
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		photoAlbum.setUuid(uuid);
		photoAlbum.setAlbumPath(sqlAlbumPath);
		photoAlbum.setState(state);

		File picture = new File(path + imagePath);

		try {
			BufferedImage sourceImg = ImageIO.read(new FileInputStream(picture));
			photoAlbum.setImageUrl(imagePath);
			photoAlbum.setImageWidth(sourceImg.getWidth());
			photoAlbum.setImageHeight(sourceImg.getHeight());
			photoAlbum.setImageSize((long) picture.length() / 1024);
			photoAlbum.setSource(source);
			photoAlbum.setCreatedTime(now.getTimeInMillis() + "");
			// 插入相册
			photoAlbumDao.insert(photoAlbum);
			
			ArrayList<String> categoryOneArray = new ArrayList<>();
			for(CategoryTwo cat : category){
				if (photoAlbum.getTitle().indexOf(cat.getName()) != -1) {
					
					if (!categoryOneArray.contains(cat.getParentId())) {
						// 存储相册类型
						PhotoType photoType1 = new PhotoType();
						photoType1.setCategoryId(cat.getParentId());
						photoType1.setPhotoUuid(photoAlbum.getUuid());
						photoTypeDao.insert(photoType1);
						categoryOneArray.add(cat.getParentId());
					}
					
					// 存储相册类型
					PhotoType photoType2 = new PhotoType();
					photoType2.setCategoryId(cat.getCid());
					photoType2.setPhotoUuid(photoAlbum.getUuid());
					photoTypeDao.insert(photoType2);
	
				}
			}

		} catch (Exception e) {
			log.error("创建相册失败", e);
			photoAlbum = null;
			// 删除图片
			picture.delete();
			// 删除相册
			File album = new File(albumPath);
			album.delete();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return photoAlbum;
	}

	/**
	 * 
	 * @param 网络图片URL
	 * @param 本地存储路径
	 * @param 相册名册
	 * @return
	 */
	public String uploadImgFromUrl(String urlstr, String imagePath, String albumName) {
		URL url;
		String path = null;

		Calendar now = Calendar.getInstance();
		path = (now.get(Calendar.YEAR) + "/");
		path += (now.get(Calendar.MONTH) + 1 + "/");
		path += (now.get(Calendar.DAY_OF_MONTH) + "/");
		path += albumName;
		String localPath = imagePath + path;
		File fp = new File(localPath);
		// 创建目录
		if (!fp.exists()) {
			fp.mkdirs();// 目录不存在的情况下，创建目录。
		}
		//相册封面名称
		String jpgName = "cover.jpg";
		// 需要存入数据库的 图片路径
		String sqlPath = path + jpgName;
		localPath += jpgName;

		try {
			url = new URL(urlstr);
			DataInputStream dataInputStream = new DataInputStream(url.openStream());
			FileOutputStream fileOutputStream = new FileOutputStream(new File(localPath));
			byte[] buffer = new byte[1024];
			int length;
			while ((length = dataInputStream.read(buffer)) > 0) {
				fileOutputStream.write(buffer, 0, length);
			}
			dataInputStream.close();
			fileOutputStream.close();
		} catch (Exception e) {
			log.error("获取网络图片失败", e);
			sqlPath = null;
			fp.delete();
		}
		return sqlPath;
	}

}
