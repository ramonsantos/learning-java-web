package me.ramonsantos.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import me.ramonsantos.dao.JdbcUsuarioDao;
import me.ramonsantos.model.Usuario;

@Controller
public class LoginController {

	@RequestMapping("loginForm")
	public String loginForm() {

		return "formulario-login";

	}

	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) {

		if (new JdbcUsuarioDao().existeUsuario(usuario)) {

			session.setAttribute("usuarioLogado", usuario);

			return "menu";

		}

		return "redirect:loginForm";

	}

}