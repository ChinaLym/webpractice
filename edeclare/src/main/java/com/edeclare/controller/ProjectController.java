package com.edeclare.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.edeclare.constant.fieldEnum.ActivityLevelEnum;
import com.edeclare.constant.fieldEnum.ProjectStatusEnum;
import com.edeclare.entity.Activity;
import com.edeclare.entity.Project;
import com.edeclare.service.IActivityService;
import com.edeclare.service.IProjectService;

@Controller
public class ProjectController {
	@Autowired
	private IProjectService projectService;
	@Autowired
	private IActivityService activityService;
	
	private static List<ProjectStatusEnum> proStatuses = new ArrayList<ProjectStatusEnum>();
    
    static {
    	proStatuses.add(ProjectStatusEnum.FIRST_TRIAL_PENDING);
    	proStatuses.add(ProjectStatusEnum.FIRST_TRIAL_PASSED);
    	proStatuses.add(ProjectStatusEnum.FIRST_TRIAL_NOT_PASS);
    	
    	proStatuses.add(ProjectStatusEnum.ESTABLISH_ON_TRIAL);
    	proStatuses.add(ProjectStatusEnum.ESTABLISHED);
    	proStatuses.add(ProjectStatusEnum.NO_ESTABLISHMENT);
    	
    	proStatuses.add(ProjectStatusEnum.MIDDLE_TRIAL_PENDING);
    	proStatuses.add(ProjectStatusEnum.MIDDLE_RECTIFICATION);
    	proStatuses.add(ProjectStatusEnum.MIDDLE_TRIAL_PASSED);
    	
    	proStatuses.add(ProjectStatusEnum.FINISHED_PENDING);
    	proStatuses.add(ProjectStatusEnum.FINAL_RECTIFICATION);
    	proStatuses.add(ProjectStatusEnum.FINISHED);
    }
	
	@GetMapping(value = "/toSbxm")
    public String toSbxm(Map<Object, Object> map) {    	
    	map.put("proStatuses", proStatuses);
    	List<Activity> activityList = activityService.getAllActivity();
    	map.put("activityList", activityList);
    	return "staff/projects/declare_projects";
    }
	
	//教职工staff申报项目
	@GetMapping(value="/declareProject")
	private String declareProject(Project project) {
		//System.out.println("declareProject begin");
		Integer acitivityId = project.getActivityId();
		Activity activity = activityService.getById(acitivityId);
		project.setLevel(activity.getLevel());
		projectService.saveProject(project);
		return "redirect:/toStaffMain";
	}
	
	//项目详情
	@GetMapping(value="/toXmxq")
	private String toXmxq(Integer id) {
		System.out.println("project_info!!!!!!!!");
		return "staff/projects/declare_info";
	}
	
}
