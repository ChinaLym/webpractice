package com.edeclare.service;

import java.util.List;

import com.edeclare.entity.Role;
import com.edeclare.entity.User;
/**
* Type: IRoleSevice
* Description: 接口，包含 role 的所用功能，接口命名以 I 开头
*
* 		该层为业务逻辑层，除了特定的业务名，推荐遵循以下规约
* 
1 ） 获取单个对象的方法用 get 做前缀。
2 ） 获取多个对象的方法用 list 做前缀。
3 ） 获取统计值的方法用 count 做前缀。
4 ） 插入的方法用 save 做前缀。
5 ） 删除的方法用 delete 做前缀。
6 ） 修改的方法用 update 做前缀。
* 
* @author PLm
* @date Dec 20, 2018
 */
public interface IRoleSevice {
	
	//获取全部角色信息
	List<Role> getAllRle();
	
	//通过roleId查询
	Role getByRoleId(Integer roleId);
	
	//增加角色
	int saveRole(Role role);
	//验证是否存在相同的角色名称
	boolean isExists(String name);
	
	//删除角色
	int deleteRoleById(Integer roleId);
	
	//更新操作
	int roleDoUpdate(Role role);
}



