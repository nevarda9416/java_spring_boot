package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="banners")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "name")
    String b00_name;
    @Column(name = "description")
    String b01_description;
    @Column(name = "thumbnail_url")
    String b02_thumbnail_url;
    @Column(name = "banner_url")
    String b03_banner_url;
    @Column(name = "is_default")
    Integer b04_is_default;
    @Column(name = "is_actived")
    Integer b05_is_actived;
    @Column(name = "created_at")
    String b06_created_at;
    @Column(name = "created_by")
    String b07_created_by;
    @Column(name = "updated_at")
    String b08_updated_at;
    @Column(name = "updated_by")
    String b09_updated_by;
    @Column(name = "deleted_at")
    String b10_deleted_at;
    @Column(name = "deleted_by")
    String b11_deleted_by;
}
