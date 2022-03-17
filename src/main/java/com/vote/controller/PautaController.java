package com.vote.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vote.entity.Pauta;
import com.vote.exception.PautaNotFoundException;
import com.vote.service.PautaService;

@RestController
public class PautaController {
	
	private final PautaService service;
	
	PautaController(PautaService service) {
	    this.service = service;
	}

	@GetMapping("/pautas")
	public List<Pauta> all() {
		return service.findAll();
	}

	@PostMapping("/novaPauta")
	public void novaPauta(@RequestBody Pauta novaPauta) {
		service.criarPauta(novaPauta);
	}


	@GetMapping("/pauta/{id}")
	public Pauta pautaPorId(@PathVariable Long id) {
		return service.pautaPorId(id).orElseThrow(() -> new PautaNotFoundException(id));
	}

}
