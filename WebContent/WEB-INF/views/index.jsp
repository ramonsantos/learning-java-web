<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Home</h2>
    <p>Bem vindo, ${userCurrent.fullName}.  <a href="logout">Logout</a></p> 
    <br/>
    
    <a href="http://localhost:8080/learning-java-web/newTask">Add Tarefa</a>
	<br />
	<a href="http://localhost:8080/learning-java-web/listTask">List	Tarefa</a>
	<br /><br />
	
	<a href="http://localhost:8080/learning-java-web/newContact">Add Contato</a>
	<br />
	<a href="http://localhost:8080/learning-java-web/listContact">List Contato</a>
	
</body>
</html>