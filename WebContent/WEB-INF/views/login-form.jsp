<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <%@ include file="_head.jsp" %>

  <link href="resources/css/login.css" rel="stylesheet">

  <script type="text/javascript" src="resources/js/login.js"></script>
</head>
<body>
  <%@ include file="_header.jsp" %>

  <div class="container">
    <div class="row">
      <div class="col-md-6 col-md-offset-3">
        <div class="panel panel-login">
          <div class="panel-heading">
            <div class="row">
              <div class="col-xs-6">
                <a href="#" class="active" id="login-form-link">Login</a>
              </div>

              <div class="col-xs-6">
                <a href="#" id="register-form-link">Cadastro</a>
              </div>
            </div>
            <hr>
          </div>

          <div class="panel-body">
            <div class="row">
              <div class="col-lg-12">
                <form id="login-form" action="login" method="post" role="form" style="display: block;">
                  <div class="form-group">
                    <input type="text" name="email" id="email" tabindex="1" class="form-control" placeholder="Email" value="">
                  </div>

                  <div class="form-group">
                    <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Senha">
                  </div>

                  <div class="form-group">
                    <div class="row">
                      <div class="col-sm-6 col-sm-offset-3">
                        <input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-primary" value="Entrar">
                      </div>
                    </div>
                  </div>
                </form>

                <form id="register-form" action="newUser" method="post" role="form" style="display: none;">
                  <input type="hidden" name="id" value="${user.id}" />

                  <div class="form-group">
                    <input type="text" name="fullName" id="fullName" tabindex="1" class="form-control" placeholder="Nome Completo" value="${user.fullName}">
                  </div>

                  <div class="form-group">
                    <input type="email" name="email" id="email" tabindex="1" class="form-control" placeholder="Email" value="${user.email}">
                  </div>

                  <div class="form-group">
                    <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Senha" value="${user.password}">
                  </div>

                  <div class="form-group">
                    <div class="row">
                      <div class="col-sm-6 col-sm-offset-3">
                        <input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-primary" value="Cadastrar">
                      </div>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
