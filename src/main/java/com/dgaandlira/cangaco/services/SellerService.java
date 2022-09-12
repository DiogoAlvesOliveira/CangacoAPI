package com.dgaandlira.cangaco.services;

import com.dgaandlira.cangaco.domain.Seller;
import com.dgaandlira.cangaco.repositories.SellerRepository;
import com.dgaandlira.cangaco.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public Seller findByCpf(String cpf) {
        Optional<Seller> seller = sellerRepository.findByCpf(cpf);
        return seller.orElseThrow(()-> new ObjectNotFoundException("Could not find seller " + cpf + ", type: " + Seller.class.getName()));
    }
}
