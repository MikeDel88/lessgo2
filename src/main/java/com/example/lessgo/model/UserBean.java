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

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getOther_team() {
        return other_team;
    }

    public void setOther_team(Boolean other_team) {
        this.other_team = other_team;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public long getStatuts_id() {
        return statuts_id;
    }

    public void setStatuts_id(long statuts_id) {
        this.statuts_id = statuts_id;
    }
}
