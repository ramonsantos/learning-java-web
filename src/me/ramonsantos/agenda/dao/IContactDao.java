package me.ramonsantos.agenda.dao;

import java.util.List;

import me.ramonsantos.agenda.model.Contact;
import me.ramonsantos.agenda.model.User;

public interface IContactDao {

	public abstract void add(Contact c);

	public abstract void update(Contact c);

	public abstract void remove(Contact c);

	public abstract Contact findById(Long id);

	public abstract List<Contact> list();

	public abstract List<Contact> listByUser(User user);

}
