<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	hello,${staff.staffAccount}
	<div>
		<form action="<%=request.getContextPath().toString()%>/uploadMovieMessage" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>电影名称:</td><td><input type="text" name="movieName"/></td>
				</tr>
				<tr>
					<td>上映时间:</td><td><input type="text" name="startToShow"/></td>				
				</tr>
				<tr>
					<td>电影海报:</td><td><input type="file" name="poster"/></td>
				</tr>
				<tr>
					<td>剧情介绍:</td><td><input type="file" name="descrition"/></td>		
				</tr>
				<tr>
					<td><input type="submit" value="upload Movie Message"/></td><td><a href="<%=request.getContextPath().toString()%>/checkFieldByMovie"><button>查看场次</button></a></td>		
				</tr>
			</table>
		</form>
	</div>
</body>
</html>