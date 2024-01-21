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
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    Integer customer_id;
    Integer order_id;
    Float order_value;
    String payment_method;
    String created_at;
    String created_by;
    String updated_at;
    String updated_by;
    String deleted_at;
    String deleted_by;
}
