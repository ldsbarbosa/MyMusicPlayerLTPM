package com.example.mymusicplayer;

import androidx.annotation.NonNull;

public class Musica {

    private String nome;
    private int id;

    public Musica(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    @Override
    public String toString() {
        return nome;
    }
}
