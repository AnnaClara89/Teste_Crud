package com.senai.anna;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.senai.anna.domain.Cidade;
import com.senai.anna.repositories.CidadeRepository;

@SpringBootTest
public class cidadeTest {
	@Autowired
	CidadeRepository cidadeRepository;

	@Test
	void Cidade() {
		Cidade c1 = new Cidade();
		c1.setId(null);
		c1.setNome("São Paulo");
		c1.setEstado(null);
		cidadeRepository.save(c1);
	}

	@Test
	public void listaCidade() {
		List<Cidade> List = cidadeRepository.findAll();
		assertThat(List).size().isGreaterThan(0);
	}

	@Test
	public void idCidade() {
		Cidade cidade = cidadeRepository.findById(1).get();
		assertEquals("São Paulo", cidade.getNome());
	}

	@Test
	public void updateCidade() {
		Cidade cidade = cidadeRepository.findById(1).get();
		cidade.setNome("São Paulo");
		cidadeRepository.save(cidade);
		assertNotEquals("São Paulo", cidade.getNome());
	}

	@Test
	public void deleteCidade() {
		cidadeRepository.deleteById(1);
		assertThat(cidadeRepository.existsById(1));
	}
}