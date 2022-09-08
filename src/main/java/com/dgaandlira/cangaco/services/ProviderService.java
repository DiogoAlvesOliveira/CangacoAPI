package com.dgaandlira.cangaco.services;

import com.dgaandlira.cangaco.domain.Product;
import com.dgaandlira.cangaco.domain.Provider;
import com.dgaandlira.cangaco.dto.ProviderNewDTO;
import com.dgaandlira.cangaco.repositories.ProviderRepository;
import com.dgaandlira.cangaco.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    public Provider findByName(String name) {
        Optional<Provider> provider = providerRepository.findByName(name);
        return provider.orElseThrow(()-> new ObjectNotFoundException("Could not find provider: " + name));
    }

    public Provider findByCnpj(String cnpj) {
        Optional<Provider> provider = providerRepository.findByCnpj(cnpj);
        return provider.orElseThrow(()-> new ObjectNotFoundException("Could not find provider: " + cnpj));
    }
    @Transactional
    public Provider insert(Provider provider){
        provider.setId(null);
        provider = providerRepository.save(provider);
        return provider;
    }

    public Provider fromDTO(ProviderNewDTO providerDTO){
        Provider provider = new Provider(null, providerDTO.getName(), providerDTO.getCnpj(), providerDTO.getEmail(),providerDTO.getCep(), providerDTO.getAddress());
        return provider;
    }
}
