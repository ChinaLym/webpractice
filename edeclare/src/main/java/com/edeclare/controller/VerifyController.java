package com.edeclare.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edeclare.utils.HttpInfoUtils;

/**
* Type: VerifyController
* Description: 验证码生成和验证
* @author LYM
* @date Dec 16, 2018
 */
@Controller
@RequestMapping("/verify")
public class VerifyController {
	//private static final  Logger LOGGER = Logger.getLogger(VerifyController.class);

	@RequestMapping(value="/getImage",method=RequestMethod.GET)
	@ResponseBody
	public void getImage(HttpServletRequest request, HttpServletResponse response) {
			HttpInfoUtils.createNewVerifyImage(request, response);
	}
	
	@RequestMapping(value="/checkCode",method=RequestMethod.GET)
	@ResponseBody
	public boolean checkCode(HttpServletRequest request, HttpServletResponse response)
	{
		// 获得输入的内容
		String imageValue = request.getParameter("imageValue").toLowerCase();
		String imageValue2 = (String) request.getSession().getAttribute("imageValue");
		if (imageValue != null && imageValue.equals(imageValue2)) {
			request.getSession().setAttribute("checkResult", true);
			return true;
		}
		else {
			
			return false;
		}
			
	}
}
