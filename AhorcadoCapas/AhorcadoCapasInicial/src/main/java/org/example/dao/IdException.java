package org.example.dao;

import org.example.common.Categoria;

import java.util.Arrays;

public class IdException extends Exception{
    public IdException() {
        super("La categoria debe ser alguna de las siguientes"+ Arrays.toString(Categoria.values()));
    }

    public IdException(String categoria) {
        super("La categoria "+ categoria+" no está permitida. Sólo son válidas:"+ Arrays.toString(Categoria.values()));
    }
}
