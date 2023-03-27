package org.example.domain;

import org.example.common.Categoria;
import org.example.dao.Elementos;
import org.example.service.GestionElementos;
import org.example.service.IGestionElementos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Juego {
    //pensar en los atributos que definen el estado del juego en ese instante para que que si lo paran se pueda recuperar
    private Elemento aAdivinar; //o el String directamente
    private Jugador jugador;

    private ArrayList<String> intentos;
    private Elementos elementos;
    private GestionElementos lista;
    private int fallos;

    private int dificultad; //opcional, aquí o por elemento.
    public Juego(Jugador jugador, Elemento aAdivinar){
        this.jugador= jugador;
        this.aAdivinar= aAdivinar;
        fallos=0;
    }

    public void pintarTablero(){
        if (fallos==1){
            System.out.println("  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========");
        }
        if (fallos==2){
            System.out.println("  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========");
        }
        if (fallos==3){
            System.out.println("  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========");
        }
        if (fallos==4){
            System.out.println("  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========");
        }
        if (fallos==5){
            System.out.println("  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========");
        }
        if (fallos==6){
            System.out.println("  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========");
        }
        if (fallos==7){
            System.out.println("  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n=========");
        }
    }

    public String obtenerPalabra(){
        //new GestionElementos()
        Scanner sc = new Scanner(System.in);
        Categoria aux [] = Categoria.values();
        System.out.println("Selecciona una categoria de las siguientes " + Arrays.toString(Categoria.values()));
        int cat = sc.nextInt();
        String categoria= String.valueOf(aux[cat]);
        List<Elemento> grupoPalabras= lista.getListaElementosCategoria(categoria);
        int azar = (int) (Math.random() * grupoPalabras.size());
        aAdivinar= grupoPalabras.get(azar);
        String palabra=aAdivinar.getIncognita();
        return palabra;
    }

    public ArrayList<String> ronda(String a, String palabra){
        //String palabra= obtenerPalabra();
        int length =palabra.length();
        boolean hay=false;
        ArrayList<String> aux = new ArrayList<>(length);
        for (int num=0;num<length;num++) {
            if (a.equalsIgnoreCase(String.valueOf(palabra.charAt(num)))){
                a=aux.get(num);
                hay=true;
            }
        }
        if (!hay)
            fallos++;
        intentos.add(a);
        return aux;
    }

}


