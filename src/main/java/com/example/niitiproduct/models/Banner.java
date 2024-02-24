package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="banners", indexes={@Index(name="index_banner_id", columnList="id")})
@NoArgsConstructor
@Getter
@Setter
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "name")
    String name;
    @Column(name = "description")
    String description;
    @Column(name = "thumbnail_url")
    String thumbnail_url;
    @Column(name = "banner_url")
    String banner_url;
    @Column(name = "is_default")
    Integer is_default;
    @Column(name = "is_actived")
    Integer is_actived;
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

    public Banner(Integer id, String name, String description, String thumbnail_url, String banner_url, Integer is_default, Integer is_actived, String created_at, String created_by, String updated_at, String updated_by, String deleted_at, String deleted_by) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.thumbnail_url = thumbnail_url;
        this.banner_url = banner_url;
        this.is_default = is_default;
        this.is_actived = is_actived;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.deleted_at = deleted_at;
        this.deleted_by = deleted_by;
    }
}
