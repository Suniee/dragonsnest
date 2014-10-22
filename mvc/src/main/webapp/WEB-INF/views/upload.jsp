<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<body>
		<form method="POST" enctype="multipart/form-data" action="/upload.nest">
			File to upload: <input type="file" name="file"><br /> 
			Name: <input type="text" name="filename"><br /> <br /> 
			<input type="submit" value="Upload"> Press here to upload the file!
		</form>
	</body>
</html>