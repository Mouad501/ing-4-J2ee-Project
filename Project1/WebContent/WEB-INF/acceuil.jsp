<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="styleToImport.html" %>
</head>
<body>
	<%@ include file="header.html" %>
	<h1>Acceuil</h1>
	<h3>bonjour ${user.username}</h3>
	
	
	<%@ include file="footer.html" %>
	<%@ include file="jsToImport.html" %>
</body>
</html>