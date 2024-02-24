package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="settings", indexes={@Index(name="index_setting_id", columnList="id")})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Setting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "company_contact")
    String company_contact;
    @Column(name = "telephone_contact")
    String telephone_contact;
    @Column(name = "fax_contact")
    String fax_contact;
    @Column(name = "website_name")
    String website_name;
    @Column(name = "website_contact")
    String website_contact;
    @Column(name = "email_contact")
    String email_contact;
    @Column(name = "address_contact")
    String address_contact;
    @Column(name = "link_google_map")
    String link_google_map;
    @Column(name = "timer_support")
    String timer_support;
    @Column(name = "logo_header_company")
    String logo_header_company;
    @Column(name = "logo_company")
    String logo_company;
    @Column(name = "copyright_left")
    String copyright_left;
    @Column(name = "copyright_right")
    String copyright_right;
    @Column(name = "facebook")
    String facebook;
    @Column(name = "youtube")
    String youtube;
    @Column(name = "instagram")
    String instagram;
    @Column(name = "twitter")
    String twitter;
    @Column(name = "google")
    String google;
    @Column(name = "tiktok")
    String tiktok;
    @Column(name = "slogan_register")
    String slogan_register;
    @Column(name = "meta_title")
    String meta_title;
    @Column(name = "meta_keyword")
    String meta_keyword;
    @Column(name = "meta_description")
    String meta_description;
    @Column(name = "meta_image")
    String meta_image;
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
