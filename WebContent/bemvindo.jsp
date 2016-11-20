<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Learning Java Web</title>
</head>
<body>
	<%-- comentário em JSP aqui: nossa primeira página JSP --%>

	<%
		String mensagem = "Bem vindo ao sistema de agenda do FJ-21!";
	%>
	<%
		out.println(mensagem);
	%>

	<br />

	<%
		String desenvolvido = "Desenvolvido por Ramon Santos";
	%>
	<%=desenvolvido%>

	<br />
	<br />
	<br />


	<a href="http://localhost:8080/learning-java-web/newTask">Add
		Tarefa</a>
	<br />
	<a href="http://localhost:8080/learning-java-web/listTask">List
		Tarefa</a>
	<br />
	<a href="http://localhost:8080/learning-java-web/loginForm">Login </a>

	<%
		System.out.println("Tudo foi executado!");
	%>
</body>
</html>