package com.dgaandlira.cangaco.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="tb_providers")
public class Provider implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @Column(unique = true)
    private String cnpj;
    @Column(unique = true)
    private String email;
    private String cep;
    private String address;

    @OneToMany(mappedBy="provider", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    public Provider() {
    }

    public Provider(String name, String cnpj, String email, String cep, String address) {
        this.id = null;
        this.name = name;
        this.cnpj = cnpj;
        this.email = email;
        this.cep = cep;
        this.address = address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
