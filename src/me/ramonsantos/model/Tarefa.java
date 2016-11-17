package me.ramonsantos.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Tarefa {

	@Id
	@GeneratedValue
	private Long id;

	private String descricao;
	private boolean finalizado;

	@Temporal(TemporalType.DATE)
	private Calendar dataFinalizacao;

	public Tarefa() {

	}

	public String getDescricao() {

		return descricao;

	}

	public void setDescricao(String descricao) {

		this.descricao = descricao;

	}

	public boolean isFinalizado() {

		return finalizado;

	}

	public void setFinalizado(boolean finalizado) {

		this.finalizado = finalizado;

	}

	public Calendar getDataFinalizacao() {

		return dataFinalizacao;

	}

	public void setDataFinalizacao(Calendar dataFinalizacao) {

		this.dataFinalizacao = dataFinalizacao;

	}

	public Long getId() {

		return id;

	}

}