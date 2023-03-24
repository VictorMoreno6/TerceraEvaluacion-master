package org.example.domain;

import java.util.ArrayList;

public class Juego {
    //pensar en los atributos que definen el estado del juego en ese instante para que que si lo paran se pueda recuperar
    private Elemento aAdivinar; //o el String directamente
    private Jugador jugador;
    private ArrayList<String> intentos;

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

}


