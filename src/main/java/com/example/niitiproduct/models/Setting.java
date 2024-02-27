package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="settings", indexes={@Index(name="index_setting_id", columnList="id")})
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

    public Setting(Integer id, String company_contact, String telephone_contact, String fax_contact, String website_name, String website_contact, String email_contact, String address_contact, String link_google_map, String timer_support, String logo_header_company, String logo_company, String copyright_left, String copyright_right, String facebook, String youtube, String instagram, String twitter, String google, String tiktok, String slogan_register, String meta_title, String meta_keyword, String meta_description, String meta_image, String created_at, String created_by, String updated_at, String updated_by, String deleted_at, String deleted_by) {
        this.id = id;
        this.company_contact = company_contact;
        this.telephone_contact = telephone_contact;
        this.fax_contact = fax_contact;
        this.website_name = website_name;
        this.website_contact = website_contact;
        this.email_contact = email_contact;
        this.address_contact = address_contact;
        this.link_google_map = link_google_map;
        this.timer_support = timer_support;
        this.logo_header_company = logo_header_company;
        this.logo_company = logo_company;
        this.copyright_left = copyright_left;
        this.copyright_right = copyright_right;
        this.facebook = facebook;
        this.youtube = youtube;
        this.instagram = instagram;
        this.twitter = twitter;
        this.google = google;
        this.tiktok = tiktok;
        this.slogan_register = slogan_register;
        this.meta_title = meta_title;
        this.meta_keyword = meta_keyword;
        this.meta_description = meta_description;
        this.meta_image = meta_image;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.deleted_at = deleted_at;
        this.deleted_by = deleted_by;
    }
}
