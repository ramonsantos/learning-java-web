<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jquery.js"></script>
</head>
<body>

	<a href="newContact">Criar nova contato</a>

	<br />
	<br />

	<table>
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Email</th>
			<th>Telefone</th>
			<th>Data de finalização</th>
		</tr>
		<c:forEach items="${contacts}" var="contact">
			<tr id="contact_${contact.id}">
				<td>${contact.id}</td>
				<td>${contact.name}</td>
				<td>${contact.email}</td>
				<td>${contact.phone}</td>
				
				<td><fmt:formatDate value="${contact.birthDate.time}"
						pattern="dd/MM/yyyy" /></td>

				
			</tr>
		</c:forEach>
	</table>
</body>
</html>