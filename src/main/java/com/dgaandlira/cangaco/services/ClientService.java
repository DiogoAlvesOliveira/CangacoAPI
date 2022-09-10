package com.dgaandlira.cangaco.services;

import com.dgaandlira.cangaco.domain.Client;
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
}
