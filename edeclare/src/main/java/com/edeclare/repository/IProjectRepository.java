package com.edeclare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edeclare.entity.Project;

public interface IProjectRepository extends JpaRepository<Project, Integer> {

}