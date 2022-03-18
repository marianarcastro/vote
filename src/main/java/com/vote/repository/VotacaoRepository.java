package com.vote.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vote.entity.Votacao;

@Repository
public interface VotacaoRepository extends JpaRepository<Votacao, Long>{
	
	@Transactional
	@Modifying
	@Query("UPDATE Votacao SET associado_id = ?1, pauta_id = ?2, quantidade_votos = ?3 WHERE id = ?4")
	void votar(Long associadoID, Long pautaID, Long quantidadeVotos, Long votacaoID );
	
	@Query("SELECT v.quantidadeVotos FROM Votacao v WHERE id = ?1")
	Long qtdVotos(Long votacaoID );

}
