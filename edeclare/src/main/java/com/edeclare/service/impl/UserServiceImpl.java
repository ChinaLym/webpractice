package com.edeclare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edeclare.dao.IUserRepository;
import com.edeclare.entity.User;
import com.edeclare.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

    private IUserRepository userRepository;

	@Override
	public User login(User user) {
		User u = userRepository.findByNameAndPassword(user.getName(), user.getPassword());
		return u;
	}
    
	@Autowired
    public void setUserRepositry(IUserRepository userRepositry) {
        this.userRepository = userRepositry;
    }
}
