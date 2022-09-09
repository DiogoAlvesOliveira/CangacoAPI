package com.dgaandlira.cangaco.dto;

import com.dgaandlira.cangaco.domain.Provider;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Data
public class ProductDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    @Length(min = 5, max = 80, message = "The length must be between 5 to 80 characters")
    private String name;

    private String description;
    private String barcode;
    private Double price;
    private Provider provider;
    private Integer idProvider;
    public ProductDTO() {
    }

    public ProductDTO(String name, String description, String barcode, Double price, Integer idProvider) {
        this.id = null;
        this.name = name;
        this.description = description;
        this.barcode = barcode;
        this.price = price;
        this.idProvider = idProvider;
    }
}
