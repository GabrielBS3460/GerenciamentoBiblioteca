/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tp2poo.Modelo;

/**
 *
 * @author gabri
 */
public class Autor extends Pessoa {
    private String biografia;

    public Autor(int id, String nome, String sobrenome, String biografia) {
        super(id, nome, sobrenome);
        this.biografia = biografia;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
}
