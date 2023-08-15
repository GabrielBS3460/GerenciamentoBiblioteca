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
public class DAOEmprestimo implements DAOinterface<Emprestimo> {
    @Override
    public void incluir(Emprestimo obj) {
        Dados.listaEmprestimos.add(obj);
    }

    @Override
    public Emprestimo localizar(int id) {
        for (Emprestimo e : Dados.listaEmprestimos) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    @Override
    public void atualizar(Emprestimo obj) {
        for (int i = 0; i < Dados.listaEmprestimos.size(); i++) {
            if (Dados.listaEmprestimos.get(i).getId() == obj.getId()) {
                Dados.listaEmprestimos.set(i, obj);
                break;
            }
        }
    }

    @Override
    public void remover(Emprestimo obj) {
        Dados.listaEmprestimos.remove(obj);
    }

    @Override
    public ArrayList<Emprestimo> getLista() {
        return Dados.listaEmprestimos;
    }
}