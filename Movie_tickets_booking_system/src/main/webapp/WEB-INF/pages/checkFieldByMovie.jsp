<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看电影场次</title>
</head>
<body>
<div id="head">
	<h1 style="display:inline-block;"><a href="<%=request.getContextPath().toString()%>">X X戏院</a></h1>
	<div id="userFunction">
	<span>欢迎!${user.username}${message}</span>
	<span><a href="<%=request.getContextPath().toString()%>/register">注册</a></span>
	<span><a href="<%=request.getContextPath().toString()%>/login">登陆</a></span>
	<span><a href="<%=request.getContextPath().toString()%>/userLoginOut">登出</a></span>
	<span><a href="<%=request.getContextPath().toString()%>/userMessage">查看信息</a></span>
	</div>
	<hr>
	</div>
		<table border="1px">
		<tr>
			<th>电影名称(首映时间)</th>
			<th>播放场次日期</th>
			<th>开始时间</th>
			<th>结束时间</th>
			<th>单价(HKD)</th>
		</tr>
		<c:forEach items="${fieldList}" var="movieField">
			<tr>
				<td>${movieField.movie.movieId}</td>
				<td>${movieField.showDate}</td>
				<td>${movieField.startTime}</td>
				<td>${movieField.endTime}</td>
				<td>${movieField.unitPrice}</td>
			</tr>
		</c:forEach>
		</table>
</body>
</html>