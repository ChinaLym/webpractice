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

	//根据id查询project
	Project findById(Integer id);
	
	//初审通过
	Project updateState(Integer id);

	//立项通过
	Project updateStatelixiang(Integer id);

	List<Project> listProjectByDirectorIdAndNeedUploadMeterial(Integer id);

	Project updateStatusToById(Integer projectId, String newStatus);
}
