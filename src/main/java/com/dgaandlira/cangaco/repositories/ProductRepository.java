package com.dgaandlira.cangaco.repositories;

import com.dgaandlira.cangaco.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Transactional(readOnly = true)
    Optional<Product> findByName(String name);
}
