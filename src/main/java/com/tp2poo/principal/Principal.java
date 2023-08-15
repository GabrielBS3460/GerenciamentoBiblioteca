/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tp2poo.principal;

/**
 *
 * @author gabri
 */
import com.tp2poo.Modelo.*;
import com.tp2poo.DAO.*;
import com.tp2poo.Dadoss.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.net.URL;

public class Principal extends JFrame {
    private DAOUsuario daoUsuario = new DAOUsuario();
    private DAOLivro daoLivro = new DAOLivro();
    private DAOFuncionario daoFuncionario = new DAOFuncionario();
    private DAOEmprestimo daoEmprestimo = new DAOEmprestimo();
    private DAOCategoria daoCategoria = new DAOCategoria();
    private DAOAutor daoAutor = new DAOAutor();
    private char opcaoGerenciamentoSelecionada;
    
    private JTable tableGerenciamento;
    private DefaultTableModel tableModelGerenciamento;

    public Principal() {
        super("Biblioteca");

        opcaoGerenciamentoSelecionada = 'n';
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuCadastro = new JMenu("Cadastro");
        menuBar.add(menuCadastro);

        //Cria o Item no menu para cadastrar os Funcionários
        JMenuItem menuItemCadastrarFuncionario = new JMenuItem("Cadastrar Funcionário");
        menuItemCadastrarFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panelLogin = new JPanel(new GridLayout(0, 1));
                JTextField txtUsuario = new JTextField();
                //Solicita o login do admin para cadastrar
                panelLogin.add(new JLabel("Usuário:"));
                panelLogin.add(txtUsuario);
                JPasswordField txtSenha = new JPasswordField();
                panelLogin.add(new JLabel("Senha:"));
                panelLogin.add(txtSenha);
                int resultLogin = JOptionPane.showConfirmDialog(null, panelLogin, "Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (resultLogin == JOptionPane.OK_OPTION) {
                    String usuario = txtUsuario.getText();
                    String senha = new String(txtSenha.getPassword());
                    Login login = new Login(usuario, senha);
                    //Cria o painel para inserir as informações do Funcionário
                    if (verificarLogin(login)) {
                        JPanel panelCadastro = new JPanel(new GridLayout(0, 1));
                        JTextField txtIdFuncionario = new JTextField();
                        panelCadastro.add(new JLabel("ID do Funcionário:"));
                        panelCadastro.add(txtIdFuncionario);
                        JTextField txtNomeFuncionario = new JTextField();
                        panelCadastro.add(new JLabel("Nome do Funcionário:"));
                        panelCadastro.add(txtNomeFuncionario);
                        JTextField txtSobrenomeFuncionario = new JTextField();
                        panelCadastro.add(new JLabel("Sobrenome do Funcionário:"));
                        panelCadastro.add(txtSobrenomeFuncionario);
                        JTextField txtMatriculaFuncionario = new JTextField();
                        panelCadastro.add(new JLabel("Matrícula do Funcionário:"));
                        panelCadastro.add(txtMatriculaFuncionario);
                        JTextField txtLoginFuncionario = new JTextField();
                        panelCadastro.add(new JLabel("Login do Funcionário:"));
                        panelCadastro.add(txtLoginFuncionario);
                        JPasswordField txtSenhaFuncionario = new JPasswordField();
                        panelCadastro.add(new JLabel("Senha do Funcionário:"));
                        panelCadastro.add(txtSenhaFuncionario);
                        int resultCadastro = JOptionPane.showConfirmDialog(null, panelCadastro, "Cadastrar Funcionário", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                        if (resultCadastro == JOptionPane.OK_OPTION) {
                            int idFuncionario = Integer.parseInt(txtIdFuncionario.getText());
                            String nomeFuncionario = txtNomeFuncionario.getText();
                            String sobrenomeFuncionario = txtSobrenomeFuncionario.getText();
                            int matriculaFuncionario = Integer.parseInt(txtMatriculaFuncionario.getText());
                            String loginFuncionario = txtLoginFuncionario.getText();
                            String senhaFuncionario = new String(txtSenhaFuncionario.getPassword());
                            Funcionario funcionario = new Funcionario(idFuncionario, nomeFuncionario, sobrenomeFuncionario, matriculaFuncionario, loginFuncionario, senhaFuncionario);
                            daoFuncionario.incluir(funcionario);
                            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!");
                    }
                }
            }
        });
        menuCadastro.add(menuItemCadastrarFuncionario);


        //Cria o item no menu para cadastrar um usuário
        JMenuItem menuItemCadastrarUsuario = new JMenuItem("Cadastrar Usuário");
        menuItemCadastrarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Cria o painel para inserir as informações do usuário
                JPanel panel = new JPanel(new GridLayout(0, 1));
                JTextField txtIdUsuario = new JTextField();
                panel.add(new JLabel("ID do Usuário:"));
                panel.add(txtIdUsuario);
                JTextField txtNomeUsuario = new JTextField();
                panel.add(new JLabel("Nome do Usuário:"));
                panel.add(txtNomeUsuario);
                JTextField txtSobrenomeUsuario = new JTextField();
                panel.add(new JLabel("Sobrenome do Usuário:"));
                panel.add(txtSobrenomeUsuario);
                JTextField txtRegistroAcademicoUsuario = new JTextField();
                panel.add(new JLabel("Registro Acadêmico do Usuário:"));
                panel.add(txtRegistroAcademicoUsuario);
                int result = JOptionPane.showConfirmDialog(null, panel, "Cadastrar Usuário", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    int idUsuario = Integer.parseInt(txtIdUsuario.getText());
                    String nomeUsuario = txtNomeUsuario.getText();
                    String sobrenomeUsuario = txtSobrenomeUsuario.getText();
                    int registroAcademicoUsuario = Integer.parseInt(txtRegistroAcademicoUsuario.getText());
                    Usuario usuario = new Usuario(idUsuario, nomeUsuario, sobrenomeUsuario, registroAcademicoUsuario);
                    daoUsuario.incluir(usuario);
                    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                }
            }
        });
        menuCadastro.add(menuItemCadastrarUsuario);
        
        //Cria o item no menu para cadastrar um livro
        JMenuItem menuItemCadastrarLivro = new JMenuItem("Cadastrar Livro");
        menuItemCadastrarLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Cria o painel para inserir as informações do livro
                JPanel panel = new JPanel(new GridLayout(0, 1));
                JTextField txtIdLivro = new JTextField();
                panel.add(new JLabel("ID do Livro:"));
                panel.add(txtIdLivro);
                JTextField txtTituloLivro = new JTextField();
                panel.add(new JLabel("Título do Livro:"));
                panel.add(txtTituloLivro);
                JTextArea txtAutoresLivro = new JTextArea(1, 20);
                JScrollPane scrollPaneAutoresLivro = new JScrollPane(txtAutoresLivro);
                panel.add(new JLabel("IDs dos Autores (separados por vírgula):"));
                panel.add(scrollPaneAutoresLivro);
                JTextArea txtCategoriasLivro = new JTextArea(1, 20);
                JScrollPane scrollPaneCategoriasLivro = new JScrollPane(txtCategoriasLivro);
                panel.add(new JLabel("IDs das Categorias (separadas por vírgula):"));
                panel.add(scrollPaneCategoriasLivro);
                int result = JOptionPane.showConfirmDialog(null, panel, "Cadastrar Livro", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    int idLivro = Integer.parseInt(txtIdLivro.getText());
                    String tituloLivro = txtTituloLivro.getText();
                    String[] idsAutores = txtAutoresLivro.getText().split(",");
                    ArrayList<Autor> autoresLivro = new ArrayList<>();
                    //Aqui ele está procurando pelo Autor ou Autores do livro para inserir
                    for (String idAutor : idsAutores) {
                        Autor autor = daoAutor.localizar(Integer.parseInt(idAutor.trim()));
                        if (autor != null) {
                            autoresLivro.add(autor);
                        }
                    }
                    String[] idsCategorias = txtCategoriasLivro.getText().split(",");
                    ArrayList<Categoria> categoriasLivro = new ArrayList<>();
                    for (String idCategoria : idsCategorias) {
                        Categoria categoria = daoCategoria.localizar(Integer.parseInt(idCategoria.trim()));
                        if (categoria != null) {
                            categoriasLivro.add(categoria);
                        }
                    }
                    Livro livro = new Livro(idLivro, tituloLivro, autoresLivro, categoriasLivro);
                    daoLivro.incluir(livro);
                    JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
                }
            }
        });
        menuCadastro.add(menuItemCadastrarLivro);

        //Cria o item no menu para cadastar um Emprestimo
        JMenuItem menuItemCadastrarEmprestimo = new JMenuItem("Cadastrar Empréstimo");
        menuItemCadastrarEmprestimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Somente Funcionários podem cadastrar emprestimos
                JPanel panelLogin = new JPanel(new GridLayout(0, 1));
                JTextField txtUsuario = new JTextField();
                panelLogin.add(new JLabel("Usuário:"));
                panelLogin.add(txtUsuario);
                JPasswordField txtSenha = new JPasswordField();
                panelLogin.add(new JLabel("Senha:"));
                panelLogin.add(txtSenha);
                int resultLogin = JOptionPane.showConfirmDialog(null, panelLogin, "Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (resultLogin == JOptionPane.OK_OPTION) {
                    String usuario = txtUsuario.getText();
                    String senha = new String(txtSenha.getPassword());
                    Login login = new Login(usuario, senha);
                    //Aqui ele verifica se foi um funcionário que está tentando fazer um cadastro
                    if (verificarFuncionario(login)) {
                        JPanel panelCadastro = new JPanel(new GridLayout(0, 1));
                        JTextField txtIdEmprestimo = new JTextField();
                        //Cria o painel para inserir as informações
                        panelCadastro.add(new JLabel("ID do Empréstimo:"));
                        panelCadastro.add(txtIdEmprestimo);
                        JTextField txtIdFuncionarioEmprestimo = new JTextField();
                        panelCadastro.add(new JLabel("ID do Funcionário (Empréstimo):"));
                        panelCadastro.add(txtIdFuncionarioEmprestimo);
                        JTextField txtIdUsuarioEmprestimo = new JTextField();
                        panelCadastro.add(new JLabel("ID do Usuário (Empréstimo):"));
                        panelCadastro.add(txtIdUsuarioEmprestimo);
                        JTextField txtIdLivroEmprestimo = new JTextField();
                        panelCadastro.add(new JLabel("ID do Livro (Empréstimo):"));
                        panelCadastro.add(txtIdLivroEmprestimo);
                        int resultCadastro = JOptionPane.showConfirmDialog(null, panelCadastro, "Cadastrar Empréstimo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                        if (resultCadastro == JOptionPane.OK_OPTION) {
                            int idEmprestimo = Integer.parseInt(txtIdEmprestimo.getText());
                            int idFuncionarioEmprestimo = Integer.parseInt(txtIdFuncionarioEmprestimo.getText());
                            int idUsuarioEmprestimo = Integer.parseInt(txtIdUsuarioEmprestimo.getText());
                            int idLivroEmprestimo = Integer.parseInt(txtIdLivroEmprestimo.getText());
                            Emprestimo emprestimo = new Emprestimo(idEmprestimo, idFuncionarioEmprestimo, idUsuarioEmprestimo, idLivroEmprestimo, null);
                            daoEmprestimo.incluir(emprestimo);
                            JOptionPane.showMessageDialog(null, "Empréstimo cadastrado com sucesso!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Apenas funcionários podem cadastrar empréstimos!");
                    }
                }
            }
        });
        menuCadastro.add(menuItemCadastrarEmprestimo);
        
        //Cria o item no menu para cadastrar um Autor
        JMenuItem menuItemCadastrarAutor = new JMenuItem("Cadastrar Autor");
        menuItemCadastrarAutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel = new JPanel(new GridLayout(0, 1));
                JTextField txtIdAutor = new JTextField();
                //Cria o painel para inserir as informações
                panel.add(new JLabel("ID do Autor:"));
                panel.add(txtIdAutor);
                JTextField txtNomeAutor = new JTextField();
                panel.add(new JLabel("Nome do Autor:"));
                panel.add(txtNomeAutor);
                JTextField txtSobrenomeAutor = new JTextField();
                panel.add(new JLabel("Sobrenome do Autor:"));
                panel.add(txtSobrenomeAutor);
                JTextArea txtBiografiaAutor = new JTextArea(1, 20);
                JScrollPane scrollPaneBiografiaAutor = new JScrollPane(txtBiografiaAutor);
                panel.add(new JLabel("Biografia do Autor:"));
                panel.add(scrollPaneBiografiaAutor);
                int result = JOptionPane.showConfirmDialog(null, panel, "Cadastrar Autor", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    int idAutor = Integer.parseInt(txtIdAutor.getText());
                    String nomeAutor = txtNomeAutor.getText();
                    String sobrenomeAutor = txtSobrenomeAutor.getText();
                    String biografiaAutor = txtBiografiaAutor.getText();
                    Autor autor = new Autor(idAutor, nomeAutor, sobrenomeAutor, biografiaAutor);
                    daoAutor.incluir(autor);
                    JOptionPane.showMessageDialog(null, "Autor cadastrado com sucesso!");
                }
            }
        });
        menuCadastro.add(menuItemCadastrarAutor);
        
        //Cria o item no menu para cadastrar uma categoria
        JMenuItem menuItemCadastrarCategoria = new JMenuItem("Cadastrar Categoria");
        menuItemCadastrarCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Cria o painel para inserir as informações
                JPanel panel = new JPanel(new GridLayout(0, 1));
                JTextField txtIdCategoria = new JTextField();
                panel.add(new JLabel("ID da Categoria:"));
                panel.add(txtIdCategoria);
                JTextField txtTituloCategoria = new JTextField();
                panel.add(new JLabel("Título da Categoria:"));
                panel.add(txtTituloCategoria);
                int result = JOptionPane.showConfirmDialog(null, panel, "Cadastrar Categoria", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    int idCategoria = Integer.parseInt(txtIdCategoria.getText());
                    String tituloCategoria = txtTituloCategoria.getText();
                    Categoria categoria = new Categoria(idCategoria, tituloCategoria);
                    daoCategoria.incluir(categoria);
                    JOptionPane.showMessageDialog(null, "Categoria cadastrada com sucesso!");
                }
            }
        });
        menuCadastro.add(menuItemCadastrarCategoria);

        JMenu menuGerenciar = new JMenu("Gerenciar");
        menuBar.add(menuGerenciar);
        
        //A partir daqui começam os itens do menu para gerenciamento
        //Criando um item no menu para gerenciar os funcionários
        JMenuItem menuItemGerenciarFuncionarios = new JMenuItem("Gerenciar Funcionários");
        menuItemGerenciarFuncionarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcaoGerenciamentoSelecionada = 'F';
                ArrayList<Funcionario> funcionarios = daoFuncionario.getLista();
                tableModelGerenciamento.setRowCount(0); // limpa a tabela
                tableModelGerenciamento.setColumnCount(0); // limpa a tabela
                tableModelGerenciamento.addColumn("ID");
                tableModelGerenciamento.addColumn("Nome");
                tableModelGerenciamento.addColumn("Sobrenome");
                tableModelGerenciamento.addColumn("Matrícula");

        for (Funcionario funcionario : funcionarios) {
                    Object[] rowData = new Object[4];
                    rowData[0] = funcionario.getId();
                    rowData[1] = funcionario.getNome();
                    rowData[2] = funcionario.getSobrenome();
                    rowData[3] = funcionario.getMatricula();
                    tableModelGerenciamento.addRow(rowData);
                }
            }
        });
        menuGerenciar.add(menuItemGerenciarFuncionarios);
        
        //Criando um item no menu para Gerenciar os usuários
        JMenuItem menuItemGerenciarUsuarios = new JMenuItem("Gerenciar Usuários");
        menuItemGerenciarUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcaoGerenciamentoSelecionada = 'U';
                ArrayList<Usuario> usuarios = daoUsuario.getLista();
                tableModelGerenciamento.setRowCount(0); // limpa a tabela
                tableModelGerenciamento.setColumnCount(0); // limpa a tabela
                tableModelGerenciamento.addColumn("ID");
                tableModelGerenciamento.addColumn("Nome");
                tableModelGerenciamento.addColumn("Sobrenome");
                tableModelGerenciamento.addColumn("Registro Acadêmico");

        for (Usuario usuario : usuarios) {
                    Object[] rowData = new Object[4];
                    rowData[0] = usuario.getId();
                    rowData[1] = usuario.getNome();
                    rowData[2] = usuario.getSobrenome();
                    rowData[3] = usuario.getRegistroAcademico();
                    tableModelGerenciamento.addRow(rowData);
                }
            }
        });
        menuGerenciar.add(menuItemGerenciarUsuarios);
        
        //Criando um item no menu para gerenciar os Livros
        JMenuItem menuItemGerenciarLivros = new JMenuItem("Gerenciar Livros");
        menuItemGerenciarLivros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcaoGerenciamentoSelecionada = 'L';
                ArrayList<Livro> livros = daoLivro.getLista();
                tableModelGerenciamento.setRowCount(0); // limpa a tabela
                tableModelGerenciamento.setColumnCount(0); // limpa a tabela
                tableModelGerenciamento.addColumn("ID");
                tableModelGerenciamento.addColumn("Título");
                tableModelGerenciamento.addColumn("Autores");
                tableModelGerenciamento.addColumn("Categorias");
                tableModelGerenciamento.addColumn("Status");

                for (Livro livro : livros) {
                    Object[] rowData = new Object[5];
                    rowData[0] = livro.getId();
                    rowData[1] = livro.getTitulo();

                    String autoresString = "";
                    for (Autor autor : livro.getAutor()) {
                        autoresString += autor.getNome() + " " + autor.getSobrenome() + ", ";
                    }
                    if (autoresString.length() > 0) {
                        autoresString = autoresString.substring(0, autoresString.length() - 2);
                    }
                    rowData[2] = autoresString;

                    String categoriasString = "";
                    for (Categoria categoria : livro.getCategoria()) {
                        categoriasString += categoria.getTitulo() + ", ";
                    }
                    if (categoriasString.length() > 0) {
                        categoriasString = categoriasString.substring(0, categoriasString.length() - 2);
                    }
                    rowData[3] = categoriasString;

                    boolean emprestado = false;
                    for (Emprestimo emprestimo : daoEmprestimo.getLista()) {
                        if (emprestimo.getIdLivro() == livro.getId()) {
                            emprestado = true;
                            break;
                        }
                    }
                    if (emprestado) {
                        rowData[4] = "Emprestado";
                    } else {
                        rowData[4] = "Disponível";
                    }

        tableModelGerenciamento.addRow(rowData);
                }
            }
        });
        menuGerenciar.add(menuItemGerenciarLivros);
        
        //Criando um item no menu para gerenciar os Empréstimos
        JMenuItem menuItemGerenciarEmprestimos = new JMenuItem("Gerenciar Empréstimos");
        menuItemGerenciarEmprestimos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcaoGerenciamentoSelecionada = 'E';
                ArrayList<Emprestimo> emprestimos = daoEmprestimo.getLista();
                tableModelGerenciamento.setRowCount(0); // limpa a tabela
                tableModelGerenciamento.setColumnCount(0); // limpa a tabela
                tableModelGerenciamento.addColumn("ID");
                tableModelGerenciamento.addColumn("Título do Livro");
                tableModelGerenciamento.addColumn("Usuário");
                tableModelGerenciamento.addColumn("Funcionário");

        for (Emprestimo emprestimo : emprestimos) {
                    Livro livro = daoLivro.localizar(emprestimo.getIdLivro());
                    Usuario usuario = daoUsuario.localizar(emprestimo.getIdUsuario());
                    Funcionario funcionario = daoFuncionario.localizar(emprestimo.getIdFuncionario());

        Object[] rowData = new Object[4];
                    rowData[0] = emprestimo.getId();
                    rowData[1] = livro.getTitulo();
                    rowData[2] = usuario.getNome() + " " + usuario.getSobrenome();
                    rowData[3] = funcionario.getNome() + " " + funcionario.getSobrenome();
                    tableModelGerenciamento.addRow(rowData);
                }
            }
        });
        menuGerenciar.add(menuItemGerenciarEmprestimos);
        
        //Criando um item no menu para gerenciar os Autores
        JMenuItem menuItemGerenciarAutores = new JMenuItem("Gerenciar Autores");
        menuItemGerenciarAutores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcaoGerenciamentoSelecionada = 'A';
                ArrayList<Autor> autores = daoAutor.getLista();
                tableModelGerenciamento.setRowCount(0); // limpa a tabela
                tableModelGerenciamento.setColumnCount(0); // limpa a tabela
                tableModelGerenciamento.addColumn("ID");
                tableModelGerenciamento.addColumn("Nome");
                tableModelGerenciamento.addColumn("Sobrenome");
                tableModelGerenciamento.addColumn("Biografia");

        for (Autor autor : autores) {
                    Object[] rowData = new Object[4];
                    rowData[0] = autor.getId();
                    rowData[1] = autor.getNome();
                    rowData[2] = autor.getSobrenome();
                    rowData[3] = autor.getBiografia();
                    tableModelGerenciamento.addRow(rowData);
                }
            }
        });
        menuGerenciar.add(menuItemGerenciarAutores);
        
        //Criando um item no menu para gerenciar os Livros
        JMenuItem menuItemGerenciarCategorias = new JMenuItem("Gerenciar Categorias");
        menuItemGerenciarCategorias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcaoGerenciamentoSelecionada = 'C';
                ArrayList<Categoria> categorias = daoCategoria.getLista();
                tableModelGerenciamento.setRowCount(0); // limpa a tabela
                tableModelGerenciamento.setColumnCount(0); // limpa a tabela
                tableModelGerenciamento.addColumn("ID");
                tableModelGerenciamento.addColumn("Título");

        for (Categoria categoria : categorias) {
                    Object[] rowData = new Object[2];
                    rowData[0] = categoria.getId();
                    rowData[1] = categoria.getTitulo();
                    tableModelGerenciamento.addRow(rowData);
                }
            }
        });
        menuGerenciar.add(menuItemGerenciarCategorias);
        
        //Aqui está sendo criado um botão para atualizar as tabelas de informações
        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (opcaoGerenciamentoSelecionada == 'n') {
                    System.out.print("Erro");
                    // Nenhuma opção de gerenciamento selecionada
                    return;
                }

                switch (opcaoGerenciamentoSelecionada) {
                    case 'F':
                        ArrayList<Funcionario> funcionarios = daoFuncionario.getLista();
                        tableModelGerenciamento.setRowCount(0); // limpa a tabela
                        tableModelGerenciamento.setColumnCount(0); // limpa a tabela
                        tableModelGerenciamento.addColumn("ID");
                        tableModelGerenciamento.addColumn("Nome");
                        tableModelGerenciamento.addColumn("Sobrenome");
                        tableModelGerenciamento.addColumn("Matrícula");

                        for (Funcionario funcionario : funcionarios) {
                            Object[] rowData = new Object[4];
                            rowData[0] = funcionario.getId();
                            rowData[1] = funcionario.getNome();
                            rowData[2] = funcionario.getSobrenome();
                            rowData[3] = funcionario.getMatricula();
                            tableModelGerenciamento.addRow(rowData);
                        }
                        break;
                    case 'U':
                        ArrayList<Usuario> usuarios = daoUsuario.getLista();
                        tableModelGerenciamento.setRowCount(0); // limpa a tabela
                        tableModelGerenciamento.setColumnCount(0); // limpa a tabela
                        tableModelGerenciamento.addColumn("ID");
                        tableModelGerenciamento.addColumn("Nome");
                        tableModelGerenciamento.addColumn("Sobrenome");
                        tableModelGerenciamento.addColumn("Registro Acadêmico");

                        for (Usuario usuario : usuarios) {
                            Object[] rowData = new Object[4];
                            rowData[0] = usuario.getId();
                            rowData[1] = usuario.getNome();
                            rowData[2] = usuario.getSobrenome();
                            rowData[3] = usuario.getRegistroAcademico();
                            tableModelGerenciamento.addRow(rowData);
                        }
                        break;
                    case 'L':
                        ArrayList<Livro> livros = daoLivro.getLista();
                        tableModelGerenciamento.setRowCount(0); // limpa a tabela
                        tableModelGerenciamento.setColumnCount(0); // limpa a tabela
                        tableModelGerenciamento.addColumn("ID");
                        tableModelGerenciamento.addColumn("Título");
                        tableModelGerenciamento.addColumn("Autores");
                        tableModelGerenciamento.addColumn("Categorias");
                        tableModelGerenciamento.addColumn("Status");

                        for (Livro livro : livros) {
                            Object[] rowData = new Object[5];
                            rowData[0] = livro.getId();
                            rowData[1] = livro.getTitulo();

                            String autoresString = "";
                            for (Autor autor : livro.getAutor()) {
                                autoresString += autor.getNome() + " " + autor.getSobrenome() + ", ";
                            }
                            if (autoresString.length() > 0) {
                                autoresString = autoresString.substring(0, autoresString.length() - 2);
                            }
                            rowData[2] = autoresString;

                            String categoriasString = "";
                            for (Categoria categoria : livro.getCategoria()) {
                                categoriasString += categoria.getTitulo() + ", ";
                            }
                            if (categoriasString.length() > 0) {
                                categoriasString = categoriasString.substring(0, categoriasString.length() - 2);
                            }
                            rowData[3] = categoriasString;

                            boolean emprestado = false;
                            for (Emprestimo emprestimo : daoEmprestimo.getLista()) {
                                if (emprestimo.getIdLivro() == livro.getId()) {
                                    emprestado = true;
                                    break;
                                }
                            }
                            if (emprestado) {
                                rowData[4] = "Emprestado";
                            } else {
                                rowData[4] = "Disponível";
                            }

                            tableModelGerenciamento.addRow(rowData);
                        }
                        break;
                    case 'E':
                        ArrayList<Emprestimo> emprestimos = daoEmprestimo.getLista();
                        tableModelGerenciamento.setRowCount(0); // limpa a tabela
                        tableModelGerenciamento.setColumnCount(0); // limpa a tabela
                        tableModelGerenciamento.addColumn("ID");
                        tableModelGerenciamento.addColumn("Título do Livro");
                        tableModelGerenciamento.addColumn("Usuário");
                        tableModelGerenciamento.addColumn("Funcionário");

                        for (Emprestimo emprestimo : emprestimos) {
                            Livro livro = daoLivro.localizar(emprestimo.getIdLivro());
                            Usuario usuario = daoUsuario.localizar(emprestimo.getIdUsuario());
                            Funcionario funcionario = daoFuncionario.localizar(emprestimo.getIdFuncionario());

                            Object[] rowData = new Object[4];
                            rowData[0] = emprestimo.getId();
                            rowData[1] = livro.getTitulo();
                            rowData[2] = usuario.getNome() + " " + usuario.getSobrenome();
                            rowData[3] = funcionario.getNome() + " " + funcionario.getSobrenome();
                            tableModelGerenciamento.addRow(rowData);
                        }
                        break;
                    case 'A':
                        ArrayList<Autor> autores = daoAutor.getLista();
                        tableModelGerenciamento.setRowCount(0); // limpa a tabela
                        tableModelGerenciamento.setColumnCount(0); // limpa a tabela
                        tableModelGerenciamento.addColumn("ID");
                        tableModelGerenciamento.addColumn("Nome");
                        tableModelGerenciamento.addColumn("Sobrenome");
                        tableModelGerenciamento.addColumn("Biografia");

                        for (Autor autor : autores) {
                            Object[] rowData = new Object[4];
                            rowData[0] = autor.getId();
                            rowData[1] = autor.getNome();
                            rowData[2] = autor.getSobrenome();
                            rowData[3] = autor.getBiografia();
                            tableModelGerenciamento.addRow(rowData);
                        }
                        break;
                    case 'C':
                        ArrayList<Categoria> categorias = daoCategoria.getLista();
                        tableModelGerenciamento.setRowCount(0); // limpa a tabela
                        tableModelGerenciamento.setColumnCount(0); // limpa a tabela
                        tableModelGerenciamento.addColumn("ID");
                        tableModelGerenciamento.addColumn("Título");

                        for (Categoria categoria : categorias) {
                            Object[] rowData = new Object[2];
                            rowData[0] = categoria.getId();
                            rowData[1] = categoria.getTitulo();
                            tableModelGerenciamento.addRow(rowData);
                        }
                        break;
                }
            }
        });
        add(btnAtualizar, BorderLayout.SOUTH);


        tableModelGerenciamento = new DefaultTableModel();
        tableGerenciamento = new JTable(tableModelGerenciamento);
        JScrollPane scrollPaneTable = new JScrollPane(tableGerenciamento);
        add(scrollPaneTable);

        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        }

    //Função para verificar o login do admin
    public boolean verificarLogin(Login login) {
        if (login.getUsuario().equals("admin") && login.getSenha().equals("0000")) {
            return true;
        } else {
            return false;
        }
    }
    
    //Função para verificar o login do Funcionário
    public boolean verificarFuncionario(Login login) {
        for (Funcionario f : daoFuncionario.getLista()) {
            if (f.getLogin().equals(login.getUsuario()) && f.getSenha().equals(login.getSenha())) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Principal gui = new Principal();
    }
}
