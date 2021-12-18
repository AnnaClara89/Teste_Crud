package com.senai.anna.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 

public class Endereco implements Serializable {
private static final long serialVersionUID = 1l; 
@Column(name="id_endereco")
@Id 
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Integer IdEndereco;
private String logradouro;
private String numero;
private String complemento;
private String bairro;
private String cep; 
@JsonIgnore
@ManyToOne 
@JoinColumn(name="cliente_id")
private Cliente cliente;

@JoinColumn(name="Cidade_id")
@ManyToOne
private Cidade cidade; 

public Endereco() {
	
}

public Endereco(Integer idEndereco, String logradouro, String numero, String complemento, String bairro, String cep, Cliente cliente, Cidade cidade) {
	super();
	IdEndereco = idEndereco;
	this.logradouro = logradouro;
	this.numero = numero;
	this.complemento = complemento;
	this.bairro = bairro;
	this.cep = cep; 
	this.cliente = cliente;
}

public Integer getIdEndereco() {
	return IdEndereco;
}

public void setIdEndereco(Integer idEndereco) {
	IdEndereco = idEndereco;
}

public String getLogradouro() {
	return logradouro;
}

public void setLogradouro(String logradouro) {
	this.logradouro = logradouro;
}

public String getNumero() {
	return numero;
}

public void setNumero(String numero) {
	this.numero = numero;
}

public String getComplemento() {
	return complemento;
}

public void setComplemento(String complemento) {
	this.complemento = complemento;
}

public String getBairro() {
	return bairro;
}

public void setBairro(String bairro) {
	this.bairro = bairro;
}

public String getCep() {
	return cep;
}

public void setCep(String cep) {
	this.cep = cep; 
	
}

public Cliente getCliente() {
	return cliente;
}

public void setCliente(Cliente cliente) {
	this.cliente = cliente;
} 
public static long getSerialversionuid() {
	return serialVersionUID;
}

@Override
public int hashCode() {
	return Objects.hash(bairro, cep, cliente, complemento, IdEndereco, logradouro, numero);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Endereco other = (Endereco) obj;
	return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
			&& Objects.equals(cliente, other.cliente) && Objects.equals(complemento, other.complemento)
			&& Objects.equals(IdEndereco, other.IdEndereco) && Objects.equals(logradouro, other.logradouro)
			&& Objects.equals(numero, other.numero);
}
}

