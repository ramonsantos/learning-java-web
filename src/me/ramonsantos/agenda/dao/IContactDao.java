package me.ramonsantos.agenda.dao;

import java.util.List;

import me.ramonsantos.agenda.model.Contact;

public interface IContactDao {

	public abstract void add(Contact c);

	public abstract void update(Contact c);

	public abstract void remove(Contact c);

	public abstract Contact findById(Long id);

	public abstract List<Contact> list();

}
