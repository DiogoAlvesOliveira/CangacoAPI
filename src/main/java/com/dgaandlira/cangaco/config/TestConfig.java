package com.dgaandlira.cangaco.config;

import com.dgaandlira.cangaco.domain.User;
import com.dgaandlira.cangaco.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Diogo", "diogo@gmail.com", "023.186.300-46");
        User user2 = new User(null, "Carlos", "carlos@gmail.com", "890.525.890-54");

        userRepository.saveAll(Arrays.asList(user1, user2));
    }
}
