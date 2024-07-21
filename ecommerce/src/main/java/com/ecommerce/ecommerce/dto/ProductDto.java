package com.ecommerce.ecommerce.dto;

import com.ecommerce.ecommerce.entities.Category;
import com.ecommerce.ecommerce.entities.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private int id ;
    private String englishName ;
    private String arabicName ;
    private int price ;
    private  int salePrice;
    private ProductStatus status;

    private Category productCategory;
}





















