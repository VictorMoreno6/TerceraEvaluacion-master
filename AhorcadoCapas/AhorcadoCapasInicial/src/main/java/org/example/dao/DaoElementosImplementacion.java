package org.example.dao;

import org.example.common.Categoria;
import org.example.common.CategoriaException;
import org.example.domain.Elemento;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DaoElementosImplementacion implements DaoElementos {
    protected final Elementos lista;

    public DaoElementosImplementacion() {
        this.lista = new Elementos();
    }

    @Override
    public boolean isEmptyElementosList() {
        boolean hay = false;
        if (lista.getListaelementos()!=null){
            hay=true;
        }
        return hay;
    }

    @Override
    public boolean insertarElemento(Elemento elemento) {
        return lista.getListaelementos().add(elemento);
    }

    @Override
    public boolean insertarElemento(int id, int level, String incognita, String categoria) throws CategoriaException{
            return lista.getListaelementos().add(new Elemento(id, level, incognita, categoria));
    }

    @Override
    public List<Elemento> getElementosCategoria(String categoria) {
        List<Elemento> aux = new ArrayList<Elemento>();
        for (int i = 0; i < lista.getListaelementos().size(); i++) {
            if (lista.getListaelementos().get(i).getCategoria().equalsIgnoreCase(categoria)){
                aux.add(lista.getListaelementos().get(i));
            }
        }
        return aux;
    }

    @Override
    public List<Elemento> getElementosNivelCategoria(int nivel, String categoria) {
        List<Elemento> aux=null;
        for (int i = 0; i < lista.getListaelementos().size(); i++) {
            if (lista.getListaelementos().get(i).getCategoria().equalsIgnoreCase(categoria) && lista.getListaelementos().get(i).getLevel()==nivel){
                aux.add(lista.getListaelementos().get(i));
            }
        }
        return aux;
    }

    @Override
    public List<Elemento> getElementosNivel(int nivel) {
        List<Elemento> aux=null;
        for (int i = 0; i < lista.getListaelementos().size(); i++) {
            if (lista.getListaelementos().get(i).getLevel()==nivel){
                aux.add(lista.getListaelementos().get(i));
            }
        }
        return aux;
    }

    @Override
    public List<Elemento> getElementosOrdenados(boolean ascendente) {
        List<Elemento> aux=lista.getListaelementos();
        Collections.sort(aux);
        if (!ascendente){
            Collections.reverse(aux);
        }
        return aux;
    }

    @Override
    public List<Elemento> getElementos() {
        return lista.getListaelementos();
    }

    @Override
    public void eliminarElemento(Elemento elemento) {
        lista.getListaelementos().remove(elemento);
    }

    @Override
    public void eliminarElemento(int id) {
        Elemento aux=null;
        for (int i = 0; i < lista.getListaelementos().size(); i++) {
            if (lista.getListaelementos().get(i).getId()==id){
                aux=lista.getListaelementos().get(i);
            }
        }
        lista.getListaelementos().remove(aux);
    }

    @Override
    public void idOk(int id) throws IdException {
        for (int i = 0; i <  lista.getListaelementos().size(); i++) {
            if (id == lista.getListaelementos().get(i).getId()){
                IdException ew;
                throw ew.getMessage();
            }
        }
    }

    @Override
    public boolean modificarCategoria(int id, String categoria) {
        boolean cambio=false;
        Elemento aux=null;
        for (int i = 0; i < lista.getListaelementos().size(); i++) {
            if (lista.getListaelementos().get(i).getId()==id){
                aux=lista.getListaelementos().get(i);
            }
        }
        try {
            aux.setCategoria(categoria);
            cambio=true;
        } catch (CategoriaException e) {
            throw new RuntimeException(e);
        }
        return cambio;
    }

    @Override
    public boolean modificarElemento(int id, String incognita) {
        Elemento aux=null;
        for (int i = 0; i < lista.getListaelementos().size(); i++) {
            if (lista.getListaelementos().get(i).getId()==id){
                aux=lista.getListaelementos().get(i);
            }
        }
        aux.setIncognita(incognita);
        return true;
    }
}
