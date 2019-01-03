package com.edeclare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
