package com.edeclare.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edeclare.constant.fieldEnum.RoleStatusEnum;
import com.edeclare.entity.Role;
import com.edeclare.repository.IRoleRepository;
import com.edeclare.service.IRoleSevice;

/**
* Type: RoleServiceImpl
* Description: 实现类，
* @author PLM
* @date Dec 20, 2018
 */

@Service
public class RoleServiceImpl implements IRoleSevice {

	@Autowired
	private IRoleRepository roleRepository;
	
	//查找全部角色
	@Override
	public List<Role> getAllRle() {
		return roleRepository.findAll();
	}
	
	//通过roleId查询
	@Override
	public Role getByRoleId(Integer roleId) {
		Optional<Role> id = roleRepository.findById(roleId);
		Role role = id.get();
		return role;
	}

	//增加角色 （增加的时候需要判断数据库是否已经存在该角色名称）
	@Override
	public int saveRole(Role role) {
		
		Role role2 = roleRepository.save(role);
		return 1;
	}

	//删除角色
		//只是将角色的状态修改
	@Override
	public int deleteRoleById(Integer roleId) {
		roleRepository.deleteById(roleId);
		/*Role role = this.getByRoleId(roleId);
		role.setStatus(RoleStatusEnum.PROHIBIT.toString());
		roleRepository.saveAndFlush(role);*/
		return 0;
	}
	
	//修改角色的一些基本信息（角色名称、角色描述）
	@Override
	public int roleDoUpdate(Role role) {
		roleRepository.saveAndFlush(role);
		return 0;
	}

	@Override
	//验证数据库是否已经存在相同的角色名称
	public boolean isExists(String name) {
		Role role = roleRepository.findByName(name);
		if(role != null)
			return false;
		else
			return true;
	}
}


