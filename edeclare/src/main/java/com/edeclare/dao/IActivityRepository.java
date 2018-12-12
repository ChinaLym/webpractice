package com.edeclare.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edeclare.entity.Activity;

public interface IActivityRepository extends JpaRepository<Activity, Integer> {

}