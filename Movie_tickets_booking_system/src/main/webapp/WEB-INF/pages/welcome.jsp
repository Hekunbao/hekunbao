<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body{
		margin:0;
	}
	#head>h1{
		text-align:center;
		display:inline-block;
		margin-left:38px;
		
	}
	
	
	#userFunction{
		margin: 38px 38px 0 0;
		display:inline-block;
		float:right;
		
	}
	
	
	#head{
		line-height:30px;
	}
	
	.movieMessage{
		margin-left:45px;
		
	}
	.movieMessage>img{
		float:left;
		height:350px;
		width:250px;
	}
	.movieMessage>div{
		margin-top:145px;
		margin-left:25px;
		float:left;
	}
	
	
</style>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
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
	
	
		<c:forEach items="${list}" var="movie">
		<div class="movieMessage">
			<img src="${movie.posterUrl}"/>
			<div>
			<h2>电影名称：${movie.movieName}</h2>
			<h3>电影名称：${movie.startToShow}</h3>
			<p>${movie.descritionUrl}</p>
			
			<form action="<%=request.getContextPath().toString()%>/checkFieldByMovie" method="post">
				<input type="hidden" value="${movie.movieId}" name="movieId"/>
				<input type="submit" value="查看场次">
			</form>
			</div>
			</div>
			<div style="clear:both; margin:0;"></div>
		<hr>
		</c:forEach>
		
		
	<hr>
	<a href="<%=request.getContextPath().toString()%>/staff">staffLogin</a>
	
</body>
</html>