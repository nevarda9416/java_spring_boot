package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="warranties", indexes={@Index(name="index_warranty_id", columnList="id,customer_id,order_id,product_id")})
@NoArgsConstructor
@Getter
@Setter
public class Warranty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "customer_id")
    Integer customer_id;
    @Column(name = "order_id")
    Integer order_id;
    @Column(name = "product_id")
    Integer product_id;
    @Column(name = "period")
    String period;
    @Column(name = "description")
    String description;
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

    public Warranty(Integer id, Integer customer_id, Integer order_id, Integer product_id, String period, String description, String created_at, String created_by, String updated_at, String updated_by, String deleted_at, String deleted_by) {
        this.id = id;
        this.customer_id = customer_id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.period = period;
        this.description = description;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.deleted_at = deleted_at;
        this.deleted_by = deleted_by;
    }
}
