package com.dragonsnest.mapper.impl;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import com.dragonsnest.mapper.ManagerMapper;
import com.dragonsnest.mapper.impl.mysql.ManagerMapperImplProvider;
import com.dragonsnest.model.Manager;

public interface ManagerMapperImpl extends ManagerMapper{

	@SelectProvider(type=ManagerMapperImplProvider.class, method="getUsersInfo")
	@Results(value={
			@Result(property="pid", column="PID"),
			@Result(property="id", column="ID"),
			@Result(property="password", column="PASSWORD"),
			@Result(property="name", column="NAME"),
			@Result(property="phone", column="PHONE")
	})
	Manager getUser(@Param("id") String id);
}
