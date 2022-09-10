package com.dgaandlira.cangaco.repositories;

import com.dgaandlira.cangaco.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Transactional(readOnly = true)
    Optional<Client> findByName(String name);

    @Transactional(readOnly = true)
    Optional<Client> findByCpf(String cpf);
}
