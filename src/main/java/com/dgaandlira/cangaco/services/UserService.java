package com.dgaandlira.cangaco.services;


import com.dgaandlira.cangaco.domain.User;
import com.dgaandlira.cangaco.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByCPF(){
        User user = new User();
        return user;

    }
}
