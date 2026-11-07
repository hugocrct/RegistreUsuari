package com.example.registreusuari;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nom;
    private String cognom;
    private int edat;
    private boolean matriculat;

    public Persona(String nom, String cognom, int edat, boolean matriculat) {
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
        this.matriculat = matriculat;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public int getEdat() {
        return edat;
    }

    public boolean isMatriculat() {
        return matriculat;
    }
}