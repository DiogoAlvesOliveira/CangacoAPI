package com.dgaandlira.cangaco.resources;

import com.dgaandlira.cangaco.domain.Provider;
import com.dgaandlira.cangaco.services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
