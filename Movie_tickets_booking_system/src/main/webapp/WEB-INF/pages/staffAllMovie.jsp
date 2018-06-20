<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	hello,${staff.staffAccount}
	<div class="movieMessage">
		<c:forEach items="${list}" var="movie">
			
			<img src="${movie.posterUrl}"/>
			<h2>电影名称：${movie.movieName}</h2>
			<h3>电影名称：${movie.startToShow}</h3>
			<p>${movie.descritionUrl}</p>
			
			<form action="<%=request.getContextPath().toString()%>/addMovieField" method="post">
				<input type="hidden" value="${movie.movieId}" name="movieId"/>
				<input type="submit" value="添加场次"/>
			</form>
			<form action="<%=request.getContextPath().toString()%>/checkFieldByMovie" method="post">
				<input type="hidden" value="${movie.movieId}" name="movieId"/>
				<input type="submit" value="查看场次"/>
			</form>
			<hr>
		</c:forEach>
		</div>
</body>
</html>