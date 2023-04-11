package org.example.ui;

import org.example.domain.Juego;
import org.example.domain.Jugador;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Jugar {
    public static void jugar(){
        Scanner sc = new Scanner(System.in);
        boolean seguirjugando=true;
        do {
            System.out.println("Escribe tu nombre de Jugador.");
            Juego juego= new Juego(new Jugador(sc.next()));
            String incognita=juego.obtenerPalabra();
            System.out.println(incognita);
            do {
                juego.pintarTablero();
                juego.mostradorUsuario();
                juego.ronda(incognita);

            }while (!juego.finJuego());
            int res;
            try{
                System.out.println("Quieres seguir jugando. SI(1), NO(2).");
                res=sc.nextInt();
                if (res==1){
                    seguirjugando=true;
                } else if (res==2) {
                    seguirjugando=false;
                }
            } catch (InputMismatchException e){
                throw new RuntimeException(e);
            }
        }while (seguirjugando);
    }
}
