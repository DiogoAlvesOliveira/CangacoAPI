package com.dgaandlira.cangaco.config;

import com.dgaandlira.cangaco.domain.Product;
import com.dgaandlira.cangaco.domain.Provider;
import com.dgaandlira.cangaco.domain.User;
import com.dgaandlira.cangaco.repositories.ProviderRepository;
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

    @Autowired
    private ProviderRepository providerRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Diogo", "diogo@gmail.com", "023.186.300-46", "123456", "adm");
        User user2 = new User(null, "Carlos", "carlos@gmail.com", "890.525.890-54", "123456", "adm");

        userRepository.saveAll(Arrays.asList(user1, user2));

        Provider provider = new Provider("Vitarela", "05663071000198","vitarela@gmail.com","53433-220","Rua José Ramos de Vasconcelos, 1079, Pau Amarelo");

        Product product1 = new Product("Biscoito treloso", "Biscoito recheado sabor chocolate 130g", "78945264879", 1.59);
        Product product2 = new Product("Macarrão", "Macarrão tipo fino 500g", "78945264878", 2.59);
        product1.setProvider(provider);
        product2.setProvider(provider);

        provider.getProducts().add(product1);
        provider.getProducts().add(product2);

        providerRepository.save(provider);

    }
}
