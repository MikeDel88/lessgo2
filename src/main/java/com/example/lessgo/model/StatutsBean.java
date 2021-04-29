package com.example.lessgo.model;

//@Entity
//@Table(name = "statuts")
public class StatutsBean {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long statuts_id;
    private String nom;

    public long getStatuts_id() {
        return statuts_id;
    }

    public void setStatuts_id(long statuts_id) {
        this.statuts_id = statuts_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
