package com.example.niitiproduct.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "name")
    String u00_name;
    @Column(name = "email")
    String u01_email;
    @Column(name = "email_verified_at")
    String u02_email_verified_at;
    @Getter
    @Column(name = "password")
    String u03_password;
    @Column(name = "remember_token")
    String u04_remember_token;
    @Column(name = "created_at")
    String u05_created_at;
    @Column(name = "created_by")
    String u06_created_by;
    @Column(name = "updated_at")
    String u07_updated_at;
    @Column(name = "updated_by")
    String u08_updated_by;
    @Column(name = "deleted_at")
    String u09_deleted_at;
    @Column(name = "deleted_by")
    String u10_deleted_by;
    @Getter
    @ManyToMany
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public User() {

    }

    public User(String email, String password, Collection<Role> roles) {
        this.u01_email = email;
        this.u03_password = password;
        this.roles = roles;
    }

    public void setPassword(String password) {
        this.u03_password = password;
    }

}
