package me.ramonsantos.agenda.controller;

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

import me.ramonsantos.agenda.dao.IContactDao;
import me.ramonsantos.agenda.model.Contact;
import me.ramonsantos.agenda.model.User;

@Transactional
@Controller
public class ContactController {

	@Autowired
	IContactDao dao;

	@RequestMapping("newContact")
	public String form() {

		return "contact/add";

	}

	@RequestMapping("addContact")
	public String add(@Valid Contact contact, BindingResult result, Model model) {

		if (result.hasFieldErrors()) {

			return "contact/add";

		}

		contact.setUserContact(getCurrentUser());
		dao.add(contact);

		model.addAttribute("newContact", contact);
		model.addAttribute("contacts", dao.listByUser(getCurrentUser()));

		return "contact/list";

	}

	@RequestMapping("listContact")
	public String list(Model model) {

		model.addAttribute("contacts", dao.listByUser(getCurrentUser()));

		return "contact/list";

	}

	@RequestMapping("removeContact")
	public String remove(Contact contact) {

		dao.remove(contact);

		return "redirect:listContact";

	}

	@RequestMapping("showContact")
	public String show(Long id, Model model) {

		model.addAttribute("contact", dao.findById(id));

		return "contact/show";

	}

	@RequestMapping("updateContact")
	public String edit(Contact contact) {

		dao.update(contact);

		return "redirect:listContact";

	}

	private User getCurrentUser() {

		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession();

		return (User) session.getAttribute("userCurrent");

	}

}
