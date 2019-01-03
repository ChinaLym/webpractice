package com.edeclare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edeclare.constant.fieldEnum.ProjectStatusEnum;
import com.edeclare.entity.Project;
import com.edeclare.repository.IProjectRepository;
import com.edeclare.service.IProjectService;
@Service
public class ProjectServiceImpl implements IProjectService {
	@Autowired
	private IProjectRepository projectRepository;
	
	//教职工staff申报项目
	@Override
	public Project saveProject(Project project) {
		Project p=projectRepository.save(project);
		return p;
	}

	//根据用户id查找project		
	@Override
	public List<Project> findByDirector(Integer director) {
		List<Project> list=projectRepository.findByDirector(director);
		return list;
	}
	
	//查找所有project
	@Override
	public List<Project> findAllProject() {
		List<Project> list=projectRepository.findAll();
		return list;
	}


	@Override
	public Project findById(Integer id) {
		return projectRepository.getOne(id);
	}

	//初审通过
	@Override
	public Project updateState(Integer id) {
		Project project = projectRepository.getOne(id);
		project.setStatus(ProjectStatusEnum.FIRST_TRIAL_PASSED.toString());
		projectRepository.save(project);
		return project;
	}
}
