<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="C:/Users/ASUS/Desktop/jquery/jquery-3.3.1.min.js"></script>
<script>
$(document).ready(
		function(){
			var p = $(".movieMessage p");
			var url = p.text();
			var xmlhttp;
			if (window.XMLHttpRequest)
			  {// code for IE7+, Firefox, Chrome, Opera, Safari
			  xmlhttp=new XMLHttpRequest();
			  }
			else
			  {// code for IE6, IE5
			  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			  }
			xmlhttp.open("GET",url,false);
			xmlhttp.send();
			p.text(xmlhttp.responseText);
	});
	
	</script>
</head>
<body>
	<p>welcome!${user.username}</p>
	<a href="<%=request.getContextPath().toString()%>/register">register</a>
	<a href="<%=request.getContextPath().toString()%>/login">login</a>
	<a href="<%=request.getContextPath().toString()%>/userLoginOut">loginOut</a>
	<a href="<%=request.getContextPath().toString()%>/userMessage">check my message</a>
	<p>${message}</p>
	<hr>
	<div class="movieMessage">
		<c:forEach items="${list}" var="movie">
			<img src="${movie.posterUrl}"/>
			<h2>电影名称：${movie.movieName}</h2>
			<h3>电影名称：${movie.startToShow}</h3>
			<p>${movie.descritionUrl}</p>
			<hr>
		</c:forEach>
		<form action="" method="post">
				<input type="hidden" value="${movie.movieId}" name="movieId"/>
			</form>
		</div>
	<hr>
	<a href="<%=request.getContextPath().toString()%>/staff">staffLogin</a>
	
</body>
</html>