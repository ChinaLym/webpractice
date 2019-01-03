package com.edeclare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.edeclare.entity.Authority;
import com.edeclare.entity.Roleauthority;
import com.edeclare.repository.IAuthorityRepository;
import com.edeclare.repository.IRoleauthorityRepository;
import com.edeclare.service.IRoleauthorityService;

@Service
public class IRoleauthorityServiceImpl implements IRoleauthorityService {
	
	@Autowired
	private IAuthorityRepository iAuthorityRepository;
	@Autowired
	private IRoleauthorityRepository iRoleauthorityRepository;
	
	@Override
	public List<Authority> getAllAuthority() {
		return iAuthorityRepository.findAll();
	}

	@Override
	public List<Roleauthority> listByRoleId(Integer roleId) {
		Roleauthority roleauthority = new Roleauthority();
		roleauthority.setRoleId(roleId);
		Example example = Example.of(roleauthority);
		return iRoleauthorityRepository.findAll(example);
	}

}
