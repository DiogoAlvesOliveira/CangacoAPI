package com.dgaandlira.cangaco.resources;

import com.dgaandlira.cangaco.domain.Client;
import com.dgaandlira.cangaco.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/{name}")
    public ResponseEntity<Client> findByName(@PathVariable String name) {
        Client client = clientService.findByName(name);
        return ResponseEntity.ok().body(client);
    }
}
