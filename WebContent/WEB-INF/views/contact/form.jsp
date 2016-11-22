<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>

	<link href="resources/css/jquery-ui.css" rel="stylesheet">
  
    <script type="text/javascript" src="resources/js/jquery-ui.js"></script>
    <script type="text/javascript" src="resources/js/jquery.js"></script>
</head>
<body>
<h3>Adicionar contatos</h3>
	<form action="addContact" method="post">
		Nome: <input type="text" name="name"/>
		<br />
		Email: <input type="text" name="email"/>
		<br />
		Endereço: <input type="text" name="address"/>
		<br />
		Telefone: <input type="text" name="phone"/>
		<br /> 
		Data da Nascimento: <caelum:campoData id="birthDate" />
		<br />
		
		<input type="submit" value="Adicionar">
	</form>
</body>
</html>