package org.example.domain;

import org.example.common.Categoria;
import org.example.dao.Elementos;
import org.example.service.GestionElementos;
import org.example.service.IGestionElementos;

import org.example.common.CategoriaException;
import org.example.common.Comprobacion;

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

    private ArrayList<String> palabrausuario;
    //private char[] palabrausuario;

    private int dificultad; //opcional, aquí o por elemento.

    public Juego(Jugador jugador){
        this.jugador= jugador;
        fallos=0;
    }

    public void pintarTablero(){
        if (fallos==1){
            System.out.println("  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========");
        }
        else if (fallos==2){
            System.out.println("  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========");
        }
        else if (fallos==3){
            System.out.println("  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========");
        }
        else if (fallos==4){
            System.out.println("  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========");
        }
        else if (fallos==5){
            System.out.println("  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========");
        }
        else if (fallos==6){
            System.out.println("  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========");
        }
        else if (fallos==7){
            System.out.println("  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n=========");
        }
    }

    public String obtenerPalabra(){
        //new GestionElementos()
        intentos= new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        //Categoria aux [] = Categoria.values();
        String categoria=null;
        do {
            System.out.println("Selecciona una categoria de las siguientes " + Arrays.toString(Categoria.values()));
            int cat = sc.nextInt();
            switch (cat){
                case 1:
                    categoria="accion";
                    break;
                case 2:
                    categoria="comedia";
                    break;
                case 3:
                    categoria="miedo";
                    break;
                case 4:
                    categoria="pokemon";
                    break;
                default:
                    System.out.println("Selecciona un numero del 1 al 4.");
            }
        }while (categoria==null);
        try {
            Comprobacion.categoriaOk(categoria);
        }catch (CategoriaException e){
            System.out.println(e.getMessage());
        }
        lista = new GestionElementos();
        List<Elemento> grupoPalabras= lista.getListaElementosCategoria(categoria);
        int azar = (int) (Math.random() * grupoPalabras.size());
        aAdivinar= grupoPalabras.get(azar);
        String palabra=aAdivinar.getIncognita();
        int length =palabra.length();
        //palabrausuario = new char[length];
        palabrausuario= new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            palabrausuario.add(".");
        }
        return palabra;
    }

    public boolean letraOk(String a){
        boolean bien=false;
        try{
            if (a.length() != 1) {
                throw new IllegalArgumentException("Debe ingresar solo una letra.");
            }

            char letra = a.charAt(0);
            //else  {
            // Comprobar si la letra está entre la 'a' y la 'z'
            if (!(letra>= 'a' && letra <= 'z') && !(letra >= 'A' && letra <= 'Z')) {
                throw new IllegalArgumentException("Debe ingresar una letra entre la 'a' y la 'z'.");
            }else {
                bien=true;
            }
            /*else {
                String letra1 = String.valueOf(letra);
                boolean repe = false;
                for (int i = 0; i < intentos.size(); i++) {
                    if (intentos.get(i).equalsIgnoreCase(letra1)) {
                        repe = true;
                        System.out.println("Letra repetida");
                    }
                }
                if (repe = false){
                    bien=true;
                }
            }*/
        }catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
        return bien;
    }
    public void ronda(String palabra){
        Scanner sc = new Scanner(System.in);
        //String palabra= obtenerPalabra();
        System.out.println("Letras introducidas: " + intentos.toString());
        System.out.println("Escribe una letra");
        String a= String.valueOf(sc.next().charAt(0));
        if (letraOk(a)){
            int length =palabra.length();
            boolean hay=false;
            //ArrayList<String> aux = new ArrayList<>(length);
            for (int num=0;num<length;num++) {
                if (a.equalsIgnoreCase(String.valueOf(palabra.charAt(num)))){
                    //palabrausuario.add(num,a);
                    //a=aux.get(num);
                    hay=true;
                }
            }
            if (!hay)
                fallos++;
            intentos.add(a);
        }
    }

    public void mostradorUsuario(){
        String palabra=aAdivinar.getIncognita();
        String[] mostrar =new String[palabra.length()];
        System.out.print("{ ");
        for (int i = 0; i < palabra.length(); i++) {
            if (!(palabrausuario.get(i)==null)){
                String letra=String.valueOf(palabra.charAt(i));
                if (palabrausuario.get(i).equalsIgnoreCase(String.valueOf(palabra.charAt(i)))) {

                    mostrar[i]= String.valueOf(palabra.charAt(i));
                } else if (letra.equalsIgnoreCase(" ")){
                    mostrar[i]=" ";
                } else {
                    mostrar[i]="_";
                }
            } else {
                mostrar[i]="_";
            }
            System.out.print(mostrar[i]+ " ");
        }
        System.out.print("}");
        System.out.println();
    }

    //public  ArrayList<Character> mostrardorIncognita()
    public boolean finJuego(){
        boolean fin = false;
        if (fallos==7){
            fin = true;
            System.out.println(jugador.getNombre() +  " has perdido.");
        }
        boolean fing = true;
        String palabra= aAdivinar.getIncognita();
        for (int i = 0; i < palabra.length(); i++) {
            if (!palabrausuario.get(i).equalsIgnoreCase(String.valueOf(palabra.charAt(i)))) {
                fing = false;
            }
        }
        if (fing==true){
            int num = 0;
            if (fallos == 0){
                num = 10;
                jugador.setPuntuacion(num);
            } else {
                num=5;
                jugador.setPuntuacion(num);
            }
            fin = true;
            System.out.println("Enhorabuena" + jugador.getNombre() + " has acertado en " + intentos.size() + " intentos y has tenido " + fallos + " fallos.");
        }
        return fin;
    }
}


