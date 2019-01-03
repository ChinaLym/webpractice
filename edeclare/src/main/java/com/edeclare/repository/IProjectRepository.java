package com.edeclare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edeclare.entity.Project;

public interface IProjectRepository extends JpaRepository<Project, Integer> {
	//根据用户id查找project
	List<Project> findByDirector(Integer director);
}