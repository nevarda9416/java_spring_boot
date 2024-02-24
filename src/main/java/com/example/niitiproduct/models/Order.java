package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="orders", indexes={@Index(name="index_order_id", columnList="id")})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "code")
    String code;
    @Column(name = "total_price")
    Float total_price;
    @Column(name = "total_amount")
    Integer total_amount;
    @Column(name = "total_tax")
    Float total_tax;
    @Column(name = "status")
    String status;
    @Column(name = "accounts_receivable")
    Float accounts_receivable;
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
