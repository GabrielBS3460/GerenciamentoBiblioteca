/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tp2poo.Modelo;

/**
 *
 * @author gabri
 */
public class Usuario extends Pessoa {
    private int registroAcademico;

    public Usuario(int id, String nome, String sobrenome, int registroAcademico) {
        super(id, nome, sobrenome);
        this.registroAcademico = registroAcademico;
    }

    public int getRegistroAcademico() {
        return registroAcademico;
    }

    public void setRegistroAcademico(int registroAcademico) {
        this.registroAcademico = registroAcademico;
    }
}
