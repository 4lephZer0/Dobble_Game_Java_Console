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
            System.out.println("[2] Para Registrar Usuarios");
            System.out.println("[3] Para Jugar");
            System.out.println("[4] Para terminar el juego");
            System.out.println("-----------------------------");
            System.out.print("Opcion: ");
            String opcion = escaneo.nextLine();

            Dobble mazo;
            DobbleGame juego = null;

            if (opcion.equals("1")){
                System.out.print("Ingrese la cantidad maxima de cartas: ");
                String maxC1  = escaneo.nextLine();
                int maxC = Integer.parseInt(maxC1);

                System.out.print("Ingrese la cantidad de elementos por carta: ");
                String numE1  = escaneo.nextLine();
                Integer numE = Integer.parseInt(numE1);

                int condicion2 = 0;
                while (condicion2 != 1){

                    System.out.print("Ingrese una lista de elementos (EJEMPLO: A,B,C,D,E)\n" +
                            "Procure que sea del mismo tamaño que la cantidad de elementos por carta: ");
                    String cadena  = escaneo.nextLine();
                    List<String> elements = new ArrayList<String>(Arrays.asList(cadena.split(",")));
                    if (numE.equals(elements.size())){
                        condicion2 = 1;
                    }

                }
                String cadena  = escaneo.nextLine();
                List<String> elements = new ArrayList<String>(Arrays.asList(cadena.split(",")));
                mazo = new Dobble(maxC, numE, elements);

                System.out.println(mazo);

                System.out.println("MAZO CREADO CORRECTAMENTE!!!\n");

                System.out.print("Ingrese la cantidad de jugadores maximo a registrar: ");
                String cantJug  = escaneo.nextLine();
                Integer cantidadJugadores = Integer.parseInt(cantJug);

                juego = new DobbleGame(cantidadJugadores, mazo,"stackMode");

                System.out.println("JUEGO CREADO CORRECTAMENTE!!!\n");
                System.out.println("Ahora ingrese la opcion 2 para registrar jugadores.\n");

            }else if (opcion.equals("2")){

                System.out.print("Ingrese el nombre del jugador a registrar: ");
                String player  = escaneo.nextLine();
                Player jugador = new Player(player);

                juego.register(juego, jugador);

            }else if (opcion.equals("3")){

                Integer condicion3 = 0;
                System.out.print("para empezar el juego, ingrese alguna de las siguientes opciones: ");

                while (condicion3 != 1){

                    System.out.println("## TURNO DE " + juego.whoseTurnIsIt(juego) + " ##");
                    System.out.println("-----------------------------");
                    System.out.println("[1] Para extraer 2 cartas del mazo (en caso de ya haber 2 cartas, por favor no utilizar.)");
                    System.out.println("[2] Para nombrar la coincidencia (en caso de haber extraido 2 cartas)");
                    System.out.println("[3] Para pasar el turno");
                    System.out.println("[4] Para finalizar la partida");
                    System.out.println("-----------------------------");
                    System.out.print("Opcion: ");
                    String opcion1 = escaneo.nextLine();

                    if (opcion1.equals("1")){

                        juego = juego.play(juego,opcion1, "");

                        System.out.println("## CARTAS EN LA MESA ##");
                        System.out.println("-----------------------------");
                        System.out.println("Carta 1: " + juego.getMesa().get(0));
                        System.out.println("Carta 2: " + juego.getMesa().get(1));
                        System.out.println("-----------------------------");

                    }else if (opcion1.equals("2")){

                        System.out.print("Ingrese el elemento de coincidencia: ");
                        String elemento = escaneo.nextLine();
                        juego = juego.play(juego, opcion1, elemento);

                    }else if (opcion1.equals("3")){

                        juego = juego.play(juego, opcion1, "");

                    }else if (opcion1.equals("4")){

                        juego = juego.play(juego, opcion1, "");
                        condicion3 = 1;
                    }



                }

            }else if (opcion.equals("4")){

                System.out.println("PROGRAMA FINALIZADO.");
                condicion = 1;
            }
        }
    }
}