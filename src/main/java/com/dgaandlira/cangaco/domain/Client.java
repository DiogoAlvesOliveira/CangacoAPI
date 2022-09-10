package com.dgaandlira.cangaco.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="tb_clients")
public class Client implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String surname;
    @Column(unique = true)
    private String cpf;
    @Column(unique = true)
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd/MM/yyyy", timezone = "GMT")
    private Date birthDate;
    private String cep;
    private String address;

    @ManyToMany(mappedBy="clients")
    private List<Product> products = new ArrayList<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="CLIENT_SELLER", joinColumns = @JoinColumn(name="client_id"),
    inverseJoinColumns = @JoinColumn(name="seller_id"))
    private List<Seller> sellers = new ArrayList<>();

    public Client() {
    }

    public Client(String name, String surname, String cpf, String email, Date birthDate, String cep, String address) {
        this.id = null;
        this.name = name;
        this.surname = surname;
        this.cpf = cpf;
        this.email = email;
        this.birthDate = birthDate;
        this.cep = cep;
        this.address = address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products.add(products);
    }
}
