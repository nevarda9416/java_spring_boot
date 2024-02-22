package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="customers")
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "email")
    String email;
    @Column(name = "password")
    String password;
    @Column(name = "is_actived")
    Integer is_actived;
    @Column(name = "first_name")
    String first_name;
    @Column(name = "last_name")
    String last_name;
    @Column(name = "birthday")
    String birthday;
    @Column(name = "gender")
    String gender;
    @Column(name = "telephone")
    String telephone;
    @Column(name = "address")
    String address;
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

    public Customer(Integer id, String email, String password, Integer is_actived, String first_name, String last_name, String birthday, String gender, String telephone, String address, String created_at, String created_by, String updated_at, String updated_by, String deleted_at, String deleted_by) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.is_actived = is_actived;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birthday = birthday;
        this.gender = gender;
        this.telephone = telephone;
        this.address = address;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.deleted_at = deleted_at;
        this.deleted_by = deleted_by;
    }
}
