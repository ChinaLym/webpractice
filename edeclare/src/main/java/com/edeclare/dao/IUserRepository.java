package com.edeclare.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edeclare.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

	User findByNameAndPassword(String name, String password);

}