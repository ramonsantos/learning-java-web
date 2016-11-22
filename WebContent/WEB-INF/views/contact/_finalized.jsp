<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<td>${contact.id}</td>
<td>${contact.name}</td>
<td>${contact.email}</td>
<td>${contact.phone}</td>

<td><fmt:formatDate value="${contact.birthDate.time}" pattern="dd/MM/yyyy" /></td>

<td><a href="removeContact?id=${contact.id}">Remover</a></td>

<td><a href="showContact?id=${contact.id}">Alterar</a></td>
