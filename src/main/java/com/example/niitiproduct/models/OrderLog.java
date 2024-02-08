package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Entity
@Table(name="order_logs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@RedisHash(value = "OrderLog")
public class OrderLog {
    @Id
    @Indexed
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "customer_id")
    Integer customer_id;
    @Column(name = "order_id")
    Integer order_id;
    @Column(name = "order_value")
    Float order_value;
    @Column(name = "payment_method")
    String payment_method;
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
