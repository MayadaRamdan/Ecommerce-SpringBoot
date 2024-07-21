package com.ecommerce.ecommerce.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String englishName ;
    private String arabicName ;
    private int price ;
    private  int salePrice;
    @Enumerated(EnumType.STRING)
    private ProductStatus status;
    @ManyToOne
    @JoinColumn(name = "category_id" , referencedColumnName = "id")
    private Category productCategory;

}
