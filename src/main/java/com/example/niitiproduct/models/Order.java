package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="orders", indexes={@Index(name="index_order_id", columnList="id")})
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

    public Order(Integer id, String code, Float total_price, Integer total_amount, Float total_tax, String status, Float accounts_receivable, String created_at, String created_by, String updated_at, String updated_by, String deleted_at, String deleted_by) {
        this.id = id;
        this.code = code;
        this.total_price = total_price;
        this.total_amount = total_amount;
        this.total_tax = total_tax;
        this.status = status;
        this.accounts_receivable = accounts_receivable;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.deleted_at = deleted_at;
        this.deleted_by = deleted_by;
    }
}
