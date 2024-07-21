package com.ecommerce.ecommerce.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductNotFoundException  extends RuntimeException {

    private String msg ;

}
