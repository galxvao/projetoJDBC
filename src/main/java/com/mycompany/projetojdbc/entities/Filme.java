/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetojdbc.entities;

/**
 *
 * @author davi_galvao
 */
public class Filme {
    
    private int id;
    private String titulo;
    private int ano;
    private String diretor;
    private int categoriaId;
    

    public Filme(int aInt, String string) {
    }

    public Filme(int id, String titulo, int ano, String diretor, int categoriaId) {
        this.id = id;
        this.titulo = titulo;
        this.ano = ano;
        this.diretor = diretor;
        this.categoriaId = categoriaId;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    @Override
    public String toString() {
        return "Filme{" + "id=" + id + ", titulo=" + titulo + ", ano=" + ano + ", diretor=" + diretor + ", categoriaId=" + categoriaId + '}';
    }
    
    
    
}
