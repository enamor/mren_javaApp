package org.zn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zn.category.entity.CategoryOne;
import org.zn.category.entity.CategoryTwo;
import org.zn.category.service.CategoryOneService;
import org.zn.category.service.CategoryTwoService;
import org.zn.common.Response;
import org.zn.common.JsonModel;

@Controller
@RequestMapping("/category")
public class CategoryController {
	private static Logger log = Logger.getLogger(CategoryController.class.getName());

	@Autowired
	private CategoryOneService categoryOneService;

	@Autowired
	private CategoryTwoService categoryTwoService;

	@ResponseBody
	@RequestMapping(value = "/getCategory_1.do", method = RequestMethod.GET)
	public JsonModel getCategoryOneList() {
		JsonModel jsonModel = new JsonModel();
		try {
			List<CategoryOne> category = categoryOneService.getCategoryList();
			jsonModel.setData(category);
		} catch (Exception e) {
			log.error("获取一级目录", e);
			jsonModel.setCode(Response.SC_BAD_REQUEST);
			jsonModel.setMessage(Response.SC_BAD_MESSAGE);
			// TODO: handle exception
		}
		return jsonModel;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getCategory_2.do", method = RequestMethod.GET)
	public JsonModel getCategoryTwoList(HttpServletRequest request, @RequestParam("parentId")String parentId) {
		JsonModel jsonModel = new JsonModel();
		try {
			List<CategoryTwo> category = categoryTwoService.getCategoryList(parentId);
			jsonModel.setData(category);
		} catch (Exception e) {
			log.error("获取二级目录", e);
			jsonModel.setCode(Response.SC_BAD_REQUEST);
			jsonModel.setMessage(Response.SC_BAD_MESSAGE);
			// TODO: handle exception
		}
		return jsonModel;
	}

}
