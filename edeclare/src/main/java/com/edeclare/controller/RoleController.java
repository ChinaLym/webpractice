package com.edeclare.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edeclare.constant.fieldEnum.RoleStatusEnum;
import com.edeclare.entity.Role;
import com.edeclare.service.IRoleSevice;

/**
* Type: RoleController
* Description: 与Role相关
* 	不要在Controller层进行数据安全性校验，移步至service层校验
* @author PLM
* @date Dec 20, 2018
 */

@Controller
public class RoleController {
	@Autowired
	private IRoleSevice iRoleSevice;
	
	
	//查询全部用角色
    @GetMapping(value = "/toRoleMana")
    public String getAllRole(Model model) throws Exception {
    	List<Role> roles = iRoleSevice.getAllRle();
    	//将角色列表以及对应的权限放入session中
    	model.addAttribute("roles", roles);
    	return "manager/system_setting/role/role_list";
    }
    
    //增加角色
    @RequestMapping("/role_add")
    public String goRoleAddPage() {
    	return "manager/system_setting/role/role_add";
    }
    //异步验证角色名称
    @RequestMapping("/role_cmfirmName")
    @ResponseBody
    public String comfirmRoleName(String res) {
    	System.out.println(res + "//////");
    	if(iRoleSevice.isExists(res)) {
    		return "success";
    	}else {
    		return "error";
    	}
     }
    //执行增加角色操作
    @RequestMapping("/Role/save")
    @ResponseBody
    public String roleSave(Role role) {
    	role.setName("ROOT");
    	role.setStatus(RoleStatusEnum.NORMAL.toString());
    	role.setDescription("测试");
    	iRoleSevice.saveRole(role);
    	System.out.println("oooooook");
    	return "success";
    }
    
    //删除角色
    @RequestMapping("/Role/del")
    @ResponseBody
    public String roleDel(Integer roleId) {
    	iRoleSevice.deleteRoleById(roleId);
    	return "success";
    }
    
    //根据roleId进行查找其详细信息
    @RequestMapping("/roleEdit")
    public String roleUpdate(@RequestParam(name="id") int id, Model model) {
    	System.out.println(id);
    	Role role = iRoleSevice.getByRoleId(id);
    	model.addAttribute("role", role);
    	return "manager/system_setting/role/role_details";
    }
    
    //执行更新操作
    	//在执行更新的时候需要判断用户输入的新角色名称是否已经存在
    @RequestMapping("/Role/do_update")
    @ResponseBody
    public String roleDoUpdate(Role role) {
    	/*Role role = iRoleSevice.getByRoleId(roleId);
    	model.addAttribute("role", role);*/
    	return "success";
    }
    
}


