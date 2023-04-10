package org.example.common;

public enum Categoria {
    accion, comedia, miedo, pokemon; //lo que queráis series, música, juegos, etc.

    public void listarcat(){
        Categoria aux [] = Categoria.values();
        for(int i=0; i<aux.length;i++) {
            System.out.println(aux[i].toString() + " - ");
        }
    }
}
