package org.example.ui;

import org.example.common.Constantes;
import org.example.service.IGestionElementos;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase con métodos de administración para consola
 */
public class GestionDiccionario {
    private static final String pass = "2223";
    private IGestionElementos gE;
    public static int mostrarMenu(){
        Scanner sc = new Scanner(System.in);
        int num=0;
        System.out.println("Introduce la contraseña");
        if (sc.nextLine().equals(pass)){
            boolean bien=false;
            do {
                try {
                    System.out.println(Constantes.MENU+"\n"+Constantes.OPCION1+"\n"+Constantes.OPCION2+"\n"+Constantes.OPCION3+"\n"+Constantes.OPCION4);
                    num = sc.nextInt(); //tratar la excepción para evitar que se pare el programa si no introduce un número
                    bien = true;
                }catch(InputMismatchException e){
                    System.out.println("Tienes que introducir un numero no una letra");
                    System.out.println(e.getMessage());
                    sc.nextLine();
                }
            }while (bien==false);
        }
        return num;
    }

    public void ejecutarOpción(){
        int num=mostrarMenu();
        switch (num){
            case 1 -> listarDiccionario();
            case 2 -> insertarElemento();
            case 3 -> modificarElemento();
            case 4 -> eliminarElemento();
            default -> System.out.println("Escribe un numero entre el 1 y el 4");
        }
    }

    public void listarDiccionario(){
        boolean ascendente=true;
        System.out.println("Listado ascendente");
        gE.listarElementos(ascendente);
        ascendente=false;
        System.out.println("Listado descendente");
        gE.listarElementos(ascendente);
    }
    public void insertarElemento(){
        System.out.println("Dime el id");

    }

    public void modificarElemento(){

    }

    public void eliminarElemento(){

    }

}
