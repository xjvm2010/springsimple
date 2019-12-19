<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gallery page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="/www/js/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="/www/css/w3.css">
</head>
<body>
	<!-- 타이틀 부분 -->
	<div class="w3-container w3-teal">
		<h1>Summer Holiday</h1>
	</div>

	<div class="w3-row-padding w3-margin-top">
		<!-- 앨범이미지 목록 반복 부분. -->
		
		<c:forEach var="data" items="${LIST }">
			<div class="w3-third">
				<div class="w3-card">
					<img src="/www/img/avatar/img_avatar4.png" style="width: 100%">
					<div class="w3-container">
						<h4>5 Terre</h4>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

</body>
</html>