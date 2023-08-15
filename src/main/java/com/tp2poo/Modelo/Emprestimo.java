/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tp2poo.Modelo;
import java.util.Date;
/**
 *
 * @author gabri
 */
public class Emprestimo {
    private int id;
    private int idFuncionario;
    private int idUsuario;
    private int idLivro;
    private Date dataEmprestimo = new Date();

    public Emprestimo(int id, int idFuncionario, int idUsuario, int idLivro, Date dataEmprestimo) {
        this.id = id;
        this.idFuncionario = idFuncionario;
        this.idUsuario = idUsuario;
        this.idLivro = idLivro;
        this.dataEmprestimo = dataEmprestimo;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }
    
    public Date getDataEmprestimo (){
        return dataEmprestimo;
    }
    
    public void setDataEmprestimo(Date dataEmprestimo){
        this.dataEmprestimo = dataEmprestimo;
    }
}
