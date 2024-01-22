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
    String name;
    String area;
    String city;
    String district;
    String sub_district;
    String address;
    String hotline;
    String created_at;
    String created_by;
    String updated_at;
    String updated_by;
    String deleted_at;
    String deleted_by;
}
