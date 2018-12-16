package com.edeclare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edeclare.entity.Message;

public interface IMessageRepository extends JpaRepository<Message, Integer> {

}