package com.dragonsnest.mapper.impl.mysql;

import java.util.Map;

public class ManagerMapperImplProvider {
	
	public static String getUsersInfo(Map<String, Object> params) {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT PID, ID, PASSWORD, NAME, PHONE FROM USERS ");
		builder.append("WHERE 1=1 ");
		String pid = null, id = null, password = null, name = null, phone = null;
		try { pid = (String)params.get("pid"); }catch(Exception e){}
		try { id = (String)params.get("id"); } catch(Exception e) {}
		try { password = (String)params.get("password"); } catch(Exception e) {}
		try { name = (String)params.get("name"); } catch(Exception e) {}
		try { phone = (String)params.get("phone"); } catch(Exception e) {}
		
		if( pid != null ) builder.append("AND PID = #{pid} ");
		if( id != null ) builder.append("AND ID = #{id} ");
		if( password != null ) builder.append("AND PASSWORD = #{password} ");
		if( name != null ) builder.append("AND NAME = #{name} ");
		if(phone != null ) builder.append("AND PHONE = #{phone} ");
		
		
		return builder.toString();
	}
}
