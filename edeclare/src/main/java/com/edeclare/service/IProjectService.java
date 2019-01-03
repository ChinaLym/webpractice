package com.edeclare.service;

import java.util.List;

import com.edeclare.entity.Project;

public interface IProjectService {
	//教职工staff申报项目
	Project saveProject(Project project);
	
	//根据用户id查找project
	List<Project> findByDirector(Integer director);
	
	//查找所有project
	List<Project> findAllProject();
}
