package com.dgaandlira.cangaco.resources;

import com.dgaandlira.cangaco.domain.Seller;
import com.dgaandlira.cangaco.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sellers")
public class SellerResource {

    @Autowired
    private SellerService sellerService;

    @GetMapping(value = "/{cpf}")
    public ResponseEntity<Seller> findByCpf(@PathVariable String cpf) {
        Seller seller = sellerService.findByCpf(cpf);
        return ResponseEntity.ok().body(seller);
    }
}
