package me.ramonsantos.agenda.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import me.ramonsantos.agenda.dao.IUserDao;
import me.ramonsantos.agenda.model.User;

@Controller
public class LoginController {

	@Autowired
	IUserDao dao;

	@RequestMapping("loginForm")
	public String loginForm() {

		return "login-form";

	}

	@RequestMapping("login")
	public String efetuaLogin(User user, HttpSession session) {

		user = dao.isUserValid(user);

		if (user != null) {

			session.setAttribute("userCurrent", user);

			return "redirect:listTask";

		}

		return "redirect:loginForm";

	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {

		session.invalidate();

		return "redirect:loginForm";

	}

	@Transactional
	@RequestMapping("newUser")
	public String newUser(@Valid User user, BindingResult result, Model model) {

		if (result.hasFieldErrors()) {

			return "login-form";

		}

		dao.add(user);
		model.addAttribute("newUserModel", user);

		return "login-form";

	}

}