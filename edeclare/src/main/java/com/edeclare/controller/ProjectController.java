package com.edeclare.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.edeclare.constant.fieldEnum.ProjectStatusEnum;
import com.edeclare.entity.Activity;
import com.edeclare.entity.Project;
import com.edeclare.entity.User;
import com.edeclare.service.IActivityService;
import com.edeclare.service.IProjectService;
import com.edeclare.service.IUserService;

@Controller
public class ProjectController {
	@Autowired
	private IProjectService projectService;
	@Autowired
	private IActivityService activityService;
	@Autowired
    private IUserService userService;
	
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
	private String toXmxq(HttpSession session,Map<Object, Object> map) {
		System.out.println(session.getAttribute("user"));
		User user=(User)session.getAttribute("user");
		List<Project> projectList=projectService.findByDirector(user.getId());
		map.put("pros", projectList);
		return "staff/projects/projects_info";
	}
	

 	@GetMapping(value = "/toXmcs")
    public String toXmcs(Map<Object, Object> map) {
 		List<Project> projectList = projectService.findAllProject();
		map.put("projects", projectList);
		List<User> list=userService.findAll();
		Map<Object,Object> idAndName = new HashMap<Object,Object>();
		for (User user : list) {
			idAndName.put(user.getId(), user.getName());
		}
		map.put("idAndName", idAndName);
    	return "manager/declare/first_trial_projects";
    }
    


	//项目初审
	@GetMapping(value = "/chushen")
	public String chushen(@RequestParam(value = "id")Integer id ,Map<Object, Object> map) {
		Project pro = projectService.findById(id);
		map.put("project", pro);
		return "manager/declare/first_trial_check";
	}

	
}
