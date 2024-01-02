package com.aula.aula_09_05;

public class AgendaModelo {
    int 	codigo;
    String 	nome;
    String data;
    String hora;

    public AgendaModelo() {
    }

    public AgendaModelo(int codigo, String nome, String data, String hora) {
        this.codigo = codigo;
        this.nome = nome;
        this.data = data;
        this.hora = hora;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
