package me.ramonsantos.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {

	public abstract String executa(HttpServletRequest req, HttpServletResponse res) throws Exception;

}
