package com.dgaandlira.cangaco.resources;

import com.dgaandlira.cangaco.domain.Client;
import com.dgaandlira.cangaco.dto.ClientNewDTO;
import com.dgaandlira.cangaco.dto.ClientUpdateDTO;
import com.dgaandlira.cangaco.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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
    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<Client> findByCpf(@PathVariable String cpf) {
        Client client = clientService.findByCpf(cpf);
        return ResponseEntity.ok().body(client);
    }
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody ClientNewDTO clientNewDTO){
        Client client = clientService.fromDTO(clientNewDTO);
        client = clientService.insert(client);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Client> update(@PathVariable Integer id, @RequestBody ClientUpdateDTO clientUpdateDTO) {
        Client client = clientService.update(id, clientUpdateDTO);
        return ResponseEntity.noContent().build();

    }
}
