package com.dragonsnest.mapper.mysql;

import org.apache.ibatis.annotations.Select;

import com.dragonsnest.mapper.HomeMapper;

public interface HomeMapperImpl extends HomeMapper {
	
	
	@Select("select count(*) from users")
	int selectUsers();
}
