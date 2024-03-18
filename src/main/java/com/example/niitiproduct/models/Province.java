package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

@Entity
@Table(name="provinces", indexes={@Index(name="index_province_code", columnList="code")})
@NoArgsConstructor
@Getter
@Setter
public class Province {
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
    @Column(name = "administrative_unit_id ")
    Integer administrative_unit_id;
    @Column(name = "administrative_region_id  ")
    Integer administrative_region_id ;
}
