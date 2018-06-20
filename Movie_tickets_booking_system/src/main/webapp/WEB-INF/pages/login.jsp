<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	<form action="<%=request.getContextPath().toString()%>/userLogin" method="post">
		<table>
			<tr>
				<td>account:</td>
				<td><input type="text" name="userAccount"></td>
			</tr>
			<tr>
				<td>password:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="login"></td>
			</tr>
		</table>
	</form>
</body>
</html>