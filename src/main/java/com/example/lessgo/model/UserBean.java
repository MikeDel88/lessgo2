package com.example.lessgo.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserBean {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long users_id;
    private String pseudo;
    private String password;
    private Boolean other_team;
    private Double lat;
    private Double lon;
    private long statuts_id;
}
