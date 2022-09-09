package com.dgaandlira.cangaco.resources;

import com.dgaandlira.cangaco.domain.Provider;
import com.dgaandlira.cangaco.dto.ProviderNewDTO;
import com.dgaandlira.cangaco.dto.ProviderUpdateDTO;
import com.dgaandlira.cangaco.services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/providers")
public class ProviderResource {

    @Autowired
    private ProviderService providerService;

    @GetMapping(value = "/{name}")
    public ResponseEntity<Provider> findByName(@PathVariable String name) {
        Provider provider = providerService.findByName(name);
        return ResponseEntity.ok().body(provider);
    }

    @GetMapping(value = "/cnpj/{cnpj}")
    public ResponseEntity<Provider> findByCnpj(@PathVariable String cnpj){
        Provider provider = providerService.findByCnpj(cnpj);
        return ResponseEntity.ok().body(provider);
    }
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody ProviderNewDTO providerDTO){
        Provider provider = providerService.fromDTO(providerDTO);
        provider = providerService.insert(provider);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(provider.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Provider> delete(@PathVariable Integer id) {
        providerService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Provider> update(@RequestBody ProviderUpdateDTO providerUpdateDTO, @PathVariable Integer id){
        Provider provider = providerService.update(providerUpdateDTO, id);
        return ResponseEntity.noContent().build();
    }
}
