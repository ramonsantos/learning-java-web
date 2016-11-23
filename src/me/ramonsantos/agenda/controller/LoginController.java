package me.ramonsantos.agenda.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

			return "menu";

		}

		return "redirect:loginForm";

	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {

		session.invalidate();

		return "redirect:loginForm";

	}

}