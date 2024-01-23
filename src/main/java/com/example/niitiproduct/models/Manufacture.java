package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="manufactures")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Manufacture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "name")
    String m00_name;
    @Column(name = "description")
    String m01_description;
    @Column(name = "created_at")
    String m02_created_at;
    @Column(name = "created_by")
    String m03_created_by;
    @Column(name = "updated_at")
    String m04_updated_at;
    @Column(name = "updated_by")
    String m05_updated_by;
    @Column(name = "deleted_at")
    String m06_deleted_at;
    @Column(name = "deleted_by")
    String m07_deleted_by;
}
