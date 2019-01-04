package com.edeclare.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.edeclare.annotation.LoginRequired;
import com.edeclare.constant.SessionKey;
import com.edeclare.constant.fieldEnum.RoleStatusEnum;
import com.edeclare.constant.fieldEnum.UserSexEnum;
import com.edeclare.constant.fieldEnum.UserStatusEnum;
import com.edeclare.entity.Project;
import com.edeclare.entity.Role;
import com.edeclare.entity.User;
import com.edeclare.entity.dto.ProjectDTO;
import com.edeclare.service.IProjectService;
import com.edeclare.service.IRoleSevice;
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
    
    //去管理员主页
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
    
    //去教职工主页
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
    
    //去专家主页
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
    
    private List<Role> roles = new ArrayList<Role>();
    private static List<UserSexEnum> sexes = new ArrayList<UserSexEnum>();
    private static List<UserStatusEnum> userStatuses = new ArrayList<UserStatusEnum>();
    
    @Autowired
    private IRoleSevice roleSevice;
    
    static {
    	sexes.add(UserSexEnum.MALE);
    	sexes.add(UserSexEnum.FEMALE);
    	sexes.add(UserSexEnum.SECRET);
    	userStatuses.add(UserStatusEnum.NORMAL);
    	userStatuses.add(UserStatusEnum.FREEZING);
    	userStatuses.add(UserStatusEnum.EXCEPTIONS);
    	userStatuses.add(UserStatusEnum.DESTROYED);
    }
    
    //去所有user列表
    @GetMapping(value = "/toUserMana")
    public String toUserMana(Map<Object, Object> map) {
    	List<User> users = userService.findAll();
    	map.put("users", users);
    	return "manager/user/users_info";
    }
    
    @GetMapping(value = "/userInfo")
    public String userInfo(Map<Object, Object> map, @RequestParam(value = "id")Integer id) {
    	User user = userService.findById(id);
    	roles = roleSevice.getAllRle();
    	map.put("user", user);
    	map.put("sexes", sexes);
    	map.put("roles", roles);
    	map.put("userStatuses", userStatuses);
    	return "manager/user/user_check";
    }
    
    @GetMapping(value = "/userEdit")
    public String userEdit(Map<Object, Object> map, @RequestParam(value = "id")Integer id) {
    	User user = userService.findById(id);
    	roles = roleSevice.getAllRle();
    	map.put("user", user);
    	map.put("sexes", sexes);
    	map.put("roles", roles);
    	map.put("userStatuses", userStatuses);
    	return "manager/user/user_edit";
    }
    
    @PostMapping(value = "/userUpdate")
    public String userUpdate(User user) {
    	userService.save(user);
    	return "redirect:/toUserMana";
    }
    
    @GetMapping(value = "/userInsert")
    public String userInsert(Map<Object, Object> map) {
    	roles = roleSevice.getAllRle();
    	map.put("sexes", sexes);
    	map.put("roles", roles);
    	map.put("userStatuses", userStatuses);
    	return "manager/user/user_insert";
    }
    
    @PostMapping(value = "/userInsert")
    public String userAdd(User user) {
    	userService.save(user);
    	return "redirect:/toUserMana";
    }
    
    
    @GetMapping(value = "/userDelete")
    public String userDelete(@RequestParam(value = "id")Integer id) {
    	userService.delete(id);
    	return "redirect:/toUserMana";
    }
    
    @GetMapping(value = "/toMyInfo")
    public String toMyInfo(Map<Object, Object> map, @RequestParam(value = "id")Integer id) {
    	User user = userService.findById(id);
    	roles = roleSevice.getAllRle();
    	map.put("user", user);
    	map.put("sexes", sexes);
    	map.put("roles", roles);
    	map.put("userStatuses", userStatuses);
    	return "manager/my/user_check";
    }
    
    @GetMapping(value = "/toMyResetPassword")
    public String toMyResetPassword(Map<Object, Object> map, @RequestParam(value = "id")Integer id) {
    	User user = userService.findById(id);
    	roles = roleSevice.getAllRle();
    	map.put("user", user);
    	map.put("sexes", sexes);
    	map.put("roles", roles);
    	map.put("userStatuses", userStatuses);
    	return "manager/my/user_resetPass";
    }
    
    @PostMapping(value = "/userResetPass")
    public String userResetPass(User user) {
    	User u = userService.findById(user.getId());
    	u.setPassword(user.getPassword());
    	userService.save(u);
    	return "redirect:/toManaMain";
    }
}
