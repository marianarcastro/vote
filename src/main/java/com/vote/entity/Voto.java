package com.vote.entity;

public class Voto {
	
	private Long associadoID;
	private Long pautaID;
	private Long votacaoID;
	private String voto;
	
	public Long getAssociadoID() {
		return associadoID;
	}
	public void setAssociadoID(Long associadoID) {
		this.associadoID = associadoID;
	}
	public Long getPautaID() {
		return pautaID;
	}
	public void setPautaID(Long pautaID) {
		this.pautaID = pautaID;
	}
	public Long getVotacaoID() {
		return votacaoID;
	}
	public void setVotacaoID(Long votacaoID) {
		this.votacaoID = votacaoID;
	}
	public String getVoto() {
		return voto;
	}
	public void setVoto(String voto) {
		this.voto = voto;
	}
}
