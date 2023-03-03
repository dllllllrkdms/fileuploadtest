<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>취미</h4>
	<form action="${pageContext.request.contextPath}/checkbox" method="post">
		<input type="checkbox" name="hobby" value="야구">야구
		<input type="checkbox" name="hobby" value="축구">축구
		<input type="checkbox" name="hobby" value="클라이밍">클라이밍
		<button type="submit">등록</button>
	</form>
	
	<hr>
	
	<h4>별명</h4>
	<form action="${pageContext.request.contextPath}/inputText" method="post">
		<input type="text" name="nick">
		<input type="text" name="nick">
		<button type="submit">등록</button>
	</form>
	
	<hr>
	
	<h4>커맨드 객체</h4>
	<form action="${pageContext.request.contextPath}/command" method="post">
		취미 : 
		<input type="checkbox" name="hobby" value="야구">야구
		<input type="checkbox" name="hobby" value="축구">축구
		<input type="checkbox" name="hobby" value="클라이밍">클라이밍
		
		이름 : 
		<input type="text" name="name">
		
		
		<button type="submit">등록</button>
	</form>
</body>
</html>