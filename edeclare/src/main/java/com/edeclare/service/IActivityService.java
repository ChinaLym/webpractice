package com.edeclare.service;

import java.util.List;

import com.edeclare.entity.Activity;

public interface IActivityService {
	//设置申报规则，即添加活动
	Activity saveActivity(Activity activity);
	
	//获取全部活动列表
	List<Activity> getAllActivity();
	
	//根据ID获取单个活动
	Activity getById(Integer id);
}
