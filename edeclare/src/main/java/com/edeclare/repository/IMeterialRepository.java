package com.edeclare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edeclare.entity.Meterial;

public interface IMeterialRepository extends JpaRepository<Meterial, Integer> {

}