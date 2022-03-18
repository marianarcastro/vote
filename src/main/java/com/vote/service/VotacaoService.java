package com.vote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vote.entity.Associado;
import com.vote.entity.Votacao;
import com.vote.repository.VotacaoRepository;

@Service
public class VotacaoService {
	
	@Autowired
	private VotacaoRepository repository;
	
	public List<Votacao> findAll() {
		return this.repository.findAll();
	}

	public void abrirSessaoVotacao(Votacao votacao) {
		this.repository.save(votacao);
	}
	
	public void votar(Votacao votacao, Associado associado) {
		
	}

}
