<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新座位表</title>
</head>
<body>
	<form action="<%=request.getContextPath().toString()%>/submitSeatingTable" method="post">
		排数:<input type="text" name="rows"/><br>
		列数:<input type="text" name="cols"/><br>
		<input type="submit" value="submit"/>
	</form>
	<hr>
	<a href="<%=request.getContextPath().toString()%>/deleteSeatingTable">清空座位表</a>
</body>
</html>