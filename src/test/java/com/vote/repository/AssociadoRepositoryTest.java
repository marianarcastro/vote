package com.vote.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import com.vote.entity.Associado;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AssociadoRepositoryTest {
	
	@Autowired
    private AssociadoRepository associadoRepository;

    @Test
    public void whenCreate_thenPersistData () {

        Associado associado = new Associado();
        associado.setCpf("123");
        associado.setNome("Marcos");
        this.associadoRepository.save(associado);

        assertThat(associado.getId()).isNotNull();
        assertThat(associado.getNome()).isEqualTo("Marcos");
        assertThat(associado.getCpf()).isEqualTo("123");

    }

    @Test
    public void whenDelete_thenRemoveData () {
    	Associado associado = new Associado();
        associado.setCpf("123");
        associado.setNome("Marcos");
        this.associadoRepository.save(associado);
        associadoRepository.delete(associado);
        assertThat(associadoRepository.findById(associado.getId())).isEmpty();

    }

}
