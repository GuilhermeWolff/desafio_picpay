package com.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.service.StoreService;

@RestController
@RequestMapping("/lojista")
public class StoreController {
	
	
	@Autowired
	private StoreService storeService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addEmpresa(
			@RequestParam Long cnpj,
            @RequestParam String nome,
            @RequestParam String nome_empresa){
		if(storeService.cnpjVerify(cnpj)) {
			return ResponseEntity.badRequest().body("CNPJ ja cadastrado");
		}
		if(storeService.empresaVerify(nome_empresa)) {
			return ResponseEntity.badRequest().body("Empresa ja cadastrado");
		}
		storeService.saveStore(cnpj, nome, nome_empresa);
		return ResponseEntity.ok("Cadastrado com Sucesso");		
	}
}