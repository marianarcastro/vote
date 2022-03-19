package com.vote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.vote.entity.Votacao;
import com.vote.entity.Voto;
import com.vote.service.VotacaoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class VotacaoController {
	
	private final VotacaoService service;
	
	@Autowired
	private KafkaController kafkaController;
	
	
	VotacaoController(VotacaoService service) {
	    this.service = service;
	}

	@GetMapping("/votacoes")
	public List<Votacao> all() { 
		return this.service.findAll();
	}
	
	@RequestMapping(value="/novaVotacao", method=RequestMethod.POST, headers = "Content-type=application/*")
	public void novaVotacao() {
		this.service.abrirSessaoVotacao();
	}
	
	@RequestMapping(value="/mudarStatusVotacao", method=RequestMethod.POST, headers = "Content-type=application/*")
	public void mudarStatusVotacao() {
		this.service.mudarStatusVotacao();
		this.kafkaController.send();
	}
	
	@RequestMapping(value="/votar", method=RequestMethod.POST, headers = "Content-type=application/*")
	public void votar(@RequestBody Voto voto) throws JsonMappingException, JsonProcessingException {
		this.service.votar(voto);
	}
}
