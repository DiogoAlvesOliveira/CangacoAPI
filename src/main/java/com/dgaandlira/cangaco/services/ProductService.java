package com.dgaandlira.cangaco.services;

import com.dgaandlira.cangaco.domain.Product;
import com.dgaandlira.cangaco.repositories.ProductRepository;
import com.dgaandlira.cangaco.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product findById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow(()-> new ObjectNotFoundException("Could not find product with id: " + id + ", type: "+ Product.class.getName()));
    }

    public Product findByName(String name) {
        Optional<Product> product = productRepository.findByName(name);
        return product.orElseThrow(()-> new ObjectNotFoundException("Couldn't find product with name: " + name + ", type: "+ Product.class.getName()));
    }
}
