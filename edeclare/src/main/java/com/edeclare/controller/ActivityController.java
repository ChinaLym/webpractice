package com.edeclare.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
/**
*Type: ActivityController
* Description: 与Activity相关
* 	不要在Controller层进行数据安全性校验，移步至service层校验
* @author AM
* @date 20190102
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.edeclare.constant.fieldEnum.ActivityLevelEnum;
import com.edeclare.entity.Activity;
import com.edeclare.service.IActivityService;

@Controller
public class ActivityController {
	@Autowired
	private IActivityService activityService;
	private static List<ActivityLevelEnum> levels = new ArrayList<ActivityLevelEnum>();
	static {
		levels.add(ActivityLevelEnum.SCHOOL_1);
    	levels.add(ActivityLevelEnum.SCHOOL_2);
	}
	
	@GetMapping(value = "/toSbgz")
    public String toSbgz(Map<Object, Object> map) {    	
		map.put("levels", levels);
    	return "manager/declare/declare_rules";
    }
	
	//设置申报规则，即添加活动
	@PostMapping(value="/settingRule")
	private String settingRule(Activity activity) {
		System.out.println("settingRule!!!!!!");
		//System.out.println(activity.getUpdateTime());
		//System.out.println(activity.toString());
		activityService.saveActivity(activity);
		return "redirect:/toManaMain";	
	}
	
	
}
