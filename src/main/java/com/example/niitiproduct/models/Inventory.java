package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="inventories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "name")
    String i00_name;
    @Column(name = "address")
    String i01_address;
    @Column(name = "created_at")
    String i02_created_at;
    @Column(name = "created_by")
    String i03_created_by;
    @Column(name = "updated_at")
    String i04_updated_at;
    @Column(name = "updated_by")
    String i05_updated_by;
    @Column(name = "deleted_at")
    String i06_deleted_at;
    @Column(name = "deleted_by")
    String i07_deleted_by;
}
