package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.dto.CategoryDto;
import com.ecommerce.ecommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        //List<CategoryDto> allCategories = categoryService.getDeleted();
        List<CategoryDto> allCategories = categoryService.getAllCategories();
        return  ResponseEntity.ok(allCategories);
    }




    @PostMapping
    public ResponseEntity<Void> addCategory(@RequestBody CategoryDto category){

        categoryService.addCategory(category);

        return ResponseEntity.ok().build();
    }



    @PutMapping
    public ResponseEntity<Void> updateCategory(@RequestBody CategoryDto categoryDto){
         categoryService.updateCategory(categoryDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") int id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();

    }
}
