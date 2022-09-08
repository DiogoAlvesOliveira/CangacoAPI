package com.dgaandlira.cangaco.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@AllArgsConstructor
@Table(name="tb_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String cpf;
    private String password;
    private String profile;

    public User() {
    }

   /* public User(Integer id, String name, String email, String cpf) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }*/
}
