<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script	src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#btnSummary')
	})
</script>
</head>
<body>
	<div>
		<h1>Naber Clova Summary</h1>
		제 목 : <input type="text" id="title" name="title" style="width: 70%" />
		<br> <br> 글내용 :
		<textarea rows="20" cols="100" name="content" id="content"></textarea>
		<button id="btnSummary">문장요약하기</button>
	</div>
</body>
</html>