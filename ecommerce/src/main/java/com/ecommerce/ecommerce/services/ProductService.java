package com.ecommerce.ecommerce.services;

import com.ecommerce.ecommerce.dto.CategoryDto;
import com.ecommerce.ecommerce.dto.ProductDto;
import com.ecommerce.ecommerce.entities.Category;
import com.ecommerce.ecommerce.entities.CategoryStatus;
import com.ecommerce.ecommerce.entities.Product;
import com.ecommerce.ecommerce.entities.ProductStatus;
import com.ecommerce.ecommerce.exceptions.CategoryNotFoundException;
import com.ecommerce.ecommerce.exceptions.ProductNotFoundException;
import com.ecommerce.ecommerce.mapper.ProductMapper;
import com.ecommerce.ecommerce.repository.CategoryRepo;
import com.ecommerce.ecommerce.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductMapper productMapper ;

    @Autowired
    ProductRepo productRepo;
    @Autowired
    CategoryRepo categoryRepo;

    @Transactional(readOnly = true)
    public List<ProductDto> getAllProduct(){

        List<ProductDto> productDtoList =new ArrayList<>();
        for (Product c : productRepo.findAll() ) {
            ProductDto productDto = productMapper.toProductDto(c);
            productDtoList.add(productDto);
        }
        return productDtoList ;

    }

    @Transactional(readOnly = true)
    public List<ProductDto> getDeletedProduct(){

        List<ProductDto> productDtoList =new ArrayList<>();
        for (Product c : productRepo.findByStatus(ProductStatus.DELETED) ) {
            ProductDto productDto = productMapper.toProductDto(c);
            productDtoList.add(productDto);
        }
        return productDtoList ;

    }

    @Transactional
    public void addProduct( ProductDto productDto){
        Product product = productMapper.toProduct(productDto);
        productRepo.save(product);
    }

    @Transactional
    public void updateProduct( ProductDto productDto){
        Product product = productMapper.toProduct(productDto);
        productRepo.save(product);
    }


    @Transactional
    public void deleteProduct(int id){

        Optional<Product> byId = productRepo.findById(id);
        if( byId.isPresent()){
            Product product = byId.get();
            product.setStatus(ProductStatus.DELETED);
            productRepo.save(product);
        }else {
            throw new ProductNotFoundException("no Product with this id");
        }
    }
    public List<ProductDto> findProductsByCategory(int categoryId) {

        List<ProductDto> productDtoList =new ArrayList<>();
        Optional<Category> byId = categoryRepo.findById(categoryId);
        if (byId.isPresent()) {
            for (Product c : productRepo.findByCategory(byId.get().getId()) ) {
                ProductDto productDto = productMapper.toProductDto(c);
                productDtoList.add(productDto);
            }
        } else {
            throw new CategoryNotFoundException("no Category with this id");
        }
        return productDtoList;
    }



}
