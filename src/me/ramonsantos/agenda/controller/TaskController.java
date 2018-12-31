package me.ramonsantos.agenda.controller;

import java.util.Calendar;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import me.ramonsantos.agenda.dao.ITaskDao;
import me.ramonsantos.agenda.model.Task;
import me.ramonsantos.agenda.model.User;

@Transactional
@Controller
public class TaskController {

	@Autowired
	private ITaskDao dao;

	@RequestMapping("newTask")
	public String form() {

		return "task/add";

	}

	@RequestMapping("addTask")
	public String add(@Valid Task task, BindingResult result, Model model) {

		if (result.hasFieldErrors()) {

			return "task/add";

		}

		task.setUserTask(getCurrentUser());
		dao.add(task);

		model.addAttribute("newTask", task);
		model.addAttribute("tasks", dao.listByUser(getCurrentUser()));

		return "task/list";

	}

	@RequestMapping("listTask")
	public String list(Model model) {

		model.addAttribute("tasks", dao.listByUser(getCurrentUser()));

		return "task/list";

	}

	@RequestMapping("removeTask")
	public String remove(Task task) {

		dao.remove(task);

		return "redirect:listTask";

	}

	@RequestMapping("showTask")
	public String show(Long id, Model model) {

		model.addAttribute("task", dao.findById(id));

		return "task/show";

	}

	@RequestMapping("updateTask")
	public String edit(Task task) {

		dao.update(task);

		return "redirect:listTask";

	}

	@RequestMapping("finalizeTask")
	public String finalize(Long id, Model model) {

		Task task = dao.findById(id);
		task.setFinishingDate(Calendar.getInstance());
		task.setFinalized(true);
		dao.update(task);

		model.addAttribute("task", dao.findById(id));

		return "task/_finalized";

	}

	private User getCurrentUser() {

		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession();

		return (User) session.getAttribute("userCurrent");

	}

}
