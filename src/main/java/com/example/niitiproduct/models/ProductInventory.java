package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="product_inventories", indexes={@Index(name="index_inventory_id", columnList="id,product_detail_id,inventory_id,selling_place_id")})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "product_detail_id")
    Integer product_detail_id;
    @Column(name = "inventory_id")
    Integer inventory_id;
    @Column(name = "quantity_inventory")
    Integer quantity_inventory;
    @Column(name = "selling_place_id")
    Integer selling_place_id;
    @Column(name = "quantity_selling_place")
    Integer quantity_selling_place;
    @Column(name = "created_at")
    String created_at;
    @Column(name = "created_by")
    String created_by;
    @Column(name = "updated_at")
    String updated_at;
    @Column(name = "updated_by")
    String updated_by;
    @Column(name = "deleted_at")
    String deleted_at;
    @Column(name = "deleted_by")
    String deleted_by;
}
