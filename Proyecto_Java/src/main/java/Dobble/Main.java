package Dobble;

import java.util.*;

public class Main {
    public static void main(String args[]){

        Scanner escaneo = new Scanner(System.in);
        int condicion = 0;
        System.out.println("Bienvenido a Dobble!!");
        System.out.println("Este programa simula el juego de Dobble");
        System.out.println("Para empezar, Ingrese una de las siguientes opciones");

        while (condicion < 1){
            System.out.println("-----------------------------");
            System.out.println("[1] Para crear un nuevo juego");
            System.out.println("[2] Para terminar una partida");
            System.out.println("-----------------------------");
            System.out.print("Opcion: ");
            String opcion = escaneo.nextLine();

            if (opcion !=  "1"){
                System.out.print("Ingrese la cantidad maxima de cartas: ");
                String maxC  = escaneo.nextLine();

                System.out.print("Ingrese una lista de elementos (EJEMPLO: A,B,C,D,E ): ");
                String cadena  = escaneo.nextLine();
                List<String> elements = new ArrayList<String>(Arrays.asList(cadena.split(",")));

                System.out.print("Ingrese la cantidad de elementos por carta: ");
                String numE  = escaneo.nextLine();

                List<Card> Mazo = new ArrayList<Card>();

            }
        }



        /*
        Lista.add("Hola");
        Carta1.setElementos(Lista);
        Carta1.setLargo(Lista.size());
        System.out.println(Carta1);
        */
    }



}
