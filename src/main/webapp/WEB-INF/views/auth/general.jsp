<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="s" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>general page</h1>
	<s:authorize access="isAnonymous()">
		<a href="/customLogin">로그인</a>
	</s:authorize>
	<s:authorize access="isAuthenticated()">
		<a href="/customLogout">로그아웃</a>
	</s:authorize>
	
</body>
</html>