<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="login" action="j_spring_security_check" method="post">
	<c:if test="${isLoginFailed}">
		<div><font size="4" color="red"><b>Login failed! check ID and password</b></font></div>
	</c:if>
		<table border="0">
			<tr>
				<td><input type="text" name="j_username" placeHolder="Email Address" ></td>
			</tr>
			<tr>
				<td><input type="password" name="j_password" placeholder="Password" ></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="LOG IN"></td>
			</tr>
		</table>
	</form>
	<form action="/signup.nest" method="get">
		<table border=0>
			<tr>
				<td colspan="2"><input type="submit" value="SIGN UP"></td>
			</tr>
		</table>
	</form>
</body>
</html>