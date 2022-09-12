package com.dgaandlira.cangaco.dto;

import com.dgaandlira.cangaco.domain.Client;
import com.dgaandlira.cangaco.domain.Product;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class SellerUpdateDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    @Email
    private String email;
    @CPF
    private String cpf;
    private String registration;
    private String password;
    private List<Client> clients = new ArrayList<>();
    private List<Product> products = new ArrayList<>();

    public SellerUpdateDTO() {
    }

    public SellerUpdateDTO(String name, String email, String cpf, String registration, String password) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.registration = registration;
        this.password = password;
    }
}
