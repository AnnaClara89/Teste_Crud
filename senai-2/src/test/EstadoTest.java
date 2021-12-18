package com.senai.anna;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.senai.anna.domain.Estado;
import com.senai.anna.repositories.EstadoRepository;

@SpringBootTest
public class estadoTest {
	@Autowired
	EstadoRepository estadoRepository;

	@Test
	void Estado() {
		Estado est1 = new Estado();
		est1.setId(null);
		;
		est1.setNome("São Paulo");
		est1.setCidades(null);
		estadoRepository.save(est1);
	}

	@Test
	public void listaEstado() {
		List<Estado> List = estadoRepository.findAll();
		assertThat(List).size().isGreaterThan(0);
	}

	@Test
	public void idEstado() {
		Estado estado = estadoRepository.findById(1).get();
		assertEquals("São Paulo", estado.getNome());
	}

	@Test
	public void updateEstado() {
		Estado estado = estadoRepository.findById(1).get();
		estado.setNome("São Paulo");
		estadoRepository.save(estado);
		assertNotEquals("SP", estado.getNome());
	}

	@Test
	public void deleteEstado() {
		estadoRepository.deleteById(1);
		assertThat(estadoRepository.existsById(1));
	}
}