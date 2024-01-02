<%@page import="hello.servlet.domain.member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
 	<meta charset="UTF-8">
</head>
<body>
성공
<ul>
	<!-- property 접근법 -->
 	<li>id=${member.id}</li>
 	<li>username=${member.username}</li>
 	
 	<li>age=<%=((Member)request.getAttribute("member")).getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>