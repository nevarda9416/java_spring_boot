package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="subscribers", indexes={@Index(name="index_subscriber_id", columnList="id")})
@NoArgsConstructor
@Getter
@Setter
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "email")
    String email;
    @Column(name = "token")
    String token;
    @Column(name = "status")
    String status;
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

    public Subscriber(Integer id, String email, String token, String status, String created_at, String created_by, String updated_at, String updated_by, String deleted_at, String deleted_by) {
        this.id = id;
        this.email = email;
        this.token = token;
        this.status = status;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.deleted_at = deleted_at;
        this.deleted_by = deleted_by;
    }
}
