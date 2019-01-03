package com.edeclare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.edeclare.entity.Roleauthority;

public interface IRoleauthorityRepository extends JpaRepository<Roleauthority, Integer> {
	
	@Modifying@Transactional
	@Query(value = "delete from tb_role_authority where role_id =?1",nativeQuery = true)
	void delByRoleId(Integer roleId);
}