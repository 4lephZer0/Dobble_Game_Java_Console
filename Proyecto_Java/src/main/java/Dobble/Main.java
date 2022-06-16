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
                String maxC  = escaneo.nextLine();

                System.out.print("Ingrese una lista de elementos (EJEMPLO: A,B,C,D,E ): ");
                String cadena  = escaneo.nextLine();
                List<String> elements = new ArrayList<String>(Arrays.asList(cadena.split(",")));

                System.out.print("Ingrese la cantidad de elementos por carta: ");
                String numE  = escaneo.nextLine();

                List<Card> mazo = new ArrayList<Card>();
                List<Integer> carta  = new ArrayList<Integer>();
                int n = Integer.parseInt(numE) - 1;
                for (int i = 1; i<= n+1; i++) {
                    carta.add(i);
                }
                List<Integer> cartaAux  = new ArrayList<Integer>(carta);
                Card carta1 = new Card(carta.size(),cartaAux);
                mazo.add(carta1);
                for (int j=1; j<=n; j++) {
                    carta.clear();
                    carta.add(1);

                    for (int k=1; k<=n; k++) {
                        carta.add(n * j + (k+1));
                    }
                    cartaAux  = new ArrayList<Integer>(carta);
                    carta1 = new Card(carta.size(),cartaAux);
                    mazo.add(carta1);
                }
                for (int i= 1; i<=n; i++) {
                    for (int j=1; j<=n; j++) {
                        carta.clear();
                        carta.add(i+1);

                        for (int k=1; k<= n; k++) {
                            carta.add(n+2+n*(k-1)+(((i-1)*(k-1)+j-1)%n));
                        }
                        cartaAux  = new ArrayList<Integer>(carta);
                        carta1 = new Card(carta.size(),cartaAux);
                        mazo.add(carta1);
                    }
                }

                Cards mazo1 = new Cards(mazo.size(), mazo);
                List<Card> mazoAux = new ArrayList<Card>();
                mazoAux = mazo1.getMazo();
                for (int i= 0; i< mazoAux.size(); i++){

                    System.out.println("Carta n°" + (i+1) + ": " +  mazoAux.get(i).getElementos());

                }
                condicion = 1;

            }
        }
    }



}
