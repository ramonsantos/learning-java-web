<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<input type="hidden" name="id" value="${contact.id}" />

<div class="form-group">
  <label for="inputName" class="col-sm-2 control-label">Nome</label>
  <div class="col-sm-10">
    <input type="text" class="form-control" id="inputName" placeholder="Nome" name="name" value="${contact.name}">
    <form:errors path="contact.name" style="color: red"/>
  </div>
</div>

<div class="form-group">
  <label for="inputEmail" class="col-sm-2 control-label">Email</label>
  <div class="col-sm-10">
    <input type="text" class="form-control" id="inputEmail" placeholder="Email" name="email" value="${contact.email}">
    <form:errors path="contact.email" style="color: red"/>
  </div>
</div>

<div class="form-group">
  <label for="inputTelefone" class="col-sm-2 control-label">Telefone</label>
  <div class="col-sm-10">
    <input type="text" class="form-control" id="inputTelefone" placeholder="Telefone" name="phone" value="${contact.phone}">
    <form:errors path="contact.phone" style="color: red"/>
  </div>
</div>

<div class="form-group">
  <label for="birthDate" class="col-sm-2 control-label">Aniversário</label>
  <div class="col-sm-10">
    <t:dateInput id="birthDate" cls="form-control" valDate="${contact.birthDate.time}" placeH="Data de Nascimento"/>
    <form:errors path="contact.birthDate" style="color: red"/>
  </div>
</div>

<div class="form-group">
  <div class="col-sm-offset-2 col-sm-10">
    <button type="submit" class="btn btn-primary">Salvar</button>
    <button type="reset" class="btn btn-success">Limpar</button>
    <button type="button"   class="btn btn-danger" onclick="location.href='listContact'">Cancelar</button>
  </div>
</div>
