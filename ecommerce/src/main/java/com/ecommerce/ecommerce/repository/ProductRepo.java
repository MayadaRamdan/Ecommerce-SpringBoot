package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.entities.Category;
import com.ecommerce.ecommerce.entities.CategoryStatus;
import com.ecommerce.ecommerce.entities.Product;
import com.ecommerce.ecommerce.entities.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product , Integer> {

    @Query(value = "select c from Product c where c.status = :s")
    List<Product> findByStatus(ProductStatus s);

    @Query(value = "select p from  Product p where p.productCategory.id = :id")
    List<Product> findByCategory( int id);


}
