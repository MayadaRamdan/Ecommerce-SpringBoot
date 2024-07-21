package com.ecommerce.ecommerce.mapper;

import com.ecommerce.ecommerce.dto.CategoryDto;
import com.ecommerce.ecommerce.entities.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CategoryMapper {

//    @Autowired
//    private static ModelMapper modelMapper;

    public  CategoryDto toCategoryDto(Category category){
        ModelMapper modelMapper =new ModelMapper();

        CategoryDto categoryDto = modelMapper.map(category ,CategoryDto.class );

        return categoryDto;

    }

    public  Category toCategory(CategoryDto categoryDto){

        ModelMapper modelMapper =new ModelMapper();
        Category category = modelMapper.map(categoryDto ,Category.class );

        return category;

    }


}
