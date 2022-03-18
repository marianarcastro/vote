package com.vote.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vote.controller.CPFController;
import com.vote.entity.Associado;
import com.vote.entity.Pauta;
import com.vote.entity.Votacao;
import com.vote.entity.Voto;
import com.vote.repository.AssociadoRepository;
import com.vote.repository.VotacaoRepository;

@Service
public class VotacaoService {
	
	@Autowired
	private VotacaoRepository repository;
	@Autowired
	private CPFController cpfController;
	
	@Autowired
	private AssociadoRepository associadoRepository;
	
	public List<Votacao> findAll() {
		return this.repository.findAll();
	}

	public void abrirSessaoVotacao(Pauta pauta) {
		Votacao votacao = new Votacao();
		votacao.setQuantidadeVotos(0L);
		votacao.setStatus("ATIVA");
		this.repository.save(votacao);
	}
	
	public void votar(Voto voto) throws JsonMappingException, JsonProcessingException {
		Long qtdVotos = this.repository.qtdVotos(voto.getVotacaoID());
		Associado a = this.associadoRepository.getOne(voto.getAssociadoID());
		a.setStatusCPF(cpfController.getCPF(a.getCpf()));
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = mapper.readValue(a.getStatusCPF(), Map.class);
		
		if("ABLE_TO_VOTE".equals(map.get("status"))) {
			this.repository.votar(voto.getAssociadoID(), voto.getPautaID(), qtdVotos + 1, voto.getVotacaoID());
		}
	}

}
