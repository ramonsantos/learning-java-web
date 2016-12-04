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
        <h1 style="text-align: center">Cadastrar Contato</h1>
      </div>
    </div>

    <div class="row">
      <div class="col-lg-12 col-md-12">
        <form action="addContact" method="post" class="form-horizontal">

          <%@ include file="_form.jsp" %>

        </form>
      </div>
    </div>
  </div>
</body>
</html>
