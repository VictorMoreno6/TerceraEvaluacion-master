package org.example.ui;

import org.example.common.Constantes;
import org.example.domain.Juego;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Arranque {
    public static void arranque(){
        Scanner sc = new Scanner(System.in);
        int num=0;
        boolean bien=false;
        do {
            try {
                System.out.println("Presiona 1 si quieres gestionar el diccionario o 2 si prefieres jugar");
                num = sc.nextInt();
                if (num==1 || num==2){
                    bien = true;
                } else {
                    System.out.println("Numero introducido no válido");
                }
            }catch(InputMismatchException e){
                System.out.println("Tienes que introducir un numero no una letra");
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }while (bien==false);
        if (num==1){
            GestionDiccionario.mostrarMenu();
        } else {
            Jugar.jugar();
        }
    }
}
