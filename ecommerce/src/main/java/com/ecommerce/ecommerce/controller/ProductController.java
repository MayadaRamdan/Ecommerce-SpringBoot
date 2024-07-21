package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.dto.CategoryDto;
import com.ecommerce.ecommerce.dto.ProductDto;
import com.ecommerce.ecommerce.entities.Category;
import com.ecommerce.ecommerce.entities.Product;
import com.ecommerce.ecommerce.services.CategoryService;
import com.ecommerce.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Parameter;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProduct(){

       // List<ProductDto> allProduct = productService.getDeletedProduct();
        List<ProductDto> allProduct = productService.getAllProduct();
        return ResponseEntity.ok(allProduct);
    }

    @PostMapping
    public ResponseEntity<Void> addProduct(@RequestBody ProductDto productDto){
        productService.addProduct(productDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateProduct(@RequestBody ProductDto productDto){
        productService.updateProduct(productDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteProduct(@RequestParam("id") int id){
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductDto>> getProductsByCategory(@RequestParam(name = "category-id") int categoryId){

        List<ProductDto> listOfProducts = productService.findProductsByCategory(categoryId);
        return  ResponseEntity.ok(listOfProducts);
    }












}
