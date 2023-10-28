package main.java.models.itens;

import main.java.enums.StatusClassificacao;
import java.time.LocalDate;

public class Item {

    protected int id;

    private static int PROX_ID = 0;

    private String titulo;
    private LocalDate dataPublicacao;
    private StatusClassificacao statusClassificacao;


    public Item() {
    }

    public Item(String titulo, LocalDate dataPublicacao, StatusClassificacao statusClassificacao) {
        this.titulo = titulo;
        this.dataPublicacao = dataPublicacao;
        this.statusClassificacao = statusClassificacao;
        this.id = PROX_ID++;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public StatusClassificacao getStatusClassificacao() {
        return statusClassificacao;
    }

    public void setStatusClassificacao(StatusClassificacao statusClassificacao) {
        this.statusClassificacao = statusClassificacao;
    }


}
