package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.entities.Category;
import com.ecommerce.ecommerce.entities.CategoryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category ,Integer> {

     @Query(value = "select c from Category c where c.status = :s")
     List<Category> findByStatus(CategoryStatus s);

     @Query(value = "select c from Category c where c.status <> 'DELETED'")
     List<Category> findNotDeleted();

     List<Category> findByStatusIn( List<CategoryStatus> statuses);


}
