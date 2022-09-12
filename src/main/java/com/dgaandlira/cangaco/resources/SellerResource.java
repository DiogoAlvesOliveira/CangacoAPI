package com.dgaandlira.cangaco.resources;

import com.dgaandlira.cangaco.domain.Seller;
import com.dgaandlira.cangaco.dto.SellerDTO;
import com.dgaandlira.cangaco.dto.SellerNewDTO;
import com.dgaandlira.cangaco.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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
    @PostMapping()
    public ResponseEntity<Void> update(@RequestBody SellerNewDTO sellerNewDTO){
        Seller seller = sellerService.insert(sellerNewDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(seller.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{cpf}")
    public ResponseEntity<SellerDTO> update(@PathVariable String cpf, @RequestBody SellerNewDTO sellerNewDTO){
        Seller seller = sellerService.update(cpf, sellerNewDTO);
        return ResponseEntity.noContent().build();
    }
}
