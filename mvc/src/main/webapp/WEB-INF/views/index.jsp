<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false"%>
<!doctype html>
<html ng-app="todoApp">
	<head>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.0-beta.18/angular.min.js"></script>
		<script src="todo.js"></script>
		<link rel="stylesheet" href="todo.css">
	</head>
	<body>
		<h2>Todo123</h2>
	
		<P>The time on the server is ${serverTime}.</P>
		<P> Welcome! ${userName}</P>
		<div ng-controller="TodoController">
			<span>{{remaining()}} of {{todos.length}} remaining</span> [ <a
				href="" ng-click="archive()">archive</a> ]
			<ul class="unstyled">
				<li ng-repeat="todo in todos"><input type="checkbox"
					ng-model="todo.done"> <span class="done-{{todo.done}}">{{todo.text}}</span>
				</li>
			</ul>
			<form ng-submit="addTodo()">
				<input type="text" ng-model="todoText" size="30"
					placeholder="add new todo here"> <input class="btn-primary"
					type="submit" value="add">
			</form>
			
			<form action="/upload.nest">
			 	<input class="btn-primary" type="submit" value="upload">
			 </form>
			 
		</div>
		
		<a href="j_spring_security_logout">logout</a>
	</body>
</html>
