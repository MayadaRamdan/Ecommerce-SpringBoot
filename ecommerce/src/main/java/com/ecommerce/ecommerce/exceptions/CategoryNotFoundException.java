package com.ecommerce.ecommerce.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class CategoryNotFoundException extends RuntimeException {

    private String msg ;

}
