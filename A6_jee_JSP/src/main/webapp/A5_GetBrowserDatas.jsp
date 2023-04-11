<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Browser Data</h1>
	
	datos del navegador:
	<%=request.getHeader("User-Agent") %> 
	
	<br>
	
	idioma:
	<%=request.getLocale() %>

</body>
</html>