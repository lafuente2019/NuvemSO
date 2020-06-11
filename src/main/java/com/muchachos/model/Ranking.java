/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muchachos.model;

/**
 *
 * @author Fabio Vieira
 */
public class Ranking {
    private int numVendas;
    private String nome;
    private String filial;

    public Ranking() {
    }

    public int getNumVendas() {
        return numVendas;
    }

    public void setNumVendas(int numVendas) {
        this.numVendas = numVendas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

    public Ranking(int numVendas, String nome, String filial) {
        this.numVendas = numVendas;
        this.nome = nome;
        this.filial = filial;
    }
    
}
