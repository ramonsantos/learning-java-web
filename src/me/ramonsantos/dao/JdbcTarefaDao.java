package me.ramonsantos.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import me.ramonsantos.jdbc.ConnectionFactory;
import me.ramonsantos.model.Tarefa;

public class JdbcTarefaDao {

	private Connection connection;

	public JdbcTarefaDao() {

		this.connection = new ConnectionFactory().getConnection();

	}

	public JdbcTarefaDao(Connection connection) {

		this.connection = connection;

	}

	public void adiciona(Tarefa tarefa) {

		String sql = "insert into tarefas " + "(descricao,dataFinalizacao, finalizado)" + " values (?,?,?)";

		try {

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getDescricao());
			stmt.setDate(2, new Date(Calendar.getInstance().getTimeInMillis()));
			stmt.setBoolean(3, false);

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}

	}

}
