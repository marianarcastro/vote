package com.vote.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Votacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@OneToMany
	private List<Associado> associados;
	@ManyToOne
	private Pauta pauta;
	private Long quantidadeVotos;
	private String status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Associado> getAssociados() {
		return associados;
	}
	public void setAssociados(List<Associado> associados) {
		this.associados = associados;
	}
	public Pauta getPauta() {
		return pauta;
	}
	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}
	public Long getQuantidadeVotos() {
		return quantidadeVotos;
	}
	public void setQuantidadeVotos(Long quantidadeVotos) {
		this.quantidadeVotos = quantidadeVotos;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
