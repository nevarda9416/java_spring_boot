package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "name")
    String a_name;
    @Column(name = "image")
    String b_image;
    @Column(name = "summary")
    String c_summary;
    @Column(name = "description")
    String d_description;
    @Column(name = "display_order")
    Integer e_display_order;
    @Column(name = "is_actived")
    Integer f_is_actived;
    @Column(name = "created_at")
    String g_created_at;
    @Column(name = "created_by")
    String h_created_by;
    @Column(name = "updated_at")
    String i_updated_at;
    @Column(name = "updated_by")
    String j_updated_by;
    @Column(name = "deleted_at")
    String k_deleted_at;
    @Column(name = "deleted_by")
    String l_deleted_by;
}
