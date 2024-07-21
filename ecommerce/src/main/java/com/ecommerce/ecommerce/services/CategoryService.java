package com.ecommerce.ecommerce.services;

import com.ecommerce.ecommerce.dto.CategoryDto;
import com.ecommerce.ecommerce.entities.Category;
import com.ecommerce.ecommerce.entities.CategoryStatus;
import com.ecommerce.ecommerce.exceptions.CategoryNotFoundException;
import com.ecommerce.ecommerce.mapper.CategoryMapper;
import com.ecommerce.ecommerce.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService  {

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    CategoryRepo categoryRepo ;

    @Transactional(readOnly = true)
    public List<CategoryDto> getAllCategories(){
        List<CategoryDto> categoryDtoList =new ArrayList<>();

        for (Category c : categoryRepo.findAll() ) {
            CategoryDto categoryDto = categoryMapper.toCategoryDto(c);
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList ;

    }

    @Transactional(readOnly = true)
    public List<CategoryDto> getDeleted(){
        List<CategoryDto> categoryDtoList =new ArrayList<>();

        for (Category c : categoryRepo.findByStatus(CategoryStatus.DELETED) ) {
            CategoryDto categoryDto = categoryMapper.toCategoryDto(c);
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList ;

    }




    @Transactional
    public void addCategory( CategoryDto categoryDto){
        Category category = categoryMapper.toCategory(categoryDto);
        categoryRepo.save(category);
    }

    @Transactional
    public void updateCategory( CategoryDto categoryDto){
        Category category = categoryMapper.toCategory(categoryDto);
        categoryRepo.save(category);
    }

    @Transactional
    public void deleteCategory(int id){

        Optional<Category> byId = categoryRepo.findById(id);
        if( byId.isPresent()){
            Category category = byId.get();
            category.setStatus(CategoryStatus.DELETED);
            categoryRepo.save(category);
        }else {
            throw new CategoryNotFoundException("no category with this id");
        }

    }



}
