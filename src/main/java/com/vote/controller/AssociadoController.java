package com.vote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vote.entity.Associado;
import com.vote.service.AssociadoService;
import com.vote.service.CPFService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AssociadoController {
	
	@Autowired
	private AssociadoService service;
	
	@Autowired
	private CPFService CPFservice;
	
	@GetMapping("/associados")
	public List<Associado> all() {
		return this.service.all();
	}
	
	@RequestMapping(value="/novoAssociado", method=RequestMethod.POST, headers = "Content-type=application/*")
	public void salvar(@RequestBody Associado associado) {
		associado.setStatusCPF(CPFservice.buscaPorCPF(associado.getCpf()));
		this.service.save(associado);
	}

}
