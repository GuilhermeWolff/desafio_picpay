package com.training.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.model.ClientModel;
import com.training.repository.ClientRepository;
 
@Service
public class ClientService {
	
   @Autowired
	private ClientRepository trainingRepository;
	
	public boolean cpfVerify(Long cpf) {
		Optional<ClientModel> existingCpf = trainingRepository.findByCpf(cpf);
		return existingCpf.isPresent();
	}
	
	public boolean emailVeify(String email) {
		Optional<ClientModel> existingEmail = trainingRepository.findByEmail(email);
		return existingEmail.isPresent(); 		
	}
	
	public ClientModel saveTraining(Long cpf, String email, String nome) {
        ClientModel training = new ClientModel();
        training.setCpf(cpf);
        training.setEmail(email);
        training.setNome(nome);

        return trainingRepository.save(training);	
	}
}