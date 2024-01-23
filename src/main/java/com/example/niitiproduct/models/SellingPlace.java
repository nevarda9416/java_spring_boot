package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="selling_places")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SellingPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "name")
    String s00_name;
    @Column(name = "area")
    String s01_area;
    @Column(name = "city")
    String s02_city;
    @Column(name = "district")
    String s03_district;
    @Column(name = "sub_district")
    String s04_sub_district;
    @Column(name = "address")
    String s05_address;
    @Column(name = "hotline")
    String s06_hotline;
    @Column(name = "created_at")
    String s07_created_at;
    @Column(name = "created_by")
    String s08_created_by;
    @Column(name = "updated_at")
    String s09_updated_at;
    @Column(name = "updated_by")
    String s10_updated_by;
    @Column(name = "deleted_at")
    String s11_deleted_at;
    @Column(name = "deleted_by")
    String s12_deleted_by;
}
