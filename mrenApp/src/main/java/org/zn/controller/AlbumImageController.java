package org.zn.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zn.common.JsonModel;
import org.zn.common.Response;
import org.zn.photos.entity.AlbumImage;
import org.zn.photos.service.AlbumImageService;

@Controller
@RequestMapping("/image")
public class AlbumImageController {
	private static Logger log = Logger.getLogger(AlbumImageController.class.getName());
	
	@Resource
	private AlbumImageService albumImageService;
	
	@ResponseBody
	@RequestMapping(value = "/batchInsert.do", method = RequestMethod.POST )
	public JsonModel batchInsertImage(// 批量插入图片
			@RequestParam("photoUuid") String photoUuid, //相册uuid
			@RequestParam("albumPath") String albumPath, // 相册路径
			@RequestParam("url") String url, // 图片url
			@RequestParam("startIndex") String startIndex, // 开始索引
			@RequestParam("endIndex") Integer endIndex,
			@RequestParam("suffix") String suffix //后缀
			) {

		JsonModel jsonModel = new JsonModel();
		try {
			List<AlbumImage> images = albumImageService.batchInsertImage(photoUuid ,albumPath, url, startIndex, endIndex,suffix);
			
			if (images.size() == 0) {
				jsonModel.setCode(Response.SC_BAD_REQUEST);
				jsonModel.setMessage(Response.SC_BAD_MESSAGE);
			} else {
				jsonModel.setData(images);
			}
		} catch (Exception e) {
			log.error("获取一级目录", e);
			jsonModel.setCode(Response.SC_BAD_REQUEST);
			jsonModel.setMessage(Response.SC_BAD_MESSAGE);
			// TODO: handle exception
		}
		return jsonModel;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getAlbumImageList.do", method = RequestMethod.POST )
	public JsonModel getAlbumImageList(// 批量插入图片
			@RequestParam("photoUuid") String photoUuid){
		
		JsonModel jsonModel = new JsonModel();
		try {
			List<AlbumImage> images = albumImageService.getAlbumImageList(photoUuid);
			if (images.size() == 0) {
				jsonModel.setCode(Response.SC_BAD_REQUEST);
				jsonModel.setMessage(Response.SC_BAD_MESSAGE);
			} else {
				jsonModel.setData(images);
			}
		} catch (Exception e) {
			log.error("获取一级目录", e);
			jsonModel.setCode(Response.SC_BAD_REQUEST);
			jsonModel.setMessage(Response.SC_BAD_MESSAGE);
			// TODO: handle exception
		}
		return jsonModel;
	}
}
