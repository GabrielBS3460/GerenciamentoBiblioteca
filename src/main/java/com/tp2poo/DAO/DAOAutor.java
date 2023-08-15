/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tp2poo.DAO;
import com.tp2poo.Modelo.*;
import com.tp2poo.Dadoss.*;
import java.util.ArrayList;
/**
 *
 * @author gabri
 */
public class DAOAutor implements DAOinterface<Autor> {
    @Override
    public void incluir(Autor obj) {
        Dados.listaAutores.add(obj);
    }

    @Override
    public Autor localizar(int id) {
        for (Autor a : Dados.listaAutores) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    @Override
    public void atualizar(Autor obj) {
        for (int i = 0; i < Dados.listaAutores.size(); i++) {
            if (Dados.listaAutores.get(i).getId() == obj.getId()) {
                Dados.listaAutores.set(i, obj);
                break;
            }
        }
    }

    @Override
    public void remover(Autor obj) {
        Dados.listaAutores.remove(obj);
    }

    @Override
    public ArrayList<Autor> getLista() {
        return Dados.listaAutores;
    }
}
