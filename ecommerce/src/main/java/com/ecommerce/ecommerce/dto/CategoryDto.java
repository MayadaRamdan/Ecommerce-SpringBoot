package com.ecommerce.ecommerce.dto;

import com.ecommerce.ecommerce.entities.CategoryStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private int id ;
    private String englishName ;
    private String arabicName ;
    private String englishPath ;
    private String arabicPath ;
    private CategoryStatus status;
    private CategoryDto parentCategory;


}
