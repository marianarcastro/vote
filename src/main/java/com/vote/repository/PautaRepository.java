package com.vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vote.entity.Pauta;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long>{

}
