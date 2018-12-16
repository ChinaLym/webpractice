package com.edeclare.service;

import com.edeclare.entity.User;
/**
* Type: IUserService
* Description: 接口，包含 user 的所用功能，接口命名以 I 开头
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
* @author LYM
* @date Dec 16, 2018
 */
public interface IUserService {

	User login(User user) throws Exception;

	User register(User user) throws Exception;

}
