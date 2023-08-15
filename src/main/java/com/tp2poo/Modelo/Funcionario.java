/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tp2poo.Modelo;

/**
 *
 * @author gabri
 */
public class Funcionario extends Pessoa {
    private int matricula;
    private String login;
    private String senha;
    
    public Funcionario(int id, String nome, String sobrenome, int matricula) {
        super(id, nome, sobrenome);
        this.matricula = matricula;
    }

    public Funcionario(int id, String nome, String sobrenome, int matricula, String login, String senha) {
        super(id, nome, sobrenome);
        this.matricula = matricula;
        this.login = login;
        this.senha = senha;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

