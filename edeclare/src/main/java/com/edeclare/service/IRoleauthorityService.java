package com.edeclare.service;

import java.util.List;


import com.edeclare.entity.Authority;
import com.edeclare.entity.Roleauthority;

public interface IRoleauthorityService {
	List<Authority> getAllAuthority();
	List<Roleauthority> listByRoleId(Integer roleId);
}
