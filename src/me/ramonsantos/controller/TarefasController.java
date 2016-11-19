package me.ramonsantos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import me.ramonsantos.dao.JdbcTarefaDao;
import me.ramonsantos.model.Tarefa;

@Transactional
@Controller
public class TarefasController {

	@RequestMapping("novaTarefa")
	public String form() {

		return "tarefa/formulario";

	}

	@RequestMapping("adicionaTarefa")
	public String adiciona(Tarefa tarefa) {

		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.adiciona(tarefa);
		return "tarefa/adicionada";

	}

}