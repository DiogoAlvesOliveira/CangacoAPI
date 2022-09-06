package com.dgaandlira.cangaco.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotEmpty(message = "Mandatory completion")
    @Length(min = 5, max = 80, message = "The length must be between 5 to 80 characters")
    private String name;

    @NotEmpty(message = "Mandatory completion")
    private String email;
    @NotEmpty(message = "Mandatory completion")
    @CPF
    private String cpf;
}
