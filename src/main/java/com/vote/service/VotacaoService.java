package com.vote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vote.entity.Pauta;
import com.vote.entity.Votacao;
import com.vote.repository.VotacaoRepository;

@Service
public class VotacaoService {
	
	@Autowired
	private VotacaoRepository repository;

	public List<Votacao> votoPorPauta(Pauta pauta) {
		return this.repository.findAll();
	}

	public void inserirVotoNaPauta(Pauta pauta) {
		//this.repository.save(pauta);
	}

}
