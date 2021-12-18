package com.senai.anna;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.senai.anna.domain.Cliente;
import com.senai.anna.repositories.ClienteRepository;

@SpringBootTest

public class clienteTest {

	@Autowired
	ClienteRepository clienteRepository;

	@Test
	void Cliente() {
		Cliente cli = new Cliente();
		cli.setIdCliente(null);
		cli.setNome("Anna Clara");
		cli.setCpfOuCnpj("65541239874");
		cli.setEmail("annaclara89@gmail.com");
		clienteRepository.save(cli);
	}

	@Test
	public void listaCliente() {
		List<Cliente> List = clienteRepository.findAll();
		assertThat(List).size().isGreaterThan(0);
	}

	@Test
	public void idCliente() {
		Cliente cliente = clienteRepository.findById(1).get();
		assertEquals("Anna Clara", cliente.getNome());
	}

	@Test
	public void updateCliente() {
		Cliente cliente = clienteRepository.findById(1).get();
		cliente.setNome("Anna Clara");
		clienteRepository.save(cliente);
		assertNotEquals("Anna", cliente.getNome());
	}

	@Test
	public void deleteCliente() {
		clienteRepository.deleteById(1);
		assertThat(clienteRepository.existsById(1));
	}
}