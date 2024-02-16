package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products_promotions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductPromotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    Product product;
    @ManyToOne
    Promotion promotion;
}
