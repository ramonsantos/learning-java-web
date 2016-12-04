<input type="hidden" name="id" value="${contact.id}" />

<div class="form-group">
  <label for="inputName" class="col-sm-2 control-label">Nome</label>
  <div class="col-sm-10">
    <input type="text" class="form-control" id="inputName" placeholder="Nome" name="name" value="${contact.name}">
  </div>
</div>

<div class="form-group">
  <label for="inputEmail" class="col-sm-2 control-label">Email</label>
  <div class="col-sm-10">
    <input type="text" class="form-control" id="inputEmail" placeholder="Email" name="email" value="${contact.email}">
  </div>
</div>

<div class="form-group">
  <label for="inputTelefone" class="col-sm-2 control-label">Telefone</label>
  <div class="col-sm-10">
    <input type="text" class="form-control" id="inputTelefone" placeholder="Telefone" name="phone" value="${contact.phone}">
  </div>
</div>

<div class="form-group">
  <label for="inputAniversario" class="col-sm-2 control-label">Aniversário</label>
  <div class="col-sm-10">
    <t:dateInput id="birthDate" cls="form-control" valDate="${contact.birthDate.time}" placeH="Data de Nascimento"/>
  </div>
</div>

<div class="form-group">
  <div class="col-sm-offset-2 col-sm-10">
    <button type="submit" class="btn btn-primary">Salvar</button>
    <button type="reset" class="btn btn-success">Limpar</button>
    <button type="button"   class="btn btn-danger" onclick="location.href='listContact'">Cancelar</button>
  </div>
</div>
