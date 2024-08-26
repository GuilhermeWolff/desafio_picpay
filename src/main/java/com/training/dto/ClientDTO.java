package com.training.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientDTO {
	
	private String nome;

	private Long idade;

	private String email;

	private String dataCadastro;

	private Long cpf;

}
