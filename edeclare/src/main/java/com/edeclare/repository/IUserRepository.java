package com.edeclare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edeclare.entity.User;
/**
* Type: IUserRepository
* Description: dao层，与数据库直接打交道，若自定义查询，优先走索引
* 
* 		请遵循以下规约
* 
1 ） 获取单个对象的方法用 get 做前缀。
2 ） 获取多个对象的方法用 list 做前缀。
3 ） 获取统计值的方法用 count 做前缀。
4 ） 插入的方法用 save 做前缀。
5 ） 删除的方法用 delete 做前缀。
6 ） 修改的方法用 update 做前缀。
* @author LYM
* @date Dec 16, 2018
 */
public interface IUserRepository extends JpaRepository<User, Integer> {

	User findByAccountAndPassword(String account, String password);

}