package com.edeclare.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edeclare.entity.Activity;
import com.edeclare.repository.IActivityRepository;
import com.edeclare.service.IActivityService;

/**
* Type: ActivityServiceImpl
* Description: 实现类，
* @author AM
* @date 20190102
 */
@Service
public class ActivityServiceImpl implements IActivityService{
	private IActivityRepository activityRepository;

	@Autowired
	public void setActivityRepository(IActivityRepository activityRepository) {
		this.activityRepository = activityRepository;
	}

	@Override
	public Activity saveActivity(Activity activity) {
		Activity a=activityRepository.save(activity);
		return a;
	}

	@Override
	public List<Activity> getAllActivity() {
		List<Activity> list=activityRepository.findAll();
		return list;
	}

	@Override
	public Activity getById(Integer id) {
		return activityRepository.getOne(id);
	}
	
	
	
	
	
	
}
