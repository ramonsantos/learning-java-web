
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<td>${tarefa.id}</td>
<td>${tarefa.description}</td>
<td>Finalizada</td>
<td><fmt:formatDate value="${tarefa.finishingDate.time}"
		pattern="dd/MM/yyyy" /></td>
<td><a href="removeTarefa?id=${tarefa.id}">Remover</a></td>
<td><a href="mostraTarefa?id=${tarefa.id}">Alterar</a></td>
