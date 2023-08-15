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
public class DAOCategoria implements DAOinterface<Categoria> {
    @Override
    public void incluir(Categoria obj) {
        Dados.listaCategoria.add(obj);
    }

    @Override
    public Categoria localizar(int id) {
        for (Categoria c : Dados.listaCategoria) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void atualizar(Categoria obj) {
        for (int i = 0; i < Dados.listaCategoria.size(); i++) {
            if (Dados.listaCategoria.get(i).getId() == obj.getId()) {
                Dados.listaCategoria.set(i, obj);
                break;
            }
        }
    }

    @Override
    public void remover(Categoria obj) {
        Dados.listaCategoria.remove(obj);
    }

    @Override
    public ArrayList<Categoria> getLista() {
        return Dados.listaCategoria;
    }
}   

