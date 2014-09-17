package com.dragonsnest.mapper;

import org.springframework.stereotype.Repository;

import com.dragonsnest.model.Manager;

@Repository("managerMapper")
public interface ManagerMapper {

	Manager getUser(String id);
}
