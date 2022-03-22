package com.vote.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import com.vote.entity.Votacao;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class VotacaoRepositoryTest {
	
	@Autowired
    private VotacaoRepository votacaoRepository;

    @Test
    public void whenCreate_thenPersistData () {

        Votacao votacao = new Votacao();
        votacao.setStatus("ATIVO");
        votacao.setVoto("Sim");
        this.votacaoRepository.save(votacao);

        assertThat(votacao.getId()).isNotNull();
        assertThat(votacao.getStatus()).isEqualTo("ATIVO");
        assertThat(votacao.getVoto()).isEqualTo("Sim");

    }

    @Test
    public void whenDelete_thenRemoveData () {
    	Votacao votacao = new Votacao();
        votacao.setStatus("ATIVO");
        votacao.setVoto("Sim");
        this.votacaoRepository.save(votacao);
        votacaoRepository.delete(votacao);
        assertThat(votacaoRepository.findById(votacao.getId())).isEmpty();

    }

}
