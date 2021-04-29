package com.example.lessgo.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserBean {

    @Column(name="users_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @org.springframework.data.annotation.Transient
    private long userId;
    @Column(name="id_session")
    private String idSession;
    private String pseudo;
    private String password;
    @Column(name="other_team")
    private Boolean otherTeam;
    private Double lat;
    private Double lon;
    private Long statuts_id;

    public UserBean() {
    }

    public UserBean(String idSession) {
        this.idSession = idSession;
    }

    public UserBean(long userId, String pseudo, Double lat, Double lon) {
        this.userId = userId;
        this.pseudo = pseudo;
        this.lat = lat;
        this.lon = lon;
    }

    public String getIdSession() {
        return idSession;
    }

    public void setIdSession(String idSession) {
        this.idSession = idSession;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long users_id) {
        this.userId = users_id;
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

    public Boolean getOtherTeam() {
        return otherTeam;
    }

    public void setOtherTeam(Boolean other_team) {
        this.otherTeam = other_team;
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

    public Long getStatuts_id() {
        return statuts_id;
    }

    public void setStatuts_id(Long statuts_id) {
        this.statuts_id = statuts_id;
    }
}
