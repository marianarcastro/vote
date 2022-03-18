package com.vote.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vote.entity.Associado;
import com.vote.entity.Pauta;
import com.vote.entity.Votacao;
import com.vote.service.VotacaoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class VotacaoController {
	
	private final VotacaoService service;
	
	
	VotacaoController(VotacaoService service) {
	    this.service = service;
	}

	@GetMapping("/votacoes")
	public List<Votacao> all() { 
		return this.service.findAll();
	}
	
	@RequestMapping(value="/novaVotacao", method=RequestMethod.POST, headers = "Content-type=application/*")
	public void novaVotacao(@RequestBody Pauta pauta) {
		this.service.abrirSessaoVotacao(pauta);
	}
	
	@PostMapping("/votar")
	public void votar(Associado associado) {
		this.service.votar(associado);
	}
}
