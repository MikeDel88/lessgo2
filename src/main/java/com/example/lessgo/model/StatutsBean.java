package com.example.lessgo.model;

import javax.persistence.*;

@Entity
@Table(name = "statuts")
public class StatutsBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long statuts_id;
    private String nom;
}
