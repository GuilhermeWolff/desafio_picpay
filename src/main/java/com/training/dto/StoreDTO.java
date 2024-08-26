package com.training.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StoreDTO {

	private String nome;
	
	private String nomeEmpresa;
	
	private Date dataCadastro;
	
	private Long cnpj;

}
