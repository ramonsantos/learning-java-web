package me.ramonsantos.agenda.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import me.ramonsantos.agenda.dao.IContactDao;
import me.ramonsantos.agenda.model.Contact;

@Transactional
@Controller
public class ContactController {

	@Autowired
	IContactDao dao;

	@RequestMapping("newContact")
	public String form() {

		return "contact/form";

	}

	@RequestMapping("addContact")
	public String add(@Valid Contact contact, BindingResult result, Model model) {

		if (result.hasFieldErrors("description")) {

			return "contact/form";

		}

		dao.add(contact);

		model.addAttribute("contact", dao.findById(contact.getId()));

		return "contact/added";

	}
	
	@RequestMapping("listContact")
	public String list(Model model) {

		model.addAttribute("contacts", dao.list());

		return "contact/list";

	}

}
