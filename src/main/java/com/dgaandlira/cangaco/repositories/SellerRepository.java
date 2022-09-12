package com.dgaandlira.cangaco.repositories;

import com.dgaandlira.cangaco.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {

    @Transactional(readOnly = true)
    Seller findByCpf(String cpf);
    @Transactional(readOnly = true)
    Seller deleteByCpf(String cpf);
}
