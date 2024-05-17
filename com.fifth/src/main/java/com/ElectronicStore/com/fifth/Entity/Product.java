package com.ElectronicStore.com.fifth.Entity;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.*;

import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String brand;
    private String category;
    private double price;
    @Column(columnDefinition = "TEXT")
    private String description;
    private Date createdDate;
    private String imageFileName;

}
