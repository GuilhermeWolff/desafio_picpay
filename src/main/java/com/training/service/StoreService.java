package com.training.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.model.StoreModel;
import com.training.repository.StoreRepository;

@Service	
public class StoreService {
	
	@Autowired
	private StoreRepository storeRepository;
		
	public boolean cnpjVerify (Long cnpj) {
		Optional<StoreModel> existingCnpj = storeRepository.findByCnpj(cnpj);
		return existingCnpj.isPresent();
	}

	public boolean empresaVerify(String nome_empresa) {
		Optional<StoreModel> existingEmpresa = storeRepository.findByNomeEmpresa(nome_empresa);
		return existingEmpresa.isPresent();
	}
	
	public StoreModel saveStore(Long cnpj,String nome,String nome_empresa) {
		StoreModel store = new StoreModel();
		store.setCnpj(cnpj);
		store.setNome(nome);
		store.setNomeEmpresa(nome_empresa);	
		return storeRepository.save(store);
	}
}
