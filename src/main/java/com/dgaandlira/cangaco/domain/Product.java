package com.dgaandlira.cangaco.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="tb_products")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    @Column(unique = true)
    private String barcode;
    private Double price;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name="provider_id")
    private Provider provider;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="PRODUCT_CLIENT", joinColumns = @JoinColumn(name="product_id"),
    inverseJoinColumns = @JoinColumn(name="client_id"))
    private List<Client> clients = new ArrayList<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="PRODUCT_SALLER",joinColumns = @JoinColumn(name="product_id"),
    inverseJoinColumns = @JoinColumn(name="saller_id"))
    private List<Saller> sallers = new ArrayList<>();
    public Product() {
    }

    public Product(String name, String description, String barcode, Double price) {
        this.id = null;
        this.name = name;
        this.description = description;
        this.barcode = barcode;
        this.price = price;
    }
}
