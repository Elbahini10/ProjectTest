package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "employe")
@Getter @Setter @Data
public class employe {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prenom;

    private String nom;

    private String cin;

    private byte age;

    private Date dataNaissance;

    private String phone;

    private String email;

}
