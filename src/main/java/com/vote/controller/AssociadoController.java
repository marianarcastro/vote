package com.vote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vote.entity.Associado;
import com.vote.service.AssociadoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AssociadoController {
	
	@Autowired
	private AssociadoService service;
	
	@GetMapping("/associados")
	public List<Associado> all() {
		return this.service.all();
	}
	
	@RequestMapping(value="/novoAssociado", method=RequestMethod.POST, headers = "Content-type=application/*")
	public void salvar(@RequestBody Associado associado) {
		this.service.save(associado);
	}

}
