package me.ramonsantos.agenda.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import me.ramonsantos.agenda.model.Task;
import me.ramonsantos.agenda.model.User;

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

	@Override
	@SuppressWarnings("unchecked")
	public List<Task> listByUser(User user) {

		Session session = manager.unwrap(Session.class);

		Criteria cri = session.createCriteria(Task.class);

		return cri.add(Restrictions.eq("userTask", user)).list();

	}

}