<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Qna Write From Page</h1>
	
	<form action="./qnaWrite" method="POST">
		<input type="text" name="title">
		<input type="text" name="writer">
		<input type="text" name="age">
		<p>
			1<input type="checkbox" name="name" value="1">
			2<input type="checkbox" name="name" value="2">
			3<input type="checkbox" name="name" value="3">
			4<input type="checkbox" name="name" value="4">
		<button>Click</button>
	</form>
	
	
	<a href="../">Home</a>
</body>
</html>