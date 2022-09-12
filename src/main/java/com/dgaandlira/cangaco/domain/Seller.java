package com.dgaandlira.cangaco.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="tb_sellers")
public class Seller implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @Column(unique = true)
    private String cpf;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String registration;
    private String password;

    @ManyToMany(mappedBy="sellers")
    private List<Client> clients = new ArrayList<>();

    @ManyToMany(mappedBy="sellersProduct")
    private List<Product> products = new ArrayList<>();

    public Seller() {
    }

    public Seller(String name, String cpf, String email, String registration, String password) {
        this.id = null;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.registration = registration;
        this.password = password;
    }
}
