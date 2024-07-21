package com.ecommerce.ecommerce.mapper;

import com.ecommerce.ecommerce.dto.CategoryDto;
import com.ecommerce.ecommerce.dto.ProductDto;
import com.ecommerce.ecommerce.entities.Category;
import com.ecommerce.ecommerce.entities.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

//    @Autowired
//    private static ModelMapper modelMapper;

    public static ProductDto toProductDto(Product product){

        ModelMapper modelMapper =new ModelMapper();
        ProductDto productDto = modelMapper.map(product ,ProductDto.class );

        return productDto;

    }


    public static Product toProduct(ProductDto productDto){

        ModelMapper modelMapper =new ModelMapper();
        Product product = modelMapper.map(productDto ,Product.class );

        return product;

    }
}
