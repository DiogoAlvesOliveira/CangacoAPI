package com.dgaandlira.cangaco.services;

import com.dgaandlira.cangaco.domain.Client;
import com.dgaandlira.cangaco.domain.Product;
import com.dgaandlira.cangaco.domain.Seller;
import com.dgaandlira.cangaco.dto.SellerDTO;
import com.dgaandlira.cangaco.repositories.SellerRepository;
import com.dgaandlira.cangaco.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public SellerDTO findByCpf(String cpf) {
        Seller seller = sellerRepository.findByCpf(cpf);
        if (seller != null) {
            SellerDTO sellerDTO = showSeller(seller);
            return sellerDTO;
        }
        throw  new ObjectNotFoundException("Could not find seller " + cpf + ", type: " + Seller.class.getName());
    }

    private SellerDTO showSeller(Seller seller){
        SellerDTO sellerDTO = new SellerDTO(seller.getId(), seller.getName(), seller.getEmail(), seller.getRegistration());
        if(seller.getClients().size() > 0){
            for(Client client :seller.getClients()){
                sellerDTO.getClients().add(client);
            }
        }
        if(seller.getProducts().size() > 0) {
            for(Product product :seller.getProducts()){
                sellerDTO.getProducts().add(product);
            }
        }
        return sellerDTO;
    }
}
