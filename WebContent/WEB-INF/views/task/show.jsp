<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Alterar tarefa - ${task.id}</h3>
	<form action="updateTask" method="post">
		<input type="hidden" name="id" value="${task.id}" /> 
		
		Descrição:<br />
		<textarea name="description" cols="100" rows="5"> ${task.description} </textarea>
		<br /> 
		Finalizado? 
		<input type="checkbox" name="finalized" value="true" ${task.finalized? 'checked' : 'unchecked' } /> 
		<br />
		Data de finalização: <br /> 
		<input type="text" name="finishingDate" value="<fmt:formatDate value="${task.finishingDate.time}" pattern="dd/MM/yyyy" />" />
		<br /> 
		
		<input type="submit" value="Alterar" />
	</form>
</body>
</html>