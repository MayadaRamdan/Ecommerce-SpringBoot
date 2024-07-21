package com.ecommerce.ecommerce.entities;

import com.ecommerce.ecommerce.dto.CategoryDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name = "englishName")
    private String englishName ;
    @Column(name = "arabicName")
    private String arabicName ;
    @Column(name = "englishPath")
    private String englishPath ;
    @Column(name = "arabicPath")
    private String arabicPath ;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CategoryStatus status;

    @ManyToOne
    private Category parentCategory;



}
