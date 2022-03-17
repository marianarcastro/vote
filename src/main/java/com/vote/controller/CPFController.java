package com.vote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vote.entity.CPF;
import com.vote.service.CPFService;

@RestController
public class CPFController {
	    
	@Autowired
	private CPFService service;

	@GetMapping("/pesquisar/{cpfAssociado}")
	public ResponseEntity<CPF> getCep(@PathVariable String cpfAssociado) {
		CPF cpf = service.buscaPorCPF(cpfAssociado);
	    return cpf != null ? ResponseEntity.ok().body(cpf) : ResponseEntity.notFound().build(); 
	}
}

