package me.ramonsantos.agenda.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "contacts")
@Entity
public class Contact {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Size(min = 5)
	private String name;

	@Email
	private String email;

	@Size(max = 20)
	private String phone;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar birthDate;

	public Contact() {

	}

	public Long getId() {

		return id;

	}

	public void setId(Long id) {

		this.id = id;

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public String getEmail() {

		return email;

	}

	public void setEmail(String email) {

		this.email = email;

	}

	public Calendar getBirthDate() {

		return birthDate;

	}

	public void setBirthDate(Calendar birthDate) {

		this.birthDate = birthDate;

	}

	public String getPhone() {

		return phone;

	}

	public void setPhone(String phone) {

		this.phone = phone;

	}

}
