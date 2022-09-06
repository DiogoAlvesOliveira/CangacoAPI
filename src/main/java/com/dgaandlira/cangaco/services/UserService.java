package com.dgaandlira.cangaco.services;


import com.dgaandlira.cangaco.domain.User;
import com.dgaandlira.cangaco.repositories.UserRepository;

import com.dgaandlira.cangaco.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByCPF(String cpf){
        Optional<User> user = userRepository.findByCpf(cpf);
        return user.orElseThrow(()-> new ObjectNotFoundException("Could not find user by CPF: " + cpf));
    }
    public User findById(Integer id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(()-> new ObjectNotFoundException("Could not find user by id: " + id));
    }
}
