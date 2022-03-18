package com.vote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vote.service.CPFService;

@RestController
public class CPFController {
	    
	@Autowired
	private CPFService service;

	@GetMapping("/pesquisar/{cpfAssociado}")
	public String getCPF(@PathVariable String cpfAssociado) {
		return service.buscaPorCPF(cpfAssociado);
	}
}

