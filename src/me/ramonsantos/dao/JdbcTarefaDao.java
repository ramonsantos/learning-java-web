package me.ramonsantos.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

	public List<Tarefa> lista() {

		try {

			List<Tarefa> tarefas = new ArrayList<Tarefa>();

			PreparedStatement stmt = this.connection.prepareStatement("select * from tarefas");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Tarefa tarefa = new Tarefa();
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizado"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataFinalizacao"));
				tarefa.setDataFinalizacao(data);

				tarefas.add(tarefa);

			}

			rs.close();

			stmt.close();

			return tarefas;

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}

	}

}
