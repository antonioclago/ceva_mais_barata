package com.example.myapplication;

public class Cerveja {

        String nomeceva;
        Double mls, valor;

    public Cerveja(String nomeceva, String mls, String valor) {
        this.nomeceva = nomeceva;
        this.mls = Double.parseDouble(mls);
        this.valor = Double.parseDouble(valor);
    }
}
