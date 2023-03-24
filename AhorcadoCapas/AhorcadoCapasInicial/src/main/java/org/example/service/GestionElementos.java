package org.example.service;

import org.example.common.CategoriaException;
import org.example.common.Comprobacion;
import org.example.dao.DaoElementos;
import org.example.dao.DaoElementosFicheros;
import org.example.dao.DaoElementosImplementacion;
import org.example.domain.Elemento;

import java.io.IOException;
import java.util.List;

public class GestionElementos implements IGestionElementos {

    private final DaoElementos daoElementos;


    public GestionElementos() {
        this.daoElementos = new DaoElementosImplementacion();
    }

    public GestionElementos(DaoElementos daoElementos) {
        this.daoElementos = daoElementos;
    }

    @Override
    public boolean isEmptyElementosList() {
        return daoElementos.isEmptyElementosList();
    }

    @Override
    public List<Elemento> getListaElementos() {
        return daoElementos.getElementos();
    }

    @Override
    public boolean insertarElemento(Elemento Elemento) {
        return daoElementos.insertarElemento(Elemento);
    }

    @Override
    public boolean insertarElemento(int id, int level, String incognita, String categoria) throws CategoriaException {
        return daoElementos.insertarElemento(id,level,incognita,categoria);
    }

    @Override
    public List<Elemento> listar(String categoria) {
        return daoElementos.getElementosCategoria(categoria);
    }

    @Override
    public List<Elemento> listar(int nivel, String categoria) {
        return daoElementos.getElementosNivelCategoria(nivel, categoria);
    }

    @Override
    public List<Elemento> listar(int nivel) {
        return return daoElementos.getElementosNivel(nivel);
    }

    @Override
    public List<Elemento> listarElementos(boolean ascendente) {
        return null;
    }

    @Override
    public boolean modificarCategoria(int id, String categoria) throws CategoriaException {
        return false;
    }

    @Override
    public boolean modificarElemento(int id, String incognita) {
        return false;
    }

    @Override
    public List<Elemento> getListaElementosCategoria() {
        return null;
    }

    @Override
    public void eliminarElemento(Elemento Elemento) {

    }

    @Override
    public void crearFicheros() throws IOException {

    }

    @Override
    public boolean cargarFichero() throws IOException {
        return false;
    }

    @Override
    public boolean escribirFichero() {
        return false;
    }

    @Override
    public boolean escribirFicheroBinario() {
        return false;
    }

    @Override
    public boolean cargarFicheroBinario() {
        return false;
    }
}