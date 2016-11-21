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

	<script type="text/javascript">
	  function finalizaAgora(id) {
	    $.post("finalizeTask", {'id' : id}, function(resposta) {
	      $("#task_"+id).html(resposta);
	    });
	  }
	</script>

	<a href="newTask">Criar nova tarefa</a>

	<br />
	<br />

	<table>
		<tr>
			<th>Id</th>
			<th>Descrição</th>
			<th>Finalizado?</th>
			<th>Data de finalização</th>
		</tr>
		<c:forEach items="${tasks}" var="task">
			<tr id="task_${task.id}">
				<td>${task.id}</td>
				<td>${task.description}</td>

				<c:if test="${task.finalized eq false}">
					<td><a href="#" onClick="finalizaAgora(${task.id})">Finalizar!</a>
					</td>
				</c:if>
				<c:if test="${task.finalized eq true}">
					<td>Finalizada</td>
				</c:if>
				<td><fmt:formatDate value="${task.finishingDate.time}"
						pattern="dd/MM/yyyy" /></td>

				<td><a href="removeTask?id=${task.id}">Remover</a></td>

				<td><a href="showTask?id=${task.id}">Alterar</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>