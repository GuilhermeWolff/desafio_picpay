package com.training.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.dto.ClientDTO;
import com.training.model.ClientModel;
import com.training.repository.ClientRepository;

import lombok.extern.slf4j.Slf4j;
 
@Service
@Slf4j
public class ClientService {
	
   @Autowired
	private ClientRepository clientRepository;
	
	public boolean cpfVerify(Long cpf) {
		Optional<ClientModel> existingCpf = clientRepository.findByCpf(cpf);
		return existingCpf.isPresent();
	}
	
	public boolean emailVerify(String email) {
		Optional<ClientModel> existingEmail = clientRepository.findByEmail(email);
		return existingEmail.isPresent(); 		
	}
	
	public ClientModel saveTraining(Long cpf, String email, String nome) {
        ClientModel training = new ClientModel();
        training.setCpf(cpf);
        training.setEmail(email);
        training.setNome(nome);

        return clientRepository.save(training);	
	}

	public void addClient(ClientDTO dto) throws Exception {
		log.info("Iniciando conversao de client");
		
		ClientModel clientModel = fromDTO(dto);
		
		if(cpfVerify(clientModel.getCpf())) {
			throw new Exception("Cpf informado ja existe");
		}
		
		if(emailVerify(dto.getEmail())) {
			throw new Exception("email informado ja existe");
		}
		
		clientRepository.save(clientModel);
		
		
	}
	
	private ClientModel fromDTO(ClientDTO dto) {
		ClientModel client = new ClientModel();
		client.setCpf(dto.getCpf());
		client.setDataCadastro(LocalDate.parse(dto.getDataCadastro()));
		client.setEmail(dto.getEmail());
		client.setIdade(dto.getIdade());
		client.setNome(dto.getNome());
		
		return client;
	}
	
}