<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>WELCOME!</title>
		<link rel="shortcut icon" href="./images/dragon.ico">
		 
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	    <title>DRAGONSNEST | Login</title>
	
	    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.css" rel="stylesheet">
	
	    <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
		
	</head>
	<body class="gray-bg">
	
		<div class="middle-box text-center loginscreen  animated fadeInDown">
			<div>
	            <div>
	
	                <h1 class="logo-name">DN+</h1>
	
	            </div>
					<h3>Welcome to nest+</h3>
					<p>Perfectly designed and precisely prepared admin theme with over 50 pages with extra new web app views.
					    <!--Continually expanded and constantly improved Inspinia Admin Them (IN+)-->
					</p>
					<p>Login in. To see it in action.</p>
	            
								<%-- <form name="login" action="j_spring_security_check" method="post">
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
								</form> --%>
					<form class="m-t" role="form" name="login" action="j_spring_security_check" method="post">
						<div class="form-group">
							<input name="j_username" type="email" class="form-control" placeholder="Username" required="">
						</div>
						<div class="form-group">
							<input name="j_password" type="password" class="form-control" placeholder="Password" required="">
						</div>
						<!-- if login failed -->
						<c:if test="${isLoginFailed}">
							<div class="form-group"><font size="3" color="red"><b>Invalid email or password</b></font></div>
						</c:if>
						<button type="submit" class="btn btn-primary block full-width m-b">Login</button>
					
						<a href="#"><small>Forgot password?</small></a>
						<p class="text-muted text-center"><small>Do not have an account?</small></p>
						<a class="btn btn-sm btn-white btn-block" href="register.html">Create an account</a>
					</form>
					<p class="m-t"> <small>Dragonsnest app framework base on Bootstrap 3 &copy; 2014</small> </p>
								
			</div>
		</div>
			
	    <!-- Mainly scripts -->
	    <script src="js/jquery-2.1.1.js"></script>
	    <script src="js/bootstrap.min.js"></script>
			
	</body>
</html>