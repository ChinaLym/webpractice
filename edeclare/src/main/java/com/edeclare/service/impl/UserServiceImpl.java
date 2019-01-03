package com.edeclare.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edeclare.entity.User;
import com.edeclare.repository.IUserRepository;
import com.edeclare.service.IUserService;
/**
* Type: UserServiceImpl
* Description: 实现类，
* @author LYM
* @date Dec 16, 2018
 */
@Service
public class UserServiceImpl implements IUserService{

    private IUserRepository userRepository;

    @Autowired
    public void setUserRepositry(IUserRepository userRepositry) {
        this.userRepository = userRepositry;
    }
    
	@Override
	public User login(User user) throws Exception{
		User u = userRepository.findByAccountAndPassword(user.getAccount(), user.getPassword());
		return u;
	}

	@Override
	public User register(User user) throws Exception{
		try {
			user.setCreateTime(new Date());
			user.setUpdateTime(new Date());
			user.setStatus("正常");
			if(user.getName() == null || "".equals(user.getName())) {
				user.setName("昵称");
			}
			user = userRepository.save(user);
			System.out.println(user);
			return user;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<User> findAll() {
		List<User> list = userRepository.findAll();
		return list;
	}
}
