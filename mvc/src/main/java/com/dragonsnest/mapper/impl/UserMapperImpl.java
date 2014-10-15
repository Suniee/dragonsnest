package com.dragonsnest.mapper.impl;

import java.util.Map;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.dragonsnest.mapper.UserMapper;
import com.dragonsnest.mapper.impl.mysql.UserMapperImplProvider;
import com.dragonsnest.model.User;

public interface UserMapperImpl extends UserMapper{

	@SelectProvider(type=UserMapperImplProvider.class, method="selectUsers")
	@Results(value={
			@Result(property="pid", column="PID"),
			@Result(property="id", column="ID"),
			@Result(property="password", column="PASSWORD"),
			@Result(property="name", column="NAME"),
			@Result(property="phone", column="PHONE"),
			@Result(property="role", column="ROLE")
	})
	User selectUser(@Param("id") String id);
	
	@InsertProvider(type=UserMapperImplProvider.class, method="insertUser")
	int insertUser(User user);
	
	@InsertProvider(type=UserMapperImplProvider.class, method="insertUser")
	int insertUser1(
			@Param("id") String id, 
			@Param("password") String password,
			@Param("name") String name,
			@Param("phone") String phone, 
			@Param("role") String role
			);
	
	@InsertProvider(type=UserMapperImplProvider.class, method="insertUser")
	int insertUser2(@Param("param") Map<String, Object> params);
	
	@UpdateProvider(type=UserMapperImplProvider.class, method="updateUser")
	int updateUser(User user);
	
	@DeleteProvider(type=UserMapperImplProvider.class, method="deleteUser")
	int deleteUser(int pid);
}
