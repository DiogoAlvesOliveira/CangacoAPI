package com.dgaandlira.cangaco.resources;

import com.dgaandlira.cangaco.domain.Product;
import com.dgaandlira.cangaco.dto.ProductDTO;
import com.dgaandlira.cangaco.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id) {
        Product product = productService.findById(id);
        return ResponseEntity.ok().body(product);
    }
    @GetMapping(value = "/name/{name}")
    public ResponseEntity<Product> findByName(@PathVariable String name) {
        Product product = productService.findByName(name);
        return ResponseEntity.ok().body(product);
    }
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody ProductDTO productDTO){
        Product product = productService.fromDTO(productDTO);
        product = productService.insert(product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Product> update(@PathVariable Integer id, @RequestBody ProductDTO productDTO){
        Product product = productService.update(id, productDTO);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Product> delete(@PathVariable Integer id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
