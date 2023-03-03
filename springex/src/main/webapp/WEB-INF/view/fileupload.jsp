<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>싱글 파일 업로드</h4>
	<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/singleFileupload" method="post">
		이름 : <input type="text" name="name"><br>
		사진 : <input type="file" name="pic"><br>
		<button type="submit">등록</button>
	</form>
	
	<hr>
	
	<h4>멀티 파일 업로드</h4>
	<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/multiFileupload" method="post">
		이름 : <input type="text" name="name"><br>
		사진1 : <input type="file" name="pic"><br>
		사진2 : <input type="file" name="pic"><br>
		<button type="submit">등록</button>
	</form>
</body>
</html>