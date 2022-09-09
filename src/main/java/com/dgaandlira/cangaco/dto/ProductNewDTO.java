package com.dgaandlira.cangaco.dto;

import com.dgaandlira.cangaco.domain.Provider;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.math.BigInteger;

import static org.aspectj.runtime.internal.Conversions.longValue;

@Data
public class ProductNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Mandatory completion")
    @Length(min = 5, max = 80, message = "The length must be between 5 to 80 characters")
    private String name;

    private String description;
    private String barcode;
    private Double price;
    private Provider provider;
    private Integer idProvider;
    public ProductNewDTO() {
    }

    public ProductNewDTO(String name, String description, String barcode, Double price, Integer idProvider) {
        this.id = null;
        this.name = name;
        this.description = description;
        this.barcode = barcode;
        this.price = price;
        this.idProvider = idProvider;
    }
}
