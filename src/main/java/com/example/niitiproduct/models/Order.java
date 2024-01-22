package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer user_id;
    Float total_price;
    Integer total_amount;
    Float total_tax;
    String status;
    String created_at;
    String created_by;
    String updated_at;
    String updated_by;
    String deleted_at;
    String deleted_by;
}
