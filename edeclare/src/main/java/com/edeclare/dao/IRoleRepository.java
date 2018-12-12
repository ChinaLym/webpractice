package com.edeclare.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edeclare.entity.Role;

public interface IRoleRepository extends JpaRepository<Role, Integer> {

}