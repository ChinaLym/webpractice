package com.edeclare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edeclare.entity.User;
import com.edeclare.service.IUserService;
/**
* Type: Test
* Description: 测试类
* （正规方式以Junit启动，这里为了启动速度更快，暂时放这）
* @author LYM
* @date Dec 18, 2018
 */
@Controller
public class Test {
	
    @Autowired
    private IUserService userService;

    @GetMapping("/testIndex")
    public String index(@ModelAttribute User user) {
    	return "main";
    }
    
    @ResponseBody
    @GetMapping("/testUser")
    public String test() {
    	User user = new User();
    	user.setAccount("test");
    	user.setPassword("test");
    	try {
			userService.login(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "ok";
    }
    
    @GetMapping("/testWebsocket")
    public String testWebSocket() {
    	return "test/websocket/websocketTest";
    }
}
