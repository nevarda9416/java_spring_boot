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
    @Column(name = "email")
    String c00_email;
    @Column(name = "password")
    String c01_password;
    @Column(name = "is_actived")
    Integer c02_is_actived;
    @Column(name = "first_name")
    String c03_first_name;
    @Column(name = "last_name")
    String c04_last_name;
    @Column(name = "birthday")
    String c05_birthday;
    @Column(name = "gender")
    String c06_gender;
    @Column(name = "telephone")
    String c07_telephone;
    @Column(name = "address")
    String c08_address;
    @Column(name = "created_at")
    String c09_created_at;
    @Column(name = "created_by")
    String c10_created_by;
    @Column(name = "updated_at")
    String c11_updated_at;
    @Column(name = "updated_by")
    String c12_updated_by;
    @Column(name = "deleted_at")
    String c13_deleted_at;
    @Column(name = "deleted_by")
    String c14_deleted_by;
}
