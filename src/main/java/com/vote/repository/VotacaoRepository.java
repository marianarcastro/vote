package com.vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vote.entity.Votacao;

@Repository
public interface VotacaoRepository extends JpaRepository<Votacao, Long>{

}
