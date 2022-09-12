package com.dgaandlira.cangaco.services;

import com.dgaandlira.cangaco.domain.Client;
import com.dgaandlira.cangaco.domain.Product;
import com.dgaandlira.cangaco.domain.Seller;
import com.dgaandlira.cangaco.dto.SellerDTO;
import com.dgaandlira.cangaco.dto.SellerNewDTO;
import com.dgaandlira.cangaco.repositories.SellerRepository;
import com.dgaandlira.cangaco.services.exceptions.DataIntegrityException;
import com.dgaandlira.cangaco.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        throw new ObjectNotFoundException("Could not find seller " + cpf + ", type: " + Seller.class.getName());
    }

    public Seller insert(SellerNewDTO sellerDTO) {
        Seller seller = fromDTO(sellerDTO);
        return sellerRepository.save(seller);
    }
    public Seller update(String cpf, SellerNewDTO sellerNewDTO) {
        Seller seller = sellerRepository.findByCpf(cpf);
        if (seller != null) {
            updateData(seller, sellerNewDTO);
            return sellerRepository.save(seller);
        }
        throw new ObjectNotFoundException("Could not find seller " + cpf + ", type: " + Seller.class.getName());
    }

    private void updateData(Seller seller, SellerNewDTO sellerNewDTO) {
        if(sellerNewDTO.getName()!= null) seller.setName( sellerNewDTO.getName());
        if(sellerNewDTO.getCpf()!= null) seller.setCpf(sellerNewDTO.getCpf());
        if(sellerNewDTO.getEmail() != null) seller.setEmail(sellerNewDTO.getEmail());
        if (sellerNewDTO.getRegistration() != null) seller.setRegistration(sellerNewDTO.getRegistration());
        if (sellerNewDTO.getPassword() != null) seller.setPassword(sellerNewDTO.getPassword());
    }
    public void delete(Integer id) {
        Optional<Seller> seller = sellerRepository.findById(id);
        try {
            sellerRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Cannot delete a provider that has product");
        }
    }

    private Seller fromDTO(SellerNewDTO sellerDTO) {
        return new Seller(sellerDTO.getName(),sellerDTO.getCpf() , sellerDTO.getEmail(), sellerDTO.getRegistration(),sellerDTO.getPassword());
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
