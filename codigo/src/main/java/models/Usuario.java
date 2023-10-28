package main.java.models;

import main.java.models.itens.Emprestimo;

import java.time.LocalDate;
import java.util.List;

public class Usuario {
    private int id;

    private static int PROX_ID = 0;

    private String senha;
    private String email;
    private LocalDate dataNascimento;
    private int qtdItensEmprestados;
    private List<Emprestimo> emprestimos;
    private final int QTD_MAX_ITENS_EMPRESTADOS = 3;


    public Usuario() {
    }

    public Usuario(String senha, String email, LocalDate dataNascimento) {
        this.senha = senha;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getQtdItensEmprestados() {
        return qtdItensEmprestados;
    }


    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }


    public int getQTD_MAX_ITENS_EMPRESTADOS() {
        return QTD_MAX_ITENS_EMPRESTADOS;
    }
}
