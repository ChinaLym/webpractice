package com.edeclare.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.edeclare.annotation.LoginRequired;
import com.edeclare.constant.SessionKey;
import com.edeclare.entity.Project;
import com.edeclare.entity.User;
import com.edeclare.entity.dto.ProjectDTO;
import com.edeclare.service.IProjectService;
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
    
    public UserController() {
		//System.out.println("\n           /:::,'.               |::::@'       /::::/##            ++++++++'         ·/++++++++#+  \n          /:::#@@.               \\:::::@+    /::,:#@@:           ;::::::,+@:      ./::::::,;#@#; \n         /:::#@@,                 \\::::@@.__::::/#@#·           ;:::::::,+@;     ·::::::::::#@@;  \n        /::::@@'                   \\:::#@,:::::#@@;            ;::::::::,+@;    /:::':::::+@@+;\n       /::::@@#`                    \\ :::::::#@@+`            ;::,+',::,++@+-./:::##++::::@@#; \n      /::::#@@.                      \\::::,'#@+,             ;::,+##':::'@;,·:::+##+::::,#@#;  \n     /::::#@,                        /::::/#@@,             ;:::;#@#+·|:,'+,:::##@, ::::@##; \n    /::::@@'                        /:::@/@#,              ;:::,#@@:  ·+::,:,'#@@| .::+@@#; \n   /:::::@±±±±±±&&&                /:::#/@@.              ;:::,+@@;   ·|:,:##@@:   ;::@@#;  \n  @±±±±±±±±±±±±±/#@#;             /:::/@@#.              ;:::,+#@'     ++,'#@@;   ;::#@@+  \n  |''''''''''''|#@/+`            /±±±|@@/:              +±±±±@#@+`     '_@@.     ;±±#@#; \n  |------------|./               |±±±±|/;               |±±±±|#                  |±±±|;   \n " );
	}

    @GetMapping(value = "/login")
    public String login() {
    	return "login";
    }
    
    @GetMapping(value = "/register")
    public String register() {
    	return "register";
    }
    
    
    
    @PostMapping(value = "/loginconfirm")    
    public String loginconfirm(User user, HttpSession session) {
        User loginUser = null;
		try {
			loginUser = userService.login(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
        if(loginUser == null) {
            // 登录失败，返回登录界面
        	 System.out.println("login false");
        	return "redirect:/login";
        } else {
            // 登录成功,判断用户角色
            session.setAttribute("user", loginUser);
            session.setAttribute("username", loginUser.getName());
            System.out.println("login success");
            if(loginUser.getRoleId()==1||loginUser.getRoleId()==2) {
            	return "redirect:/toManaMain";
            }else if(loginUser.getRoleId()==3) {
            	//专家
            	return "redirect:/toProMain";
            }else if(loginUser.getRoleId()==4) {
            	//教职工
            	return "redirect:/toStaffMain";
            }else {
            	System.out.println("未找到对应角色，将返回登录页面。");
            	return "redirect:/login";
            }
            
        }
    }
    
    @PostMapping(value = "/register")
    public String register(@RequestBody User user, HttpSession session, Model model) {
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
    		session.setAttribute(SessionKey.USER, registerUser);
    		return "redirect:/index";
    	}
    }


    @GetMapping(value = "/logout")
    public String logout() {
    	return "redirect:/login";
    }
    
    @Autowired
    private IProjectService projectService;
    
    @GetMapping(value = "/toManaMain")
    public String toManaMain(Map<Object, Object> map) {
    	List<Project> projectList = projectService.findAllProject();
		if(projectList== null || projectList.size() == 0) {
	    	return "manager/main";			
		}
		List<ProjectDTO> projectDTOList = new ArrayList<ProjectDTO>();	
		User u = new User();
		for (Project pro : projectList) {
			ProjectDTO proDTO = new ProjectDTO();
			u = userService.findById(pro.getDirector());
			proDTO.setProject(pro);
			proDTO.setUserName(u.getName());
			projectDTOList.add(proDTO);
		}
		map.put("projectDTOList", projectDTOList);
    	return "manager/main";
    }
    
    @GetMapping(value = "/toStaffMain")
    public String toStaffMain(Map<Object, Object> map) {
    	List<Project> projectList = projectService.findAllProject();
		if(projectList== null || projectList.size() == 0) {
	    	return "staff/main";			
		}
		List<ProjectDTO> projectDTOList = new ArrayList<ProjectDTO>();	
		User u = new User();
		for (Project pro : projectList) {
			ProjectDTO proDTO = new ProjectDTO();
			u = userService.findById(pro.getDirector());
			proDTO.setProject(pro);
			proDTO.setUserName(u.getName());
			projectDTOList.add(proDTO);
		}
		map.put("projectDTOList", projectDTOList);
    	return "staff/main";
    }
    
    @GetMapping(value = "/toProMain")
    public String toProMain(Map<Object, Object> map) {
    	List<Project> projectList = projectService.findAllProject();
		if(projectList== null || projectList.size() == 0) {
	    	return "professor/main";			
		}
		List<ProjectDTO> projectDTOList = new ArrayList<ProjectDTO>();	
		User u = new User();
		for (Project pro : projectList) {
			ProjectDTO proDTO = new ProjectDTO();
			u = userService.findById(pro.getDirector());
			proDTO.setProject(pro);
			proDTO.setUserName(u.getName());
			projectDTOList.add(proDTO);
		}
		map.put("projectDTOList", projectDTOList);
    	return "professor/main";
    }
    
}
