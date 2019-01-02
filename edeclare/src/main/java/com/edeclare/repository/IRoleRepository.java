package com.edeclare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edeclare.entity.Role;

public interface IRoleRepository extends JpaRepository<Role, Integer> {
	//根据角色名称查找
	Role findByName(String name);
}