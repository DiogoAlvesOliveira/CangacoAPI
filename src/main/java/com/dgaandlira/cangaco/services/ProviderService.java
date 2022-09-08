package com.dgaandlira.cangaco.services;

import com.dgaandlira.cangaco.domain.Provider;
import com.dgaandlira.cangaco.repositories.ProviderRepository;
import com.dgaandlira.cangaco.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    public Provider findByName(String name) {
        Optional<Provider> provider = providerRepository.findByName(name);
        return provider.orElseThrow(()-> new ObjectNotFoundException("Could not find provider: " + name));
    }
}
