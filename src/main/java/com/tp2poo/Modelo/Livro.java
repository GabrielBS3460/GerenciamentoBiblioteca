/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tp2poo.Modelo;
import java.util.ArrayList;
/**
 *
 * @author gabri
 */
public class Livro {
    private int id;
    private String titulo;
    private ArrayList<Autor> autor;
    private ArrayList<Categoria> categoria;

    public Livro(int id, String titulo, ArrayList<Autor> autor, ArrayList<Categoria> categoria) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<Autor> getAutor() {
        return autor;
    }

    public void setAutor(ArrayList<Autor> autor) {
        this.autor = autor;
    }

    public ArrayList<Categoria> getCategoria() {
        return categoria;
    }
    public void setCategoria(ArrayList<Categoria> categoria) {
        this.categoria = categoria;
    }
}