package com.dgaandlira.cangaco.services;

import com.dgaandlira.cangaco.domain.*;
import com.dgaandlira.cangaco.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private SellerRepository sellerRepository;

    public void instantiateTestDatabase() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        User user1 = new User(null, "Diogo", "diogo@gmail.com", "023.186.300-46", "123456", "adm");
        User user2 = new User(null, "Carlos", "carlos@gmail.com", "890.525.890-54", "123456", "adm");



        Provider provider = new Provider("Vitarela", "05663071000198","vitarela@gmail.com","53433-220","Rua José Ramos de Vasconcelos, 1079, Pau Amarelo");

        Product product1 = new Product("Biscoito treloso", "Biscoito recheado sabor chocolate 130g", "78945264879", 1.59);
        Product product2 = new Product("Macarrão", "Macarrão tipo fino 500g", "78945264878", 2.59);

        product1.setProvider(provider);
        product2.setProvider(provider);

        provider.getProducts().add(product1);
        provider.getProducts().add(product2);

        providerRepository.saveAll(Arrays.asList(provider));

        Client client1 = new Client("Patricia","Venceslau", "60281607095", "paty@gmail.com", sdf.parse ("10/01/1986"), "53433-220", "Rua José Ramos de Vasconcelos, 1079, Pau Amarelo, Paulista");
        Client client2 = new Client("Renata","Lira", "92722802066", "renata@gmail.com", sdf.parse ("10/01/1987"), "52140-310", "Rua Joaquim de França, 171, Dois Unidos, Recife");
        client1.getProducts().add(product1);
        client2.setProducts(product2);

        product1.getClientsProduct().add(client1);
        product2.getClientsProduct().add(client2);

        Seller seller1 = new Seller("Mario","02857774087","mario@gmail.com","20221","123456");
        Seller seller2 = new Seller("Darlan","78366495043","darlan@gmail.com","20222","123456");

        client1.getSellers().add(seller1);
        client2.getSellers().add(seller2);

        product1.getSellersProduct().add(seller1);
        product2.getSellersProduct().addAll(Arrays.asList(seller1,seller2));

        seller1.getProducts().addAll(Arrays.asList(product1,product2));
        seller2.getProducts().add(product2);

        seller1.getClients().add(client1);
        seller2.getClients().add(client2);

        userRepository.saveAll(Arrays.asList(user1, user2));
        sellerRepository.saveAll(Arrays.asList(seller1, seller2));
        clientRepository.saveAll(Arrays.asList(client1, client2));
        productRepository.saveAll(Arrays.asList(product1, product2));
    }
}
