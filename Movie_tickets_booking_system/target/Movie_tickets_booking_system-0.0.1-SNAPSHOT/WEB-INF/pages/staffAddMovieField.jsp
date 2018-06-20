<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>为电影添加场次</title>
</head>
<body>
	hello,${staff.staffAccount}
	<form action="<%=request.getContextPath().toString()%>/submitFieldMessage" method="post">
		<table>
			<tr><th colspan="2" align="center">输入场次信息</th></tr>
			<tr>
				<td>电影名称:</td><td>${movie.movieName}</td>	
			</tr>
			<tr>
				<td>上映时间:</td><td>${movie.startToShow}</td>	
			</tr>
			<tr>
				<td>场次日期:</td><td><input type="text" name="showDate"></td><td><p style="color:#C0C0C0">格式为:yyyy-MM-dd</p></td>	
			</tr>
			<tr>
				<td></td><td><input type="text" name="startTime"></td><td><p style="color:#C0C0C0">格式为:hh:mm:ss</p></td>
			</tr>
			<tr>
				<td></td><td><input type="text" name="endTime"></td><td><p style="color:#C0C0C0">格式为:hh:mm:ss</p></td>	
			</tr>
			<tr>
				<td></td><td><input type="text" name="unitPrice"></td><td><p style="color:#C0C0C0">单位:HKD</p></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交场次信息"></td>	
			</tr>
		</table>
		
	</form>	
</body>
</html>