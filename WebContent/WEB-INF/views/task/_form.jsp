<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<input type="hidden" name="id" value="${task.id}" />

<div class="form-group">
  <label for="inputTitle" class="col-sm-2 control-label">Título</label>
  <div class="col-sm-10">
    <input type="text" class="form-control" id="inputTitle" placeholder="Título" name="title" value="${task.title}">
  </div>
</div>

<div class="form-group">
  <label for="finishingDate" class="col-sm-2 control-label">Data de Finalização</label>
  <div class="col-sm-10">
    <t:dateInput id="finishingDate" cls="form-control" valDate="${task.finishingDate.time}" placeH="Data de Finalização"/>
  </div>
</div>

<div class="form-group">
  <label for="inputDescription" class="col-sm-2 control-label">Descrição</label>
  <div class="col-sm-10">
    <textarea  class="form-control" id="inputDescription" rows="7" placeholder="Descrição" name="description">${task.description}</textarea>
  </div>
</div>

<div class="form-group">
  <div class="col-sm-offset-2 col-sm-10">
    <button type="submit" class="btn btn-primary">Salvar</button>
    <button type="reset" class="btn btn-success">Limpar</button>
    <button type="button"   class="btn btn-danger" onclick="location.href='listContact'">Cancelar</button>
  </div>
</div>
