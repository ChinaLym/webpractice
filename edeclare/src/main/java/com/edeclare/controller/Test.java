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

    @GetMapping("/testindex")
    public String index(@ModelAttribute User user) {
    	return "main";
    }
    
    @ResponseBody
    @GetMapping("/testuser")
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
    
    @GetMapping("/testwebsocket")
    public String testWebSocket() {
    	return "test/websocket/websocketTest";
    }
    
    @GetMapping(value = "/managerLogin")
    public String managerLogin() {
    	return "manager/main";
    }
    
    @GetMapping(value = "/toSbgz")
    public String toSbgz() {
    	return "manager/shenbaoguize";
    }
    
    @GetMapping(value = "/toXmcs")
    public String toXmcs() {
    	return "manager/xiangmuchushen";
    }
    
    @GetMapping(value = "/toFpzj")
    public String toFpzj() {
    	return "manager/fenpeizhuanjia";
    }
    
    @GetMapping(value = "/toLx")
    public String toLx() {
    	return "manager/lixiang";
    }
}
