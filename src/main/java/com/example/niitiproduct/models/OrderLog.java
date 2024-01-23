package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="order_logs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "customer_id")
    Integer o00_customer_id;
    @Column(name = "order_id")
    Integer o01_order_id;
    @Column(name = "order_value")
    Float o02_order_value;
    @Column(name = "payment_method")
    String o03_payment_method;
    @Column(name = "created_at")
    String o04_created_at;
    @Column(name = "created_by")
    String o05_created_by;
    @Column(name = "updated_at")
    String o06_updated_at;
    @Column(name = "updated_by")
    String o07_updated_by;
    @Column(name = "deleted_at")
    String o08_deleted_at;
    @Column(name = "deleted_by")
    String o09_deleted_by;
}
