<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Usuarios Registrados</h2>

	Usuario Confirmado:
	<br />
	<br /> Nombre:
	<%=request.getParameter("nombre")%>
	&nbsp; Apellido:
	<%=request.getParameter("apellido")%>


</body>
</html>