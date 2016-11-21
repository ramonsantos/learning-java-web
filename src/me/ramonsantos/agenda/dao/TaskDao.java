package me.ramonsantos.agenda.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import me.ramonsantos.agenda.model.Task;

@Repository
public class TaskDao implements ITaskDao {

	@PersistenceContext
	EntityManager manager;

	@Override
	public void add(Task task) {

		this.manager.persist(task);

	}

	@Override
	public void update(Task task) {

		this.manager.merge(task);

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Task> list() {

		return this.manager.createQuery("select t from Task t").getResultList();

	}

	@Override
	public Task findById(Long id) {

		return this.manager.find(Task.class, id);

	}

	@Override
	public void remove(Task task) {

		Task taskR = this.findById(task.getId());

		this.manager.remove(taskR);

	}

}