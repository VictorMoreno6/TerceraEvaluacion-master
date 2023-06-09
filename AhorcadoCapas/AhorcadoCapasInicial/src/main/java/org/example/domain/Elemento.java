package org.example.domain;

import org.example.common.CategoriaException;
import org.example.common.Comprobacion;
import org.example.dao.Elementos;

public class Elemento implements Comparable<Elemento> {
    private int id;
    private int level;
    private String incognita;
    private String categoria;

    /**
     *
     * @param id identicador único de cada elemento, el String incognita puede tener espacios, mayúsculas, mínúsculas que no lo hagan único
     * @param level indica la dificultad que le asignamos a la incognita a adivinar por el tamaño de caracteres por ejemplo
     * @param incognita palabra a adivinar
     * @param categoria String que debe se un elemento de Categoria, si no lo es se lanzará CategoriaEx y así no se creará el objeto
     * @throws CategoriaException
     */
    public Elemento(int id, int level, String incognita, String categoria) throws CategoriaException {
        this.id = id;
        this.level = level;
        this.incognita = incognita;
        Comprobacion.categoriaOk(categoria);
        this.categoria = categoria;
    }

    public Elemento(int level, String incognita, String categoria) throws CategoriaException {
        this.id = Elementos.getAutonumerico();
        Elementos.setAutonumerico(Elementos.getAutonumerico()+1);
        this.level = level;
        this.incognita = incognita;
        Comprobacion.categoriaOk(categoria);
        this.categoria = categoria;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) throws CategoriaException {
        Comprobacion.categoriaOk(categoria);
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        //Comprobacion.idOk(id);
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

    @Override
    public int compareTo(Elemento o) {
        return Integer.compare(id,o.id);
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", level=" + level +
                ", incognita='" + incognita +
                ", categoria='" + categoria + '}';
    }
}
