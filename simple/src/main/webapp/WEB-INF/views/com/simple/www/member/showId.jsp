<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<c:forEach var="data" items="${LIST }">
		<li>${data.id} ${data.avt}</li>
		<img src="/www/img/avatar/${data.avt}">
		</c:forEach>
	</ul>
</body>
</html>