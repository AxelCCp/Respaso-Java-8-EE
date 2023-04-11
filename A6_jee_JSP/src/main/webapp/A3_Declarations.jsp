<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Declarations example</h1>

	<%!private int resultado;

	public int metodoSuma(int num1, int num2) {
		resultado = num1 + num2;
		return resultado;
	}

	public int metodoResta(int num1, int num2) {
		resultado = num1 - num2;
		return resultado;
	}

	public int metodoMultiplica(int num1, int num2) {
		resultado = num1 * num2;
		return resultado;
	}%>

	LLamada al metodo, la suma es:
	<%=metodoSuma(7, 6)%>
	<br> LLamada al metodo, la resta es:
	<%=metodoResta(7, 6)%>
	<br> LLamada al metodo, la multiplicacion es:
	<%=metodoSuma(7, 6)%>
</body>
</html>