package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String email;
    String password;
    Integer is_actived;
    String first_name;
    String last_name;
    String birthday;
    String gender;
    String telephone;
    String address;
    String created_at;
    String created_by;
    String updated_at;
    String updated_by;
    String deleted_at;
    String deleted_by;
}
