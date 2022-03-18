package com.vote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vote.entity.Associado;
import com.vote.service.AssociadoService;

@RestController
public class AssociadoController {
	
	@Autowired
	private AssociadoService service;
	
	@GetMapping("/associados")
	public List<Associado> all() {
		return this.service.all();
	}

}
