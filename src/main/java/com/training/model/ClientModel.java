package com.training.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
public class ClientModel {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@Column(name = "nome")
	public String nome;
	
	@Column(name = "idade")
	public Long idade;
	
	@Column(name = "email")
	public String email;
	
	@Column(name = "data_cadastro")
	public Date dataCadastro;
	
	@Column(name = "cpf")
	public Long cpf;
}
	