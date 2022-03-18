package com.vote.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vote.entity.Pauta;
import com.vote.exception.PautaNotFoundException;
import com.vote.service.PautaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PautaController {
	
	private final PautaService service;
	
	PautaController(PautaService service) {
	    this.service = service;
	}

	@GetMapping("/pautas")
	public List<Pauta> all() {
		return service.findAll();
	}

	@RequestMapping(value="/novaPauta", method=RequestMethod.POST, headers = "Content-type=application/*")
	public ResponseEntity<Pauta> novaPauta(@RequestBody Pauta novaPauta) {
		service.criarPauta(novaPauta);
		return new ResponseEntity<Pauta>(novaPauta, HttpStatus.OK);
	}

	@GetMapping("/pauta/{id}")
	public Pauta pautaPorId(@PathVariable Long id) {
		return service.pautaPorId(id).orElseThrow(() -> new PautaNotFoundException(id));
	}

}
