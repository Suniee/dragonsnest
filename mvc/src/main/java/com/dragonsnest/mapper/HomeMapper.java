package com.dragonsnest.mapper;

import org.springframework.stereotype.Repository;

@Repository("homeMapper")
public interface HomeMapper {
	
	int selectUsers();
}
