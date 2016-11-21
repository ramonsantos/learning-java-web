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

	public void add(Task task) {

		manager.persist(task);

	}

	public void update(Task task) {

		manager.merge(task);

	}

	@SuppressWarnings("unchecked")
	public List<Task> list() {

		return manager.createQuery("select t from Task t").getResultList();

	}

	public Task findById(Long id) {

		return manager.find(Task.class, id);

	}

	public void remove(Task task) {

		Task taskR = findById(task.getId());

		manager.remove(taskR);

	}

}