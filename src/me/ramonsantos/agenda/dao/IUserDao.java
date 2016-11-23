package me.ramonsantos.agenda.dao;

import me.ramonsantos.agenda.model.User;

public interface IUserDao {

	public abstract void add(User user);

	public abstract void update(User user);

	public abstract User findById(Long id);

	public abstract User isUserValid(User user);

}
