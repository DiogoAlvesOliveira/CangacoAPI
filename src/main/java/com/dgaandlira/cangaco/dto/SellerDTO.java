package com.dgaandlira.cangaco.dto;

import com.dgaandlira.cangaco.domain.Client;
import com.dgaandlira.cangaco.domain.Product;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class SellerDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String email;
    private String registration;
    private List<Client> clients = new ArrayList<>();
    private List<Product> products = new ArrayList<>();

    public SellerDTO() {
    }

    public SellerDTO(Integer id, String name, String email, String registration) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.registration = registration;
    }
}
