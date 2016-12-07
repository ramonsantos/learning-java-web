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

import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "tasks")
@Entity
public class Task {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Size(min = 5)
	private String title;

	@NotNull
	@Size(min = 5)
	private String description;

	private boolean finalized;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar finishingDate;

	public Task() {

		this.finalized = false;

	}

	public String getTitle() {

		return title;

	}

	public void setTitle(String title) {

		this.title = title;

	}

	public String getDescription() {

		return description;

	}

	public void setDescription(String description) {

		this.description = description;

	}

	public boolean isFinalized() {

		return finalized;

	}

	public void setFinalized(boolean finalized) {

		this.finalized = finalized;

	}

	public Calendar getFinishingDate() {

		return finishingDate;

	}

	public void setFinishingDate(Calendar finishingDate) {

		this.finishingDate = finishingDate;

	}

	public Long getId() {

		return id;

	}

	public void setId(Long id) {

		this.id = id;

	}

}
