<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="../_head.jsp" %>
</head>

<body>
  <%@ include file="../_header.jsp" %>

  <div class="container">
    <div class="row">
      <div class="col-lg-12 col-md-12">
        <h1 style="text-align: center">Contatos</h1>
      </div>
    </div>

    <div class="row">
      <div class="col-lg-12 col-md-12">
        <table class="table table-bordered table-hover">
          <thead>
            <tr>
              <th>Id</th>
              <th>Nome</th>
              <th>Email</th>
              <th>Telefone</th>
              <th>Aniversário</th>
              <th></th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${contacts}" var="contact">
              <tr id="task_${contact.id}">
                <td scope="row">${contact.id}</td>
                <td>${contact.name}</td>
                <td>${contact.email}</td>
                <td>${contact.phone}</td>

                <td><fmt:formatDate value="${contact.birthDate.time}" pattern="dd/MM/yyyy" /></td>

                <td><a href="removeContact?id=${contact.id}">Remover</a></td>
                <td><a href="showContact?id=${contact.id}">Alterar</a></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>

    <div class="row">
      <div class="col-lg-12 col-md-12">
        <p><a href="newContact" class="btn btn-primary" role="button">Criar novo contato</a></p>
      </div>
    </div>
  </div>
</body>
</html>
