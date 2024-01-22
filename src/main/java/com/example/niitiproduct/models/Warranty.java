package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="warranties")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Warranty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer customer_id;
    Integer order_id;
    Integer product_id;
    String period;
    String description;
    String created_at;
    String created_by;
    String updated_at;
    String updated_by;
    String deleted_at;
    String deleted_by;
}
