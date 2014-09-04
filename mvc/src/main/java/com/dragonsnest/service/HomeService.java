package com.dragonsnest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dragonsnest.mapper.HomeMapper;

@Service("homeService")
public class HomeService {
	
	@Autowired
	HomeMapper mapper;
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public int countUsers() {
		return mapper.selectUsers();
	}
}
