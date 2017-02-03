package me.ramonsantos.agenda.dao;

import java.util.List;

import me.ramonsantos.agenda.model.Task;
import me.ramonsantos.agenda.model.User;

public interface ITaskDao {

	public abstract Task findById(Long id);

	public abstract List<Task> list();

	public abstract void add(Task t);

	public abstract void update(Task t);

	public abstract void remove(Task t);

	public abstract List<Task> listByUser(User user);

}
