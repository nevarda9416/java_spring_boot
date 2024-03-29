package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="products_promotions", indexes={@Index(name="index_product_promotion_id", columnList="id,product_id,promotion_id")})
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

    public ProductPromotion(Long id, Product product, Promotion promotion) {
        this.id = id;
        this.product = product;
        this.promotion = promotion;
    }
}
