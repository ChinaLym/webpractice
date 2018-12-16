package com.edeclare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edeclare.entity.Authority;

public interface IAuthorityRepository extends JpaRepository<Authority, Integer> {
	
}