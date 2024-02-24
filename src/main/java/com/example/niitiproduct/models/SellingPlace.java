package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="selling_places", indexes={@Index(name="index_selling_place_id", columnList="id")})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SellingPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "name")
    String name;
    @Column(name = "area")
    String area;
    @Column(name = "city")
    String city;
    @Column(name = "district")
    String district;
    @Column(name = "sub_district")
    String sub_district;
    @Column(name = "address")
    String address;
    @Column(name = "hotline")
    String hotline;
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
