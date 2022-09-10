package com.dgaandlira.cangaco.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Data
public class ClientNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotEmpty(message = "Mandatory completion")
    @Length(min = 5, max = 80, message = "The length must be between 5 to 80 characters")
    private String name;
    private String surname;

    @CPF
    @NotEmpty(message = "Mandatory completion")
    private String cpf;

    @Email
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd/MM/yyyy", timezone = "GMT")
    private Date birthDate;
    private String cep;
    private String address;

    public ClientNewDTO() {
    }

    public ClientNewDTO(String name, String surname, String cpf, String email, Date birthDate, String cep, String address) {
        this.id = null;
        this.name = name;
        this.surname = surname;
        this.cpf = cpf;
        this.email = email;
        this.birthDate = birthDate;
        this.cep = cep;
        this.address = address;
    }
}
