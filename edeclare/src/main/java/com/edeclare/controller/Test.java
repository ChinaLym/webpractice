package com.edeclare.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edeclare.constant.fieldEnum.ActivityLevelEnum;
import com.edeclare.constant.fieldEnum.ProjectStatusEnum;
import com.edeclare.entity.Project;
import com.edeclare.entity.Role;
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
    
    @Autowired
    private static List<Project> projects = new ArrayList<Project>();
    
    static {
    	projects.add(new Project("计算机", 1, 1, ActivityLevelEnum.SCHOOL_1.toString(), "申报项目一", "立项承诺", "好", 100, ProjectStatusEnum.FIRST_TRIAL_PENDING.toString(), "备注"));
    	projects.add(new Project("计算机", 2, 2, ActivityLevelEnum.SCHOOL_2.toString(), "申报项目二", "立项承诺", "好", 99, ProjectStatusEnum.FIRST_TRIAL_PASSED.toString(), "备注"));
    	projects.add(new Project("计算机", 3, 3, ActivityLevelEnum.SCHOOL_1.toString(), "申报项目三", "立项承诺", "好", 95, ProjectStatusEnum.FIRST_TRIAL_PENDING.toString(), "备注"));
    	projects.add(new Project("计算机", 4, 4, ActivityLevelEnum.SCHOOL_2.toString(), "申报项目四", "立项承诺", "好", 92, ProjectStatusEnum.FIRST_TRIAL_NOT_PASS.toString(), "备注"));
    	projects.add(new Project("计算机", 5, 5, ActivityLevelEnum.SCHOOL_1.toString(), "申报项目五", "立项承诺", "好", 98, ProjectStatusEnum.FIRST_TRIAL_PENDING.toString(), "备注"));
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
    public String toXmcs(Map<Object, Object> map) {
    	map.put("projects", projects);
    	return "manager/xiangmuchushen";
    }
    
    @GetMapping(value = "/chushen")
    public String chushen(Map<Object, Object> map) {
    	map.put("project", projects.get(0));
    	return "manager/chushen";
    }
    
    @GetMapping(value = "/toFpzj")
    public String toFpzj() {
    	return "manager/fenpeizhuanjia";
    }
    
    @GetMapping(value = "/toLx")
    public String toLx(Map<Object, Object> map) {
    	map.put("projects", projects);
    	return "manager/lixiang";
    }
    
    @GetMapping(value = "/lixiang")
    public String lixaing(Map<Object, Object> map) {
    	map.put("project", projects.get(0));
    	return "manager/lixiangcheck";
    }
    
    @GetMapping(value = "/toZqgz")
    public String toZqgz() {
    	return "manager/zhongqiguize";
    }
    
    @GetMapping(value = "/toJtgz")
    public String toJtgz() {
    	return "manager/jietiguize";
    }
    
    private static List<User> users = new ArrayList<User>();
    private static Date date = new Date();
    private static List<Role> roles = new ArrayList<Role>();
    static {
    	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
    	try {
			date = sdf.parse("12-27-2018");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	users.add(new User("123", "123456", "AA", "male", "15858274273", "教育部", 1, date, date, "NORMAL", "备注"));
    	users.add(new User("124", "123456", "BB", "female", "15858274273", "教育部", 2, date, date, "NORMAL", "备注"));
    	users.add(new User("125", "123456", "CC", "female", "15858274273", "教育部", 2, date, date, "NORMAL", "备注"));
    	users.add(new User("126", "123456", "DD", "male", "15858274273", "教育部", 2, date, date, "NORMAL", "备注"));
    	users.add(new User("127", "123456", "EE", "female", "15858274273", "教育部", 1, date, date, "NORMAL", "备注"));
    	users.add(new User("128", "123456", "FF", "male", "15858274273", "教育部", 1, date, date, "NORMAL", "备注"));
    	roles.add(new Role("1", "NORMAL", "角色一"));
    	roles.add(new Role("2", "NORMAL", "角色二"));
    	roles.add(new Role("3", "NORMAL", "角色三"));
    }
    
    @GetMapping(value = "/toUserMana")
    public String toUserMana(Map<Object, Object> map) {
    	map.put("users", users);
    	return "manager/usermanager";
    }
    
    @GetMapping(value = "/userInfo")
    public String userInfo(Map<Object, Object> map) {
    	map.put("user", users.get(0));
    	return "manager/userInfo";
    }
    
    @GetMapping(value = "/userEdit")
    public String userEdit(Map<Object, Object> map) {
    	map.put("user", users.get(1));
    	map.put("roles", roles);
    	return "manager/userEdit";
    }
}
