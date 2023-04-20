package org.example.ui;

import org.example.common.CategoriaException;
import org.example.common.Constantes;
import org.example.service.GestionElementos;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase con métodos de administración para consola
 */
public class GestionDiccionario {
    private static final String pass = "2223";
    private GestionElementos gE;
    public static int mostrarMenu(){
        Scanner sc = new Scanner(System.in);
        int num=5;
        System.out.println("Introduce la contraseña");
        if (sc.nextLine().equals(pass)){
            boolean bien=false;
            do {
                try {
                    System.out.println(Constantes.MENU+"\n"+Constantes.OPCION1+"\n"+Constantes.OPCION2+"\n"+Constantes.OPCION3+"\n"+Constantes.OPCION4+"\n"+"Salir");
                    num = sc.nextInt(); //tratar la excepción para evitar que se pare el programa si no introduce un número
                    bien = true;
                }catch(InputMismatchException e){
                    System.out.println("Tienes que introducir un numero no una letra");
                    System.out.println(e.getMessage());
                    sc.nextLine();
                }
            }while (bien==false);
        }else {
            System.out.println("Contraseña incorrecta");
        }
        return num;
    }

    public void ejecutarOpcion(){
        gE= new GestionElementos();
        int num=0;
        do {
            num=mostrarMenu();
            switch (num){
                case 1 -> listarDiccionario();
                case 2 -> mostrarMenu();
                case 3 -> {
                    try {
                        modificarElemento() ;
                    } catch (CategoriaException e) {
                        throw new RuntimeException(e);
                    }
                }
                case 4 -> eliminarElemento();
                case 5 -> System.out.println("Hasta luego");
                //case 6 -> crearFichero;
                //case 7 -> eliminarFichero;
                default -> System.out.println("Escribe un numero entre el 1 y el 4");
            }
        }while(num!=5);
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
        Scanner sc = new Scanner(System.in);
        boolean bien=false;
        do {
            try {
                System.out.println("Dime el id");
                gE.eliminarElemento(sc.nextInt());
                bien=true;
            }catch(InputMismatchException e){
                System.out.println("Tienes que introducir un numero no una letra");
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }while (bien==false);




    }

    public void modificarElemento() throws CategoriaException {
        Scanner sc = new Scanner(System.in);
        char a;
        System.out.println("Deseas modificar la categoría, Si(S), No(N)");
        try {
            a= (char) System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String letra= String.valueOf(a);
        if (letra.toUpperCase().equalsIgnoreCase("S")){
            System.out.println("Escribe el id del elemento y la nueva categoria");
            gE.modificarCategoria(sc.nextInt(),sc.next());
        }
        System.out.println("Deseas modificar la incognita, Si(S), No(N)");
        try {
            a= (char) System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String letra2= String.valueOf(a);
        if (letra.toUpperCase().equalsIgnoreCase("S")){
            System.out.println("Escribe el id del elemento y la nueva categoria");
            gE.modificarElemento(sc.nextInt(),sc.next());
        }
    }

    public void eliminarElemento(){
        Scanner sc = new Scanner(System.in);
        int id;
        try{
            System.out.println("Inserte el id del elemento que deseas eliminar");
            id=sc.nextInt();
            gE.eliminarElemento(id);
        } catch (InputMismatchException e){
            e.getMessage();
        }
    }

}
