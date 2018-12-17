package com.edeclare.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edeclare.annotation.LoginRequired;
import com.edeclare.constant.responseBody.BaseResponse;
import com.edeclare.constant.responseBody.enums.URIResponseEnum;
import com.edeclare.constant.responseBody.enums.UserControllerResponseEnum;
import com.edeclare.entity.User;
import com.edeclare.service.IUserService;
/**
* Type: UserController
* Description: 与User相关
* 	不要在Controller层进行数据安全性校验，移步至service层校验
* @author LYM
* @date Dec 16, 2018
 */
@Controller
public class UserController {
	
    @Autowired
    private IUserService userService;

    //若注释掉@LoginRequired，则不登录也可请求，否则需要登录才能请求
    @LoginRequired
    @GetMapping("/index")
    public String index(@ModelAttribute User user) {
    	return "main";
    }
    
    @ResponseBody
    @GetMapping("/test")
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
 
    public UserController() {
		System.out.println("\n           /:::,'.               |::::@'       /::::/##            ++++++++'         ·/++++++++#+  \n          /:::#@@.               \\:::::@+    /::,:#@@:           ;::::::,+@:      ./::::::,;#@#; \n         /:::#@@,                 \\::::@@.__::::/#@#·           ;:::::::,+@;     ·::::::::::#@@;  \n        /::::@@'                   \\:::#@,:::::#@@;            ;::::::::,+@;    /:::':::::+@@+;\n       /::::@@#`                    \\ :::::::#@@+`            ;::,+',::,++@+-./:::##++::::@@#; \n      /::::#@@.                      \\::::,'#@+,             ;::,+##':::'@;,·:::+##+::::,#@#;  \n     /::::#@,                        /::::/#@@,             ;:::;#@#+·|:,'+,:::##@, ::::@##; \n    /::::@@'                        /:::@/@#,              ;:::,#@@:  ·+::,:,'#@@| .::+@@#; \n   /:::::@±±±±±±&&&                /:::#/@@.              ;:::,+@@;   ·|:,:##@@:   ;::@@#;  \n  @±±±±±±±±±±±±±/#@#;             /:::/@@#.              ;:::,+#@'     ++,'#@@;   ;::#@@+  \n  |''''''''''''|#@/+`            /±±±|@@/:              +±±±±@#@+`     '_@@.     ;±±#@#; \n  |------------|./               |±±±±|/;               |±±±±|#                  |±±±|;   \n " );
	}

    @GetMapping(value = "/login")
    public String login() {
    	return "login";
    }
    
    @GetMapping(value = "/register")
    public String register() {
    	return "register";
    }
    
    
    
    @PostMapping(value = "/login")
    @ResponseBody
    public BaseResponse login(@ModelAttribute User user, HttpSession session) {
        System.out.println(user.getName() + "---" + user.getPassword());
        User loginUser = null;
		try {
			loginUser = userService.login(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
        if(loginUser == null) {
            // 登录失败，返回登录界面
            return UserControllerResponseEnum.FAIL;
        } else {
            // 登录成功
            session.setAttribute("user", loginUser);
            return URIResponseEnum.REDIRECT.setUri("/index");
        }
    }
    @PostMapping(value = "/register")
    public String register(@ModelAttribute User user, HttpSession session, Model model) {
    	//System.out.println(user.getName() + "---" + user.getPassword());
    	User registerUser = null;
		try {
			registerUser = userService.register(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	if(registerUser == null) {
    		// 登录失败，返回登录界面
    		model.addAttribute("msg", "用户名密码错误");
    		return "index";
    	} else {
    		// 登录成功
    		session.setAttribute("user", registerUser);
    		return "redirect:/index";
    	}
    }
    
    
}
