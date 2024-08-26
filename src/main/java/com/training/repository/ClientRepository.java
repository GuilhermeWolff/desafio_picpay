package com.training.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.model.ClientModel;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long> {
	
	Optional<ClientModel> findByCpf(Long cpf);
    Optional<ClientModel> findByEmail(String email);

}
