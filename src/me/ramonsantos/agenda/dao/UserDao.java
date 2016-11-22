package me.ramonsantos.agenda.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import me.ramonsantos.agenda.model.User;

@Repository
public class UserDao implements IUserDao {

	@PersistenceContext
	EntityManager manager;

	@Override
	public void add(User user) {

		this.manager.persist(user);

	}

	@Override
	public void update(User user) {

		this.update(user);

	}

	@Override
	public User findById(Long id) {

		return this.manager.find(User.class, id);

	}

	@Override
	public boolean isUserValid(User user) {

		return this.list().contains(user);

	}

	@SuppressWarnings("unchecked")
	private List<User> list() {

		return this.manager.createQuery("select u from User u").getResultList();

	}

}
