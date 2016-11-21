package me.ramonsantos.agenda.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import me.ramonsantos.agenda.model.Contact;

@Repository
public class ContactDao implements IContactDao {

	@PersistenceContext
	EntityManager manager;

	@Override
	public void add(Contact c) {

		this.manager.persist(c);

	}

	@Override
	public void update(Contact c) {

		this.manager.merge(c);

	}

	@Override
	public void remove(Contact c) {

		Contact contactR = this.findById(c.getId());

		this.manager.remove(contactR);

	}

	@Override
	public Contact findById(Long id) {

		return this.manager.find(Contact.class, id);

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Contact> list() {

		return this.manager.createQuery("select c from Contact c").getResultList();

	}

}
