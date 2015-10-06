package com.dragonsnest.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dragonsnest.model.User;

@Repository("managerMapper")
public interface UserMapper {

	User selectUser(String id);
	
//	int insertUser(User user);
	
//	int insertUser1(String username, String password, String name, String phone, String role);
	
	int insertUser(Map<String, Object> params);
	
	int updateUser(User user);
	
	int deleteUser(int pid);
	
	List<User> selectUsers(User user);
}
