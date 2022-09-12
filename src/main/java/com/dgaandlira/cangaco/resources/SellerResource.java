package com.dgaandlira.cangaco.resources;

import com.dgaandlira.cangaco.dto.SellerDTO;
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
    public ResponseEntity<SellerDTO> findByCpf(@PathVariable String cpf) {
        SellerDTO sellerDTO = sellerService.findByCpf(cpf);

        return ResponseEntity.ok().body(sellerDTO);
    }
}
