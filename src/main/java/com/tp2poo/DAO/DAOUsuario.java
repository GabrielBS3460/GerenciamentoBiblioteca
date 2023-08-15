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
public class DAOUsuario implements DAOinterface<Usuario> {
        @Override
    public void incluir(Usuario obj) {
        Dados.listaUsuarios.add(obj);
    }

    @Override
    public Usuario localizar(int id) {
        for (Usuario u : Dados.listaUsuarios) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    @Override
    public void atualizar(Usuario obj) {
        for (int i = 0; i < Dados.listaUsuarios.size(); i++) {
            if (Dados.listaUsuarios.get(i).getId() == obj.getId()) {
                Dados.listaUsuarios.set(i, obj);
                break;
            }
        }
    }

    @Override
    public void remover(Usuario obj) {
        Dados.listaUsuarios.remove(obj);
    }

    @Override
    public ArrayList<Usuario> getLista() {
        return Dados.listaUsuarios;
    }
}

