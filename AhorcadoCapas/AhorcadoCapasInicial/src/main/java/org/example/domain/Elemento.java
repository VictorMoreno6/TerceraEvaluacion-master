package org.example.domain;

public class Elemento {
    private int id;
    private int level;
    private String incognita;

    private Categoria categoria;
    public Elemento(int id, int level, String incognita, Categoria categoria) {
        this.id = id;
        this.level = level;
        this.incognita = incognita;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getIncognita() {
        return incognita;
    }
    public void setIncognita(String incognita) {
        this.incognita = incognita;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
