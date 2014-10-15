package com.dragonsnest.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dragonsnest.mapper.UserMapper;
import com.dragonsnest.model.User;

@Service
public class UserService {

	@Autowired
	UserMapper mapper;
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public User selectUser(String id) {
		return mapper.selectUser(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public int insertUser(User user) {
		return mapper.insertUser(user);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public int insertUser1(String username, String password) {
		String name = "", phone = "", role = "";
		return mapper.insertUser1(username, password, name, phone, role);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public int insertUser2(Map<String, Object> params) {
		return mapper.insertUser2(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public int updateUser(User user) {
		return mapper.updateUser(user);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public int deleteUser(int pid) {
		return mapper.deleteUser(pid);
	}
}
