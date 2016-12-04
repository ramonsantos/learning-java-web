  <header>
    <nav class="navbar navbar-default navbar-inverse">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/listTask">Agenda - Learning Java Web</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav navbar-right">
            <li>
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                <span class="glyphicon glyphicon-list-alt"></span>
                Tarefas
                <span class="caret"></span>
              </a>
              <ul class="dropdown-menu">
                <li><a href="/newTask">Nova tarefa</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="listTask">Listar tarefas</a></li>
              </ul>
            </li>

            <li>
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                <span class="glyphicon glyphicon-user"></span>
                Contatos
                <span class="caret"></span>
              </a>
              <ul class="dropdown-menu">
                <li><a href="/newContact">Novo contato</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="listContact">Listar contatos</a></li>
              </ul>
            </li>
            
            <li>
              <a href="/logout">
                Sair
                <span class="glyphicon glyphicon-off"></span>
              </a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  </header>
