package com.dgaandlira.cangaco.dto;

import com.dgaandlira.cangaco.domain.Product;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProviderUpdateDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Length(min = 5, max = 80, message = "The length must be between 5 to 80 characters")
    private String name;

    @CNPJ
    private String cnpj;

    @Email
    private String email;

    private String cep;

    private String address;

    public ProviderUpdateDTO() {
    }

    public ProviderUpdateDTO(Integer id, String name, String cnpj, String email, String cep, String address) {
        this.name = name;
        this.cnpj = cnpj;
        this.email = email;
        this.cep = cep;
        this.address = address;
    }
}
