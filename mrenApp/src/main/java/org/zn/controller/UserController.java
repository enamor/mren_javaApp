package org.zn.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.zn.common.JsonModel;
import org.zn.common.LocalResource;
import org.zn.common.Response;
import org.zn.user.entity.UserAccount;
import org.zn.user.entity.UserDetail;
import org.zn.user.entity.VersionControl;
import org.zn.user.service.UserAccountService;
import org.zn.user.service.UserDetailService;
import org.zn.user.service.VersionService;
import org.zn.util.PropertiesUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	private static Logger log = Logger.getLogger(UserController.class.getName());

	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private UserDetailService userDetailService;
	@Autowired
	private VersionService versionService;
	

	@ResponseBody
	@RequestMapping(value = "/authCodeLogin.do", method = RequestMethod.POST)
	public JsonModel authCodeLogin(
			@RequestParam("phoneNumber")String phoneNumber,//手机号
			@RequestParam("authCode")String authCode) {	//验证码(暂时放在了客户端验证)
		JsonModel jsonModel = new JsonModel();
		try {
			UserAccount account = userAccountService.selectByPhoneNumber(phoneNumber);
			if (null != account) {
				jsonModel.setData(account);
			} else {
				account = new UserAccount();
				account.setPhoneNumber(phoneNumber);
				String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				account.setUuid(uuid);
				userAccountService.insert(account);
				
				UserDetail detail = new UserDetail();
				detail.setUserUuid(uuid);
				detail.setNickname(phoneNumber);
				userDetailService.insert(detail);
			}
			jsonModel.setData(account);
		} catch (Exception e) {
			log.error("手机验证码登录失败", e);
			jsonModel.setCode(Response.SC_BAD_REQUEST);
			jsonModel.setMessage(e.getMessage());
			// TODO: handle exception
		}
		return jsonModel;
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateUserInfo.do", method = RequestMethod.POST)
	public JsonModel updateUserInfo(UserDetail userInfo) {
		JsonModel jsonModel = new JsonModel();
		try {
			int row = userDetailService.updateByPrimaryKeySelective(userInfo);
			if (row > 0) {
				
			} else {
				jsonModel.setCode(Response.SC_BAD_REQUEST);
				jsonModel.setMessage("未知错误");
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.error("更新用户信息失败", e);
			jsonModel.setCode(Response.SC_BAD_REQUEST);
			jsonModel.setMessage(e.getMessage());
		}
		return jsonModel;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getUserInfo.do", method = RequestMethod.POST)
	public JsonModel getUserInfo(@RequestParam("uuid")String uuid ) {
		JsonModel jsonModel = new JsonModel();
		try {
			UserDetail detail = userDetailService.selectByUUID(uuid);
			if (null != detail) {
				jsonModel.setData(detail);
			} else {
				jsonModel.setCode(Response.SC_BAD_REQUEST);
				jsonModel.setMessage("未知错误");
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.error("获取用户信息失败", e);
			jsonModel.setCode(Response.SC_BAD_REQUEST);
			jsonModel.setMessage(e.getMessage());
		}
		return jsonModel;
	}
	/**
	 * 上传头像
	 */
	@ResponseBody
	@RequestMapping(value = "/uploadAvatar.do", method = RequestMethod.POST)
	public JsonModel uploadAvatar(HttpServletRequest request, @RequestParam("uuid")String uuid) {

		JsonModel jsonModel = new JsonModel();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		// 获得文件：
		MultipartFile file = multipartRequest.getFile("image");
		String imageUrl = userDetailService.uploadAvatar(file,uuid);
		if (null != imageUrl) {
			jsonModel.setData(imageUrl);
		} else {
			jsonModel.setCode(Response.SC_BAD_REQUEST);
			jsonModel.setMessage("未知错误");
		}
		return jsonModel;
	}
	
	//用户版本控制
	@ResponseBody
	@RequestMapping(value = "/appVersionControl.do", method = RequestMethod.POST)
	public JsonModel appVersionControl(@RequestParam("appVersion")String appVersion,
			@RequestParam("appDevice")String appDevice) {
		JsonModel jsonModel = new JsonModel();
		try {
			VersionControl version = versionService.selectByAppVersion(appVersion,appDevice);
			if (null == version) {
				jsonModel.setCode(Response.SC_BAD_REQUEST);
				jsonModel.setMessage("未找到该版本信息");
			} else {
				jsonModel.setData(version);	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("获取app版本信息失败", e);
			jsonModel.setCode(Response.SC_BAD_REQUEST);
			jsonModel.setMessage(e.getMessage());
		}
		return jsonModel;
	}
}
