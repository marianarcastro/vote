package com.vote.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vote.entity.Associado;
import com.vote.entity.Votacao;
import com.vote.service.VotacaoService;

@RestController
public class VotacaoController {
	
	private final VotacaoService service;
	private final CPFController cpfController;
	
	VotacaoController(VotacaoService service, CPFController cpfController) {
	    this.service = service;
		this.cpfController = cpfController;
	}

	@GetMapping("/votacao")
	public List<Votacao> all() { 
		return this.service.findAll();
	}
	
	@PostMapping("/novaVotacao")
	public void novaVotacao(Votacao votacao) {
		this.service.abrirSessaoVotacao(votacao);
	}
	
	@PostMapping("/votar")
	public void votar(Votacao votacao, Associado associado) {
		associado.setStatusCPF(cpfController.getCPF(associado.getCpf()));
		if(associado.getStatusCPF() == "ABLE_TO_VOTE") {
			this.service.votar(votacao, associado);
		}
	}
}
