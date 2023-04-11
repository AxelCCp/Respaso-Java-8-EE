<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="jee.calculos.Calculos"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Call method from JSP</h1>

	<br> LA SUMA DE 5 Y 7 ES:
	<%=Calculos.metodoSuma(5, 7)%>
	<br> LA RESTA DE 5 Y 7 ES:
	<%=jee.calculos.Calculos.metodoResta(5, 7)%>
	<br> LA MULTIPLICACION DE 5 Y 7 ES:
	<%=jee.calculos.Calculos.metodoMultiplica(5, 7)%>


</body>
</html>