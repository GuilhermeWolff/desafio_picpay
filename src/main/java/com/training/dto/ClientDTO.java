package com.training.dto;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientDTO {
	
	
	private String name;
	
	private String email;
	
	private String cnpjCpf;
	
	private String password;
	
	private LocalDate createdAt;
	
	private String typeUser;

	private Double saldo;

}
