package org.example;

import org.example.common.CategoriaException;
import org.example.common.Comprobacion;
import org.example.common.Categoria;
import org.example.domain.Juego;
import org.example.domain.Jugador;
import org.example.ui.GestionDiccionario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        //En el main sólo hay que llamar a los métodos de la UI que darán paso al luego o administrar diccionario.
        //Pero este código es para que veáis cómo funciona ciertos aspectos de la aplicación a tener en cuenta


        GestionDiccionario.mostrarMenu();
        try {
            Comprobacion.categoriaOk(Categoria.comedia.name());
            Comprobacion.categoriaOk("hola");
        }catch (CategoriaException e){
            System.out.println(e.getMessage());
        }


        /*Faker faker = new Faker();
        String nombre = faker.gameOfThrones().character();
        System.out.println(nombre);
        String animal = faker.animal().name();
        System.out.println(animal);
        String fecha = faker.date().birthday(10,15).toString();
        System.out.println(fecha);*/



        //El siguiente código no va aquí pero es para que sepáis cómo funciona el id autonumérico
        /*Elementos asdf = new Elementos();
        System.out.println(Elementos.getAutonumerico());
        Elemento asd = new Elemento(2,"324",Categoria.accion.name());
        System.out.println(Elementos.getAutonumerico());
        Elemento asd2 = new Elemento(2,"324",Categoria.miedo.name());
        System.out.println(Elementos.getAutonumerico());*/
        boolean seguirjugando=true;
        do {
            System.out.println("Escribe tu nombre de Jugador.");
            Juego juego= new Juego(new Jugador(sc.next()));
            String incognita=juego.obtenerPalabra();
            System.out.println(incognita);
            do {
                juego.pintarTablero();
                //juego.mostradorIncognita();
                juego.ronda(incognita);

            }while (!juego.finJuego());
            System.out.println("Quieres seguir jugando");
        }while (seguirjugando);

    }
}