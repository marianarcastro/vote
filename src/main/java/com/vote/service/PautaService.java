package com.vote.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vote.entity.Pauta;
import com.vote.repository.PautaRepository;

@Service
public class PautaService {

	@Autowired
	private PautaRepository repository;
	
	public List<Pauta> findAll() {
		return this.repository.findAll();
	}
	
	public void criarPauta(Pauta pauta) {
		this.repository.save(pauta);
	}
	
	public Optional<Pauta> pautaPorId(Long id) {
		return this.repository.findById(id);
	}
}
