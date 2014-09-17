package com.dragonsnest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragonsnest.mapper.ManagerMapper;
import com.dragonsnest.model.Manager;

@Service
public class ManagerService {

	@Autowired
	ManagerMapper mapper;
	
	public Manager getUser(String id) {
		return mapper.getUser(id);
	}
}
