
package me.ramonsantos.agenda.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Table(name = "users")
@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Size(min = 5)
	private String fullName;

	@Email
	@NotNull
	private String email;

	@NotNull
	@Size(min = 6)
	private String password;

	@OneToMany(mappedBy = "userTask")
	private List<Task> listTask;

	@OneToMany(mappedBy = "userContact")
	private List<Contact> listContact;

	public String getFullName() {

		return fullName;

	}

	public void setFullName(String fullName) {

		this.fullName = fullName;

	}

	public String getEmail() {

		return email;

	}

	public void setEmail(String email) {

		this.email = email;

	}

	public String getPassword() {

		return password;

	}

	public void setPassword(String password) {

		this.password = password;

	}

	public Long getId() {

		return id;

	}

	public void setId(Long id) {

		this.id = id;

	}

	public List<Task> getListTask() {

		return listTask;

	}

	public void setListTask(List<Task> listTask) {

		this.listTask = listTask;

	}

	public List<Contact> getListContact() {

		return listContact;

	}

	public void setListContact(List<Contact> listContact) {

		this.listContact = listContact;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

}
