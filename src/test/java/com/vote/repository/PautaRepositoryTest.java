package com.vote.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import com.vote.entity.Pauta;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PautaRepositoryTest {
	
	@Autowired
    private PautaRepository pautaRepository;

    @Test
    public void whenCreate_thenPersistData () {

        Pauta pauta = new Pauta();
        pauta.setNome("Pauta1");
        this.pautaRepository.save(pauta);

        assertThat(pauta.getId()).isNotNull();
        assertThat(pauta.getNome()).isEqualTo("Pauta1");

    }

    @Test
    public void whenDelete_thenRemoveData () {
    	Pauta pauta = new Pauta();
        pauta.setNome("Pauta1");
        this.pautaRepository.save(pauta);
        pautaRepository.delete(pauta);
        assertThat(pautaRepository.findById(pauta.getId())).isEmpty();

    }

}
