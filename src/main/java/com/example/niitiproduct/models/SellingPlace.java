package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="selling_places", indexes={@Index(name="index_selling_place_id", columnList="id")})
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
    @Column(name = "status")
    String status;
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

    public SellingPlace(Integer id, String name, String area, String city, String district, String sub_district, String address, String hotline, String created_at, String created_by, String updated_at, String updated_by, String deleted_at, String deleted_by) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.city = city;
        this.district = district;
        this.sub_district = sub_district;
        this.address = address;
        this.hotline = hotline;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.deleted_at = deleted_at;
        this.deleted_by = deleted_by;
    }
}
