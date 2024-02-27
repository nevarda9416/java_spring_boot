package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="product_inventories", indexes={@Index(name="index_inventory_id", columnList="id,product_detail_id,inventory_id,selling_place_id")})
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

    public ProductInventory(Integer id, Integer product_detail_id, Integer inventory_id, Integer quantity_inventory, Integer selling_place_id, Integer quantity_selling_place, String created_at, String created_by, String updated_at, String updated_by, String deleted_at, String deleted_by) {
        this.id = id;
        this.product_detail_id = product_detail_id;
        this.inventory_id = inventory_id;
        this.quantity_inventory = quantity_inventory;
        this.selling_place_id = selling_place_id;
        this.quantity_selling_place = quantity_selling_place;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.deleted_at = deleted_at;
        this.deleted_by = deleted_by;
    }
}
