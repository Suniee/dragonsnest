<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 	
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Register</title>

    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
</head>


<body class="gray-bg">

    <div class="middle-box text-center loginscreen   animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">DN+</h1>

            </div>
            <h3>Register to DN+</h3>
            <p>Create account to see it in action.</p>
            
            <form class="m-t" role="form" action="${pageContext.request.contextPath}/signup.nest" method="post">
                <div class="form-group">
                    <input name="username" type="text" class="form-control" placeholder="Name" required="" >
                </div>
                <div class="form-group">
                    <input name="userid" type="email" class="form-control" placeholder="Email" required="" >
                </div>
                <div class="form-group">
                    <input name="password" type="password" class="form-control" placeholder="Password" required="" >
                </div>
                <div class="form-group">
                        <div class="checkbox i-checks"><label> <input type="checkbox"><i></i> Agree the terms and policy </label></div>
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">Sign up</button>

                <p class="text-muted text-center"><small>Already have an account?</small></p>
                <a class="btn btn-sm btn-white btn-block" href="${pageContext.request.contextPath}/login.html">Login</a>
            </form>
            <p class="m-t"> <small>Inspinia we app framework base on Bootstrap 3 &copy; 2014</small> </p>
        </div>
    </div>

    <!-- Mainly scripts -->
    <script src="js/jquery-2.1.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- iCheck -->
    <script src="js/plugins/iCheck/icheck.min.js"></script>
    <script>
        $(document).ready(function(){
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
    </script>
</body>
<!-- 
<body>
	<form action="signup.nest" method="post">
		<table border="0">
			<tr>
				<td><input type="text" name="username" placeholder="Email Address"></td>
			</tr>
			<tr>
				<td><input type="text" name="name" placeholder="Nick Name"></td>
			</tr>
			<tr>
				<td><input type="password" name="password"
					placehoder="Password"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="SIGN UP"></td>
			</tr>
		</table>
	</form>
</body> -->
</html>