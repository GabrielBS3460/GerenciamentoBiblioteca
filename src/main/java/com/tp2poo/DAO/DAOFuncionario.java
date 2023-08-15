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
public class DAOFuncionario implements DAOinterface<Funcionario> {
    @Override
    public void incluir(Funcionario obj) {
        Dados.listaFuncionarios.add(obj);
    }

    @Override
    public Funcionario localizar(int id) {
        for (Funcionario f : Dados.listaFuncionarios) {
            if (f.getId() == id) {
                return f;
            }
        }
        return null;
    }

    @Override
    public void atualizar(Funcionario obj) {
        for (int i = 0; i < Dados.listaFuncionarios.size(); i++) {
            if (Dados.listaFuncionarios.get(i).getId() == obj.getId()) {
                Dados.listaFuncionarios.set(i, obj);
                break;
            }
        }
    }

    @Override
    public void remover(Funcionario obj) {
        Dados.listaFuncionarios.remove(obj);
    }

    @Override
    public ArrayList<Funcionario> getLista() {
        return Dados.listaFuncionarios;
    }
} 
    