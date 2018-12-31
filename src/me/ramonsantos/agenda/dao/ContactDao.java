package me.ramonsantos.agenda.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import me.ramonsantos.agenda.model.Contact;
import me.ramonsantos.agenda.model.User;

@Repository
public class ContactDao implements IContactDao {

	@PersistenceContext
	private EntityManager manager;

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

	@Override
	@SuppressWarnings("unchecked")
	public List<Contact> listByUser(User user) {

		Session session = manager.unwrap(Session.class);

		Criteria cri = session.createCriteria(Contact.class);

		return cri.add(Restrictions.eq("userContact", user)).list();

	}

}
