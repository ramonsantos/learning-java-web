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
        <h1 style="text-align: center">Cadastrar Contatos</h1>
      </div>
    </div>

    <div class="row">
      <div class="col-lg-12 col-md-12">
        <form action="addContact" method="post" class="form-horizontal">
          <div class="form-group">
            <label for="inputName" class="col-sm-2 control-label">Nome</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="inputName" placeholder="Nome" name="name">
            </div>
          </div>

          <div class="form-group">
            <label for="inputEmail" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="inputEmail" placeholder="Email" name="email">
            </div>
          </div>

          <div class="form-group">
            <label for="inputTelefone" class="col-sm-2 control-label">Telefone</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="inputTelefone" placeholder="Telefone" name="phone">
            </div>
          </div>

          <div class="form-group">
            <label for="inputAniversario" class="col-sm-2 control-label">Aniversário</label>
            <div class="col-sm-10">
              <t:dateInput id="birthDate" cls="form-control"/>
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
