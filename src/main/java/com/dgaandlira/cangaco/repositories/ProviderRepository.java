package com.dgaandlira.cangaco.repositories;

import com.dgaandlira.cangaco.domain.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Integer> {

    @Transactional(readOnly = true)
    Optional<Provider> findByName(String name);
}
