package me.ramonsantos.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.ramonsantos.dao.ContatoDao;
import me.ramonsantos.modelo.Contato;

public class RemoveContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		long id = Long.parseLong(req.getParameter("id"));

		Contato contato = new Contato();
		contato.setId(id);

		ContatoDao dao = new ContatoDao();
		dao.remove(contato);

		System.out.println("Excluindo contato... ");

		return "lista-contatos.jsp";
		
	}
	
}
