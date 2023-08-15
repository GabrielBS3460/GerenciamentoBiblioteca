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
public class DAOLivro implements DAOinterface<Livro> {
    @Override
    public void incluir(Livro obj) {
        Dados.listaLivros.add(obj);
    }

    @Override
    public Livro localizar(int id) {
        for (Livro l : Dados.listaLivros) {
            if (l.getId() == id) {
                return l;
            }
        }
        return null;
    }

    @Override
    public void atualizar(Livro obj) {
        for (int i = 0; i < Dados.listaLivros.size(); i++) {
            if (Dados.listaLivros.get(i).getId() == obj.getId()) {
                Dados.listaLivros.set(i, obj);
                break;
            }
        }
    }

    @Override
    public void remover(Livro obj) {
        Dados.listaLivros.remove(obj);
    }

    @Override
    public ArrayList<Livro> getLista() {
        return Dados.listaLivros;
    }
}
