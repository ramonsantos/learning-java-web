<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="../_head.jsp" %>

  <script type="text/javascript">
    function finalizaAgora(id) {
      $.post("finalizeTask", {'id' : id}, function(resposta) {
        $("#task_"+id).html(resposta);
      });
    }
  </script>
</head>

<body>
  <%@ include file="../_header.jsp" %>

  <div class="container">
    <div class="row">
      <div class="col-lg-12 col-md-12">
        <h1 style="text-align: center">Tarefas</h1>
      </div>
    </div>

    <div class="row">
      <div class="col-lg-12 col-md-12">
        <table class="table table-bordered">
          <thead>
            <tr>
              <th>Id</th>
              <th>Descrição</th>
              <th>Status</th>
              <th>Data de Finalização</th>
              <th></th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${tasks}" var="task">
              <tr id="task_${task.id}">
                <td scope="row">${task.id}</td>
                <td>${task.description}</td>

                <c:if test="${task.finalized eq false}">
                  <td><a href="#" onClick="finalizaAgora(${task.id})">Finalizar!</a></td>
                </c:if>

                <c:if test="${task.finalized eq true}">
                  <td>Finalizada</td>
                </c:if>

                <td><fmt:formatDate value="${task.finishingDate.time}" pattern="dd/MM/yyyy" /></td>

                <td><a href="removeTask?id=${task.id}">Remover</a></td>
                <td><a href="showTask?id=${task.id}">Alterar</a></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>

    <div class="row">
      <div class="col-lg-12 col-md-12">
        <p><a href="newTask" class="btn btn-primary" role="button">Criar nova tarefa</a></p>
      </div>
    </div>
  </div>
</body>
</html>
