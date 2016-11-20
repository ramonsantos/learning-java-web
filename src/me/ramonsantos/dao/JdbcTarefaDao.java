package me.ramonsantos.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.ramonsantos.model.Tarefa;

@Repository
public class JdbcTarefaDao {

	private Connection connection;

	@Autowired
	public JdbcTarefaDao(DataSource dataSource) {

		try {

			this.connection = dataSource.getConnection();

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}

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

	public void altera(Tarefa tarefa) {

		String sql = "update tarefas set descricao=?, finalizado=?, dataFinalizacao=? where id=?";

		try {

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, tarefa.isFinalizado());
			stmt.setDate(3, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
			stmt.setLong(4, tarefa.getId());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}

	}

	public void remove(Tarefa tarefa) {

		try {

			PreparedStatement stmt = connection.prepareStatement("delete from tarefas where id=?");
			stmt.setLong(1, tarefa.getId());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}

	}

	public Tarefa buscaPorId(Long id) {

		List<Tarefa> lista = this.lista();
		for (int i = 0; i < lista.size(); i++) {

			if (id.equals(lista.get(i).getId())) {

				return lista.get(i);

			}
		}

		return null;

	}

	public void finaliza(Long id) {

		Tarefa tarefa = buscaPorId(id);
		tarefa.setFinalizado(true);

		this.altera(tarefa);

	}

}
