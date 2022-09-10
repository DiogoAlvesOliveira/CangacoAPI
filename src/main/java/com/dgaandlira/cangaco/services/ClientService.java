package com.dgaandlira.cangaco.services;

import com.dgaandlira.cangaco.domain.Client;
import com.dgaandlira.cangaco.dto.ClientNewDTO;
import com.dgaandlira.cangaco.dto.ClientUpdateDTO;
import com.dgaandlira.cangaco.repositories.ClientRepository;
import com.dgaandlira.cangaco.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client findById(Integer id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElseThrow(()-> new ObjectNotFoundException("Could not find client " + id + " , type: " + Client.class.getName()));
    }

    public Client findByName(String name) {
        Optional<Client> client = clientRepository.findByName(name);
        return client.orElseThrow(()-> new ObjectNotFoundException("Could not find client " + name + " , type: " + Client.class.getName()));
    }

    public Client findByCpf(String cpf) {
        Optional<Client> client = clientRepository.findByCpf(cpf);
        return client.orElseThrow(()-> new ObjectNotFoundException("Could not find client " + cpf + " , type: " + Client.class.getName()));
    }


    public Client insert(Client client) {
        return clientRepository.save(client);
    }
    public Client update(Integer id, ClientUpdateDTO clientUpdateDTO) {
        Client client = findById(id);
        updateData(client, clientUpdateDTO);
        return clientRepository.save(client);
    }

    public Client fromDTO(ClientNewDTO clientNewDTO) {
        return new Client(
                clientNewDTO.getName(),
                clientNewDTO.getSurname(),
                clientNewDTO.getCpf(),
                clientNewDTO.getEmail(),
                clientNewDTO.getBirthDate(),
                clientNewDTO.getCep(),
                clientNewDTO.getAddress());
    }
    private void updateData(Client client, ClientUpdateDTO clientUpdateDTO) {
        if(clientUpdateDTO.getName() != null) client.setName(clientUpdateDTO.getName());
        if(clientUpdateDTO.getSurname()!= null) client.setSurname(clientUpdateDTO.getSurname());
        if(clientUpdateDTO.getCpf() != null) client.setCpf(clientUpdateDTO.getCpf());
        if(clientUpdateDTO.getEmail() != null) client.setEmail(clientUpdateDTO.getEmail());
        if(clientUpdateDTO.getBirthDate() != null) client.setBirthDate(clientUpdateDTO.getBirthDate());
        if(clientUpdateDTO.getCep() != null) client.setCep(clientUpdateDTO.getCep());
        if(clientUpdateDTO.getAddress() != null) client.setAddress(clientUpdateDTO.getAddress());
    }

}
