<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <%@ include file="../_head.jsp" %>
</head>
<body>
  <%@ include file="../_header.jsp" %>

  <div class="container">
    <div class="row">
      <div class="col-lg-12 col-md-12">
        <h1 style="text-align: center">Cadastrar Tarefa</h1>
      </div>
    </div>

    <div class="row">
      <div class="col-lg-12 col-md-12">
        <form action="addTask" method="post" class="form-horizontal">
          <input type="hidden" name="id" value="${task.id}" />

          <div class="form-group">
            <label for="inputTitle" class="col-sm-2 control-label">Título</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="inputTitle" placeholder="Título" name="title" value="${task.title}">
            </div>
          </div>

          <div class="form-group">
            <label for="inputFinishingDate" class="col-sm-2 control-label">Aniversário</label>
            <div class="col-sm-10">
              <t:dateInput id="inputFinishingDate" cls="form-control" valDate="${task.finishingDate}" placeH="Data de Finalização"/>
            </div>
          </div>

          <div class="form-group">
            <label for="inputDescription" class="col-sm-2 control-label">Descrição</label>
            <div class="col-sm-10">
              <textarea  class="form-control" id="inputDescription" rows="7" placeholder="Descrição" name="description" value="${task.description}"></textarea>
            </div>
          </div>

          <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
              <button type="submit" class="btn btn-primary">Salvar</button>
              <button type="reset" class="btn btn-success">Limpar</button>
              <button type="button"   class="btn btn-danger" onclick="location.href='listContact'">Cancelar</button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</body>
</html>
