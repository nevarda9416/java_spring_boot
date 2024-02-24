package com.example.niitiproduct.models;

import jakarta.persistence.*;

@Entity
@Table(name="roles", indexes={@Index(name="index_role_id", columnList="id")})
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;

    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role(String name) {
        super();
        this.name = name;
    }

    public Role() {
        // TODO Auto-generated constructor stub }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
