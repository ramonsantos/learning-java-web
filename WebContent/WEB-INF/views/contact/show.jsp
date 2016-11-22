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
	<h3>Alterar contato - ${contact.id}</h3>
	<form action="updateContact" method="post">
		<input type="hidden" name="id" value="${contact.id}" />
		
		Nome: <br />
		<input type="text" name="name" value="${contact.name}" />
		<br />
		
		Email: <br />
		<input type="text" name="email" value="${contact.email}"/>
		<br />
		
		Telefone: <br />
		<input type="text" name="phone" value="${contact.phone}" />
		<br />
		
		Data de Nascimento: <br /> 
		<input type="text" name="birthDate" value="<fmt:formatDate value="${contact.birthDate.time}" pattern="dd/MM/yyyy" />" />
		<br />
		
		<input type="submit" value="Alterar" />
	</form>
</body>
</html>