package me.ramonsantos.agenda.controller;

import java.util.Calendar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import me.ramonsantos.agenda.dao.ITaskDao;
import me.ramonsantos.agenda.model.Task;

@Transactional
@Controller
public class TaskController {

	@Autowired
	ITaskDao dao;

	@RequestMapping("novaTarefa")
	public String form() {

		return "tarefa/formulario";

	}

	@RequestMapping("addTask")
	public String add(@Valid Task task, BindingResult result) {

		if (result.hasFieldErrors("description")) {

			return "tarefa/formulario";

		}

		dao.add(task);
		return "tarefa/adicionada";

	}

	@RequestMapping("listaTarefas")
	public String list(Model model) {

		model.addAttribute("tasks", dao.list());

		return "tarefa/lista";

	}

	@RequestMapping("removeTarefa")
	public String remove(Task task) {

		dao.remove(task);

		return "redirect:listaTarefas";

	}

	@RequestMapping("mostraTarefa")
	public String show(Long id, Model model) {

		model.addAttribute("tarefa", dao.findById(id));

		return "tarefa/mostra";

	}

	@RequestMapping("alteraTarefa")
	public String edit(Task task) {

		dao.update(task);

		return "redirect:listaTarefas";

	}

	@RequestMapping("finalizaTarefa")
	public String finalize(Long id, Model model) {

		Task task = dao.findById(id);
		task.setFinishingDate(Calendar.getInstance());
		task.setFinalized(true);
		dao.update(task);

		model.addAttribute("tarefa", dao.findById(id));

		return "tarefa/finalizada";

	}

}