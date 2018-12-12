package com.edeclare.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edeclare.entity.Project;

public interface IProjectRepository extends JpaRepository<Project, Integer> {

}