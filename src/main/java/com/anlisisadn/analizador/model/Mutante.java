package com.anlisisadn.analizador.model;

import javax.persistence.*;

@Entity
@Table(name = "dna")
public class Mutante {
    private int id;
    private String dna;
    private int esMutante;

    public Mutante() {
    }

    public Mutante(int id, String dna, int esMutante) {
        this.id= id;
        this.esMutante = esMutante;
        this.dna = dna;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDna() {
        return dna;
    }

    public void setDna(String dna) {
        this.dna = dna;
    }

    public int getEsMutante() {
        return esMutante;
    }

    public void setEsMutante(int esMutante) {
        this.esMutante = esMutante;
    }
}
