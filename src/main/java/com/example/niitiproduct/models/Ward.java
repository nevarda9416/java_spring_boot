package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="wards", indexes={@Index(name="index_ward_code", columnList="code")})
@NoArgsConstructor
@Getter
@Setter
public class Ward {
    @Id
    @Column(name = "code")
    String code;
    @Column(name = "name")
    String name;
    @Column(name = "name_en")
    String name_en;
    @Column(name = "full_name")
    String full_name;
    @Column(name = "full_name_en")
    String full_name_en;
    @Column(name = "code_name")
    String code_name;
    @Column(name = "district_code")
    String district_code;
    @Column(name = "administrative_unit_id")
    Integer administrative_unit_id;
}

