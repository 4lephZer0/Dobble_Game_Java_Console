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

            if (opcion.equals("1")){
                System.out.print("Ingrese la cantidad maxima de cartas: ");
                String maxC1  = escaneo.nextLine();
                int maxC = Integer.parseInt(maxC1);

                System.out.print("Ingrese la cantidad de elementos por carta: ");
                String numE1  = escaneo.nextLine();
                int numE = Integer.parseInt(numE1);

                System.out.print("Ingrese una lista de elementos (EJEMPLO: A,B,C,D,E ): ");
                String cadena  = escaneo.nextLine();
                List<String> elements = new ArrayList<String>(Arrays.asList(cadena.split(",")));

                Cards mazo = new Cards(maxC, numE, elements);

                System.out.println(mazo);
                condicion = 1;

            }
        }
    }



}
