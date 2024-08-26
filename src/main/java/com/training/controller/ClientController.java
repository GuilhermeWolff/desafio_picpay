package com.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.service.ClientService;

@RestController
@RequestMapping("/cliente")
public class ClientController {
	
	
	@Autowired
	private ClientService trainingService;
	
	@PostMapping("/add")
    public ResponseEntity<String>addClient( 
    		@RequestParam Long cpf,
            @RequestParam String email,
            @RequestParam String nome) {
		if (trainingService.cpfVerify(cpf)) {
			return ResponseEntity.badRequest().body("CPF ja cadastrado");
		}
		if(trainingService.emailVeify(email)) {
			return ResponseEntity.badRequest().body("Email ja cadastrado");
		}       
		trainingService.saveTraining(cpf, email, nome);
		return ResponseEntity.ok("Cadastrado com Sucesso");		
	}
}