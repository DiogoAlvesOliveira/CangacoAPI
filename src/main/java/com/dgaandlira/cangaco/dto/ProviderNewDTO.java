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
public class ProviderNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Mandatory completion")
    @Length(min = 5, max = 80, message = "The length must be between 5 to 80 characters")
    private String name;

    @CNPJ
    @NotEmpty(message = "Mandatory completion")
    private String cnpj;

    @Email
    @NotEmpty(message = "Mandatory completion")
    private String email;

    @NotEmpty(message = "Mandatory completion")
    private String cep;

    @NotEmpty(message = "Mandatory completion")
    private String address;

    private List<Product> products = new ArrayList<>();

    public ProviderNewDTO() {
    }

    public ProviderNewDTO(Integer id, String name, String cnpj, String email, String cep, String address) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.email = email;
        this.cep = cep;
        this.address = address;
    }
}
