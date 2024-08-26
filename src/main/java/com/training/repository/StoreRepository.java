package com.training.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.model.StoreModel;

@Repository	
public interface StoreRepository extends JpaRepository<StoreModel, Long> {

	Optional<StoreModel> findByCnpj(Long cnpj);
    Optional<StoreModel> findByNomeEmpresa(String nome_empresa);
	
}
