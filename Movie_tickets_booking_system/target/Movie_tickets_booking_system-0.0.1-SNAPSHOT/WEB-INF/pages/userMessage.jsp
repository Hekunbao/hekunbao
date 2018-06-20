<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>account:</td><td>${user.userAccount}</td>
		</tr>
		<tr>
			<td>username:</td><td>${user.username}</td>
		</tr>
		<tr>
			<td>password:</td><td>${user.password}</td>
		</tr>
		<tr>
			<td>email</td><td>${user.email}</td>
		</tr>
		<tr>
			<td colspan="2"><a href="<%=request.getContextPath().toString()%>/modify"><button>modify</button></a></td>
		</tr>
	</table>
</body>
</html>