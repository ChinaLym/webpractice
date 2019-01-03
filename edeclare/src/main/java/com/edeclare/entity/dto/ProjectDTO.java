package com.edeclare.entity.dto;

import com.edeclare.entity.Project;

public class ProjectDTO {

	private Project project;
	
	private String userName;

	public ProjectDTO() {
		super();
	}

	public ProjectDTO(Project project, String userName) {
		super();
		this.project = project;
		this.userName = userName;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "ProjectDTO [project=" + project + ", userName=" + userName + "]";
	}
	
	
}
