package com.vote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vote.controller.CPFController;
import com.vote.entity.Associado;
import com.vote.entity.Pauta;
import com.vote.entity.Votacao;
import com.vote.repository.VotacaoRepository;

@Service
public class VotacaoService {
	
	@Autowired
	private VotacaoRepository repository;
	@Autowired
	private CPFController cpfController;
	
	public List<Votacao> findAll() {
		return this.repository.findAll();
	}

	public void abrirSessaoVotacao(Pauta pauta) {
		Votacao votacao = new Votacao();
		votacao.setQuantidadeVotos(0L);
		votacao.setStatus("ATIVA");
		this.repository.save(votacao);
	}
	
	public void votar(Associado associado) {
		associado.setStatusCPF(cpfController.getCPF(associado.getCpf()));
		if(associado.getStatusCPF() == "ABLE_TO_VOTE") {
			//this.repository
		}
	}

}
