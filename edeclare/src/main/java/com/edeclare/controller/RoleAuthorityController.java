package com.edeclare.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edeclare.entity.Authority;
import com.edeclare.entity.Role;
import com.edeclare.entity.Roleauthority;
import com.edeclare.service.IRoleSevice;
import com.edeclare.service.IRoleauthorityService;

@Controller
public class RoleAuthorityController {
	
	@Autowired
	private IRoleSevice iRoleSevice;
	@Autowired
	IRoleauthorityService iRoleauthorityService; 
	
	@RequestMapping("/toAssignPer")
	public String goAuthorityPage(@RequestParam(name="id",defaultValue="1")int id, Model model) {
		Role role = iRoleSevice.getByRoleId(id);
		List<Roleauthority> roleAuthoritys = iRoleauthorityService.listByRoleId(id);
		model.addAttribute("role", role);
		List<Integer> ids = new ArrayList<>();
		for(Roleauthority r: roleAuthoritys ) {
			ids.add(r.getAuthorityId());
		}
		model.addAttribute("roleAuthoritys", ids);
		List<Role> roles = iRoleSevice.getAllRle();
		List<Authority> authoritys = iRoleauthorityService.getAllAuthority();
		model.addAttribute("roles", roles);
		authoritys.remove(0);
		model.addAttribute("authoritys", authoritys);
		return "manager/system_setting/authority/role_authority";
	}
	
	
}
