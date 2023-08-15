/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tp2poo.DAO;
import java.util.ArrayList;
/**
 *
 * @author gabri
 */
public interface DAOinterface<T> {
    public void incluir(T obj);
    public T localizar(int id);
    public void atualizar(T obj);
    public void remover(T obj);
    public ArrayList<T> getLista();
}
