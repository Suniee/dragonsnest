package com.dragonsnest.mapper.impl.mysql;

import java.util.Map;

public class UserMapperImplProvider {
	
	public static String selectUsers(Map<String, Object> params) throws Exception {
		
		StringBuilder builder = new StringBuilder();
		String id = null, password = null, name = null, phone = null, role = null;
		
		builder.append("SELECT PID, ID, PASSWORD, NAME, PHONE, ROLE ");
		builder.append("FROM USERS ");
		builder.append("WHERE 1=1 ");

		try { id = (String)params.get("id"); } catch(Exception e) {}
		try { password = (String)params.get("password"); } catch(Exception e) {}
		try { name = (String)params.get("name"); } catch(Exception e) {}
		try { phone = (String)params.get("phone"); } catch(Exception e) {}
		try { role = (String)params.get("role"); } catch(Exception e) {}

		if( id != null ) builder.append("AND ID = #{id} ");
		if( password != null ) builder.append("AND PASSWORD = #{password} ");
		if( name != null ) builder.append("AND NAME = #{name} ");
		if(phone != null ) builder.append("AND PHONE = #{phone} ");
		if(role != null ) builder.append("AND ROLE = #{role} ");
		
		return builder.toString();
	}
	
	public static String insertUser(Map<String, Object> params) throws Exception {

		String phone = null;
		StringBuilder builder = new StringBuilder();
		
		builder.append("INSERT INTO ");
		builder.append("USERS(ID, PASSWORD, NAME, ROLE");
		
		try { phone = (String)params.get("phone"); } catch(Exception e) {}     
		
		if(phone != null) builder.append(", PHONE");
		
		builder.append(")");
		builder.append("VALUES( #{userid}, #{password}, #{username}, #{role} ) ");
		
		if(phone != null) builder.append(", #{phone}");
		
		
		return builder.toString();
	}
	
	public static String updateUser(Map<String, Object> params)  throws Exception {
		StringBuilder builder = new StringBuilder();
		String password = null, name = null, phone = null, role = null;

		try { password = (String)params.get("password");    } catch(Exception e) {}     
		try { name = (String)params.get("name");            } catch(Exception e) {}     
		try { phone = (String)params.get("phone");          } catch(Exception e) {}     
		try { role = (String)params.get("role");            } catch(Exception e) {}     
		
		builder.append("UPDATE USERS SET ");
		builder.append("ID = #{id} ");
		
		if(password != null)  builder.append(", PASSWORD=#{password} ");
		if(name != null) builder.append(", NAME=#{name} ");
		if(phone != null) builder.append(", PHONE=#{phone} ");
		if(role != null) builder.append(", ROLE=#{role} ");
		
		builder.append("WHERE 1=1 pid=#{pid} ");
		
		return builder.toString();
	}
	
	public static String deleteUser(Map<String, Object> params) throws Exception {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("DELETE FROM USERS WHERE 1=1 ");
		builder.append("AND PID=#{pid} ");
		
		return builder.toString();
	}
}
