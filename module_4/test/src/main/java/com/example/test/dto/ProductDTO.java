package com.example.test.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductDTO implements Validator {
    @NotBlank
    @Size(min = 5,max = 50)
    private  String name;
    @NotNull
    @Min(100000)
    private Float price;
    private Long type;

    public ProductDTO() {
    }

    public ProductDTO(String name, Float price, Long type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDTO productDTO = (ProductDTO) target;
        Long typeName = productDTO.type;
        if(typeName<0){
            errors.rejectValue("type","","type this field");
        }
    }
}
