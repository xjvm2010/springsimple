<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="/www/js/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="/www/css/bootstrap.min.css">
<style>
body {
	padding: 60px 10px;
	background-size: cover;
	background-image:
		url('https://www.shearwaterdental.com/dental-chair/uploads/2017/05/Shearwater-login-background-1150x719.jpg');
}
nav {
	border: 1px solid #9C9C9C;
}
</style>

</head>
<body>
	<div class="container" style="width: auto; margin-top: 100px;">
		<div class="row">
			<form method="post" action="/www/board/gallery.van" class="col-12" enctype="multipart/form-data">
				<input type="hidden" name="id" value="${SID }"/>
				<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2" style="background-color: #eeeeee; text-align: center;">사진 게시판 글쓰기</th>
						</tr>
					</thead>
					
					<tbody>
						<tr>
							<td>
							<input type="text" class="form-control" placeholder="글 제목" name="title" maxlength="50" />
							</td>
						</tr>
						
						<tr>
							<td>
							<textarea class="form-control" placeholder="글 내용" name="body" maxlength="2048" style="height: 350px;"></textarea>
							</td>
						</tr>
						
						<tr>
							<td>
								<input type="file" class="form-control"  name="sFile" />
							</td>
						</tr>
					</tbody>
				</table>
				<input type="submit" class="btn btn-primary pull-right"  value="글쓰기" />
			</form>
		</div>
	</div>


</body>

</html>
