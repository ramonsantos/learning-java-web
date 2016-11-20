package me.ramonsantos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.ramonsantos.jdbc.ConnectionFactory;
import me.ramonsantos.model.Usuario;

public class JdbcUsuarioDao {

	private Connection connection;

	public JdbcUsuarioDao() {

		this.connection = new ConnectionFactory().getConnection();

	}

	public JdbcUsuarioDao(Connection connection) {

		this.connection = connection;

	}

	public boolean existeUsuario(Usuario usuario) {

		List<Usuario> usuarios = this.lista();

		return usuarios.contains(usuario);

	}

	public List<Usuario> lista() {

		try {

			List<Usuario> usuarios = new ArrayList<Usuario>();

			PreparedStatement stmt = this.connection.prepareStatement("select * from usuarios");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Usuario usuario = new Usuario();
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));

				usuarios.add(usuario);

				System.out.println(usuario.getLogin() + ": " + usuario.getSenha());

			}

			rs.close();

			stmt.close();

			return usuarios;

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}

	}

}
