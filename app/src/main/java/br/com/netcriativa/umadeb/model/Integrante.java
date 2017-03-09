package br.com.netcriativa.umadeb.model;

import java.io.Serializable;

public class Integrante implements Serializable {
    public String nome;
    public String endereco;
    public float estrelas;

    public Integrante(String nome, String endereco, float estrelas) {
        this.nome = nome;
        this.endereco = endereco;
        this.estrelas = estrelas;
    }

    @Override
    public String toString() {
        return nome;
    }
}
