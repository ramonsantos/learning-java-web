<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<td>${task.id}</td>
<td>${task.title}</td>
<td>${task.description}</td>
<td>Finalizada</td>
<td><fmt:formatDate value="${task.finishingDate.time}"
		pattern="dd/MM/yyyy" /></td>
<td><a href="removeTask?id=${task.id}">Remover</a></td>
<td><a href="showTask?id=${task.id}">Alterar</a></td>
