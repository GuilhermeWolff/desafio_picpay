package com.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.dto.ClientDTO;
import com.training.service.ClientService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/cliente")
@Slf4j
public class ClientController {
	
	
	@Autowired
	private ClientService service;
	
	@PostMapping("/add")
    public ResponseEntity<Void> addClient(@RequestBody ClientDTO dto) throws Exception {
		
		log.info("Iniciando cadastro de cliente");
		
		service.addClient(dto);
		return ResponseEntity.ok().build();
			
	}
}