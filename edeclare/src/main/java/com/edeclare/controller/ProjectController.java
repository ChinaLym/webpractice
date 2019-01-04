package com.edeclare.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edeclare.annotation.LoginRequired;
import com.edeclare.constant.SessionKey;
import com.edeclare.constant.fieldEnum.ActivityLevelEnum;
import com.edeclare.constant.fieldEnum.ProjectStatusEnum;
import com.edeclare.entity.Activity;
import com.edeclare.entity.Project;
import com.edeclare.entity.User;
import com.edeclare.entity.dto.ProjectDTO;
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
	private static List<ActivityLevelEnum> levels = new ArrayList<ActivityLevelEnum>();
    
    static {
    	levels.add(ActivityLevelEnum.SCHOOL_1);
    	levels.add(ActivityLevelEnum.SCHOOL_2);
    	proStatuses.add(ProjectStatusEnum.FIRST_TRIAL_PENDING);
    	proStatuses.add(ProjectStatusEnum.FIRST_TRIAL_PASSED);
    	proStatuses.add(ProjectStatusEnum.FIRST_TRIAL_NOT_PASS);
    	
    	proStatuses.add(ProjectStatusEnum.ESTABLISH_ON_TRIAL);
    	proStatuses.add(ProjectStatusEnum.ESTABLISH_FINISHED);
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
	
	//去项目初审列表
 	@GetMapping(value = "/toXmcs")
    public String toXmcs(Map<Object, Object> map) {
 		List<Project> projectList = projectService.findAllProject();
		if(projectList== null || projectList.size() == 0) {
	    	return "manager/declare/first_trial_projects";			
		}
		List<ProjectDTO> projectDTOList = new ArrayList<ProjectDTO>();	
		User u = new User();
		for (Project pro : projectList) {
			if(pro.getStatus().equals(ProjectStatusEnum.FIRST_TRIAL_PENDING.toString())) {
				ProjectDTO proDTO = new ProjectDTO();
				u = userService.findById(pro.getDirector());
				proDTO.setProject(pro);
				proDTO.setUserName(u.getName());
				projectDTOList.add(proDTO);
			}
		}
		map.put("projectDTOList", projectDTOList);
    	return "manager/declare/first_trial_projects";
    }
    
	//项目初审
	@GetMapping(value = "/chushen")
	public String chushen(@RequestParam(value = "id")Integer id ,Map<Object, Object> map) {
		Project pro = projectService.findById(id);
		map.put("levels", levels);
    	map.put("proStatuses", proStatuses);
		map.put("project", pro);
		return "manager/declare/first_trial_check";
	}
	
	//初审通过
	@PostMapping(value="/firstCheck")
	public String tosettingRule(Project project) {
		projectService.updateState(project.getId());
		return "redirect:/toXmcs";
	}
	

	//去立项列表
	@GetMapping(value = "/toLx")
    public String toLx(Map<Object, Object> map) {
 		List<Project> projectList = projectService.findAllProject();
		if(projectList== null || projectList.size() == 0) {
	    	return "manager/declare/establist_projects";			
		}
		List<ProjectDTO> projectDTOList = new ArrayList<ProjectDTO>();	
		User u = new User();
		for (Project pro : projectList) {
			if(pro.getStatus().equals(ProjectStatusEnum.ESTABLISH_FINISHED.toString())) {
				ProjectDTO proDTO = new ProjectDTO();
				u = userService.findById(pro.getDirector());
				proDTO.setProject(pro);
				proDTO.setUserName(u.getName());
				projectDTOList.add(proDTO);
			}
		}
		map.put("projectDTOList", projectDTOList);
    	return "manager/declare/establish_projects";
    }
	
	//去立项页面
	@GetMapping(value = "/lixiang")
	public String lixiang(@RequestParam(value = "id")Integer id ,Map<Object, Object> map) {
		Project pro = projectService.findById(id);
		map.put("levels", levels);
    	map.put("proStatuses", proStatuses);
		map.put("project", pro);
		return "manager/declare/establish_check";
	}
	
	//立项通过
	@PostMapping(value="/establistCheck")
	public String establistCheck(Project project) {
		projectService.updateStatelixiang(project.getId());
		return "redirect:/toLx";
	}
	
	
	//专家审核项目详情
	@GetMapping(value = "/toShxm")
	public String toShxm(Map<Object, Object> map) {
		List<Project> projectList = projectService.findAllProject();
		if(projectList== null || projectList.size() == 0) {
	    	return "professor/projects_info";			
		}
		List<ProjectDTO> projectDTOList = new ArrayList<ProjectDTO>();
		User u = new User();
		for (Project pro : projectList) {
			if(pro.getStatus().equals(ProjectStatusEnum.FIRST_TRIAL_PASSED.toString())) {
				ProjectDTO proDTO = new ProjectDTO();
				u = userService.findById(pro.getDirector());
				if(u != null) {
					proDTO.setProject(pro);
					proDTO.setUserName(u.getName());
					projectDTOList.add(proDTO);
				}
			}
		}
		System.out.println(projectDTOList);
		map.put("projectDTOList", projectDTOList);
		return "professor/projects_info";
	}

	//专家审核项目
	@GetMapping(value = "/shenhe")
	public String shenhe(@RequestParam(value = "id") Integer id, Map<Object, Object> map) {
		Project pro = projectService.findById(id);
		map.put("levels", levels);
    	map.put("proStatuses", proStatuses);
		map.put("project", pro);
		return "professor/check_project";
	}
	
	//专家审核完成
	@PostMapping(value = "/proCheck")
	public String proCheck(Project project) {
		Project pro = projectService.findById(project.getId());
		System.out.println(project.getScore() + ", " + pro.getRemarks());
		pro.setRemarks(project.getRemarks());
		pro.setScore(project.getScore());
		pro.setStatus(ProjectStatusEnum.ESTABLISH_FINISHED.toString());
		projectService.saveProject(pro);
		return "redirect:/toShxm";
	}
	
	//去到设置中期检查规则表单
	@GetMapping(value = "/toZqgz")
    public String toZqgz() {
    	return "manager/middle_trial/setting_rules";
    }
	
	//提交中期规则表单
	
	
	//去到设置结题检查规则表单
    @GetMapping(value = "/toJtgz")
    public String toJtgz() {
    	return "manager/final_trial/setting_rules";
    }
	
	//去到需要添加中期材料项目列表
	@LoginRequired
    @GetMapping(value = "/toZqcl")
    public String toZqcl(Map<Object, Object> map, HttpSession session) {
    	List<Project> pros = new ArrayList<Project>();
    	User sessionUser = (User)session.getAttribute(SessionKey.USER);
    	pros = projectService.listProjectByDirectorIdAndNeedUploadMeterial(sessionUser.getId());
    	map.put("pros", pros);
    	return "staff/projects/middle_projects";
    }
	
	//去到需要添加结题材料项目列表
	@LoginRequired
    @GetMapping(value = "/toJtcl")
    public String toJtcl(Map<Object, Object> map, HttpSession session) {
		List<Project> pros = new ArrayList<Project>();
    	User sessionUser = (User)session.getAttribute(SessionKey.USER);
    	pros = projectService.listProjectByDirectorIdAndNeedUploadMeterial(sessionUser.getId());
    	map.put("pros", pros);
    	return "staff/projects/final_projects";
    }
}
