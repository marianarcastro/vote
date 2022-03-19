package com.vote.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vote.entity.Votacao;

@Repository
public interface VotacaoRepository extends JpaRepository<Votacao, Long>{
	
	@Transactional
	@Modifying
	@Query("UPDATE Votacao SET associado_id = ?1, pauta_id = ?2, quantidade_votos = ?3, voto = ?4 WHERE id = ?5")
	void votar(Long associadoID, Long pautaID, Long quantidadeVotos, String voto, Long votacaoID);
	
	@Query("SELECT v.quantidadeVotos FROM Votacao v WHERE id = ?1")
	Long qtdVotos(Long votacaoID );
	
	@Query("SELECT v FROM Votacao v WHERE v.associadoID = ?1 and v.id = ?2")
	Votacao getVotacaoPorAssociadoID(Long associadoID, Long id );
	
	@Query("SELECT v.id FROM Votacao v ORDER BY id DESC")
	List<Long> getLastID(Pageable pageable);
	
	@Transactional
	@Modifying
	@Query("UPDATE Votacao SET status = ?1 WHERE id = ?2")
	void mudarStatusVotacao(String status, Long id);

}
