package Dobble;

import java.util.*;

public class DobbleGame implements Game {

    private List<Card> mesa;
    private int numPlayers;
    private Dobble dobble;
    private String mode;
    private List<Player> jugadores;
    private List<List<Card>> cartasJugadores;
    private int turno;
    private String estado;


    public DobbleGame(int numPlayers, Dobble cards, String mode) {

        this.mesa = new ArrayList<Card>();
        this.numPlayers = numPlayers;
        this.dobble = cards;
        this.mode = mode;
        this.jugadores = new ArrayList<Player>();
        this.cartasJugadores = new ArrayList<List<Card>>();
        this.turno = 0;
        this.estado = "Aun no iniciado.";
    }

    @Override
    public List<Card> stackMode(Dobble cards){

        List<Card> cartasVolteadas = new ArrayList<Card>();

        if (cards.getCards().size() >= 2){

            cartasVolteadas.add(cards.getCards().get(0));
            cartasVolteadas.add(cards.getCards().get(1));
        }

        if (cards.getCards().size() < 2){

            System.out.println("NO QUEDAN MAS PARES DE CARTAS PARA JUGAR AL DOBBLE, POR FAVOR FINALIZAR EL JUEGO.");

        }

        return cartasVolteadas;
    }

    public DobbleGame register(DobbleGame game, Player nombreUsuario){

        if (game.getJugadores().size() < game.getNumPlayers()){

            List<Player> jugAux = new ArrayList<Player>(game.getJugadores());
            List<List<Card>> cartasJugAux = new ArrayList<List<Card>>(game.getCartasJugadores());

            jugAux.add(nombreUsuario);
            game.setJugadores(jugAux);

            List<Card> cartasJug = new ArrayList<Card>();
            cartasJugAux.add(cartasJug);
            game.setCartasJugadores(cartasJugAux);

            game.setTurno((game.getTurno() + 1));
            System.out.println("\nJUGADOR REGISTRADO CON EXITO!!\n");

        }
        else{

            System.out.println("No se pueden registrar mas usuarios.");
        }

        return game;

    }

    public Player whoseTurnIsIt(DobbleGame game){

        return game.getJugadores().get(game.getTurno()-1);
    }

    public DobbleGame play(DobbleGame game, String accion, String elemento){

        if (accion.equals("1")){

            game.setMesa(stackMode(game.getDobble()));
            Dobble dobbleAux = game.getDobble();
            List<Card> mazoAux = game.getDobble().getCards().subList(2, game.getDobble().getCards().size());
            dobbleAux.setCards(mazoAux);
            game.setDobble(dobbleAux);
            game.setEstado("Iniciado");


        }else if (accion.equals("2")){

            if (game.getMesa().get(0).getElementos().contains(elemento) || game.getMesa().get(1).getElementos().contains(elemento)){

                List<List<Card>> cartasJug = new ArrayList<List<Card>>(game.getCartasJugadores());

                cartasJug.get(game.getTurno()-1).add(game.getMesa().get(0));
                cartasJug.get(game.getTurno()-1).add(game.getMesa().get(1));
                game.setCartasJugadores(cartasJug);

                Integer a = game.getTurno();
                if (a.equals(game.getNumPlayers())){

                    game.setTurno(1);
                }

                else{
                    game.setTurno(game.getTurno()+1);
                }
            }

            else{

                System.out.println("El elemento ingresado no está en comun entre las 2 cartas de la mesa...");
                System.out.println("Se pasa al siguiente turno.");

                Integer a = game.getTurno();
                if (a.equals(game.getNumPlayers())){

                    game.setTurno(1);
                }

                else{
                    game.setTurno(game.getTurno()+1);
                }

                Dobble dobbleAux = game.getDobble();
                List<Card> mazoAux = game.getDobble().getCards();
                mazoAux.add(game.getMesa().get(1));
                mazoAux.add(game.getMesa().get(0));
                dobbleAux.setCards(mazoAux);
                game.setDobble(dobbleAux);

            }

        }else if (accion.equals("3")){

            System.out.println("Se pasa al siguiente turno.");

            Integer a = game.getTurno();
            if (a.equals(game.getNumPlayers())){

                game.setTurno(1);
            }

            else{
                game.setTurno(game.getTurno()+1);
            }

            Dobble dobbleAux = game.getDobble();
            List<Card> mazoAux = game.getDobble().getCards();
            mazoAux.add(game.getMesa().get(1));
            mazoAux.add(game.getMesa().get(0));
            dobbleAux.setCards(mazoAux);
            game.setDobble(dobbleAux);


        }else if (accion.equals("4")){

            //finish

            Player ganador = game.getJugadores().get(0);
            Integer puntaje = game.getCartasJugadores().get(0).size();
            Integer puntaje2 = 0;
            Player ganador2;
            for (int i = 0; i < game.getNumPlayers(); i++){

                if (game.getCartasJugadores().get(i).size() > puntaje){
                    puntaje = game.getCartasJugadores().get(i).size();
                    ganador = game.getJugadores().get(i);

                }else if(puntaje.equals(game.getCartasJugadores().get(i).size())){

                    puntaje2 = game.getCartasJugadores().get(i).size();
                    ganador2 = game.getJugadores().get(i);

                }

            }

            if (puntaje.equals(puntaje2)){

                System.out.println("Se declara un empate en el juego.");
            }
            else{
                System.out.println("El ganador del juego es el jugador: " + ganador.getJugador());
            }
            game.setEstado("Terminado");

        }

        return game;
    }

    public String status(DobbleGame game){

        return game.getEstado();
    }

    public Integer score(DobbleGame game, String Usuario){

        Integer posicion = game.getJugadores().indexOf(Usuario);
        return game.getCartasJugadores().get(posicion).size();
    }



    public List<Card> getMesa() {
        return mesa;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public Dobble getDobble() {
        return dobble;
    }

    public String getMode() {
        return mode;
    }

    public List<Player> getJugadores() {
        return jugadores;
    }

    public List<List<Card>> getCartasJugadores() {
        return cartasJugadores;
    }

    public int getTurno() {
        return turno;
    }

    public String getEstado() {
        return estado;
    }

    public void setMesa(List<Card> mesa) {
        this.mesa = mesa;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public void setDobble(Dobble dobble) {
        this.dobble = dobble;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setJugadores(List<Player> jugadores) {
        this.jugadores = jugadores;
    }

    public void setCartasJugadores(List<List<Card>> cartasJugadores) {
        this.cartasJugadores = cartasJugadores;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DobbleGame)) return false;
        DobbleGame that = (DobbleGame) o;
        return getNumPlayers() == that.getNumPlayers() && getTurno() == that.getTurno() && Objects.equals(getMesa(), that.getMesa()) && Objects.equals(getDobble(), that.getDobble()) && Objects.equals(getMode(), that.getMode()) && Objects.equals(getJugadores(), that.getJugadores()) && Objects.equals(getCartasJugadores(), that.getCartasJugadores());
    }

    @Override
    public String toString() {
        return "DobbleGame:" +
                "\nmesa=" + mesa +
                "\nnumPlayers=" + numPlayers +
                "\ndobble=" + dobble +
                "\nmode=" + mode +
                "\njugadores=" + jugadores +
                "\ncartasJugadores=" + cartasJugadores +
                "\nturno=" + turno +
                "\nestado=" + estado;
    }


}
