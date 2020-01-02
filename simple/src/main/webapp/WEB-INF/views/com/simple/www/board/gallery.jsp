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
<script type="text/javascript">
	$(function(){
		
		$('#hbtn').click(function(){
			$(location).attr('href', '/www/main.van');
		});
		
		$('#login').click(function(){
			$(location).attr('href', '/member/login.van');
		});
		
		$('#wbtn').click(function(){
			$(location).attr('href', '/www/board/uploading.van');
		});
		
		$('.cul').click(function(){
			var gno = $(this).attr('data-id');
			alert(no);
			/* $(location).attr('href', '/www/board/gallerycontent.van?gno='+gno); */
		});
	});
</script>
</head>
<body>
	<!-- 타이틀 부분 -->
	<div class="w3-container w3-teal">
		<h1>Summer Holiday</h1>
	</div>
	<div class="w3-content w3-padding w3-margin-bottom">
		<div class="w3-button w3-small w3-orange w3-left" id="hbtn">Home</div>
		<c:if test="${empty SID}">
			<div class="w3-button w3-small w3-red w3-left" id="login">로그인</div>
		</c:if>
		<c:if test="${not empty SID}">
			<div class="w3-button w3-small w3-blue w3-right" id="wbtn">글쓰기</div>
		</c:if>
	</div>
	
	<div class="w3-row-padding w3-margin-top">
		<!-- 앨범이미지 목록 반복 부분. -->
		<c:forEach var="data" items="${LIST }">
			<div class="w3-third w3-margin-top cul" data-id="${data.gno}">
				<div class="w3-card">
					<img src="/www${data.dir}/${data.saveName }" style="width: 100%">
					<div class="w3-container">
						<h4>${data.title }</h4>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

</body>
</html>