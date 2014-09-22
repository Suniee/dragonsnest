<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="j_spring_security_check" method="post">
		<table border="0">
			<tr>
				<td>아이디나 비밀번호를 확인하세요!</td>
				
			</tr>
			<tr>
				<td>ID:</td>
				<td><input type="text" name="j_username"></td>
			</tr>
			<tr>
				<td>패스워드:</td>
				<td><input type="password" name="j_password"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
</body>
</html>