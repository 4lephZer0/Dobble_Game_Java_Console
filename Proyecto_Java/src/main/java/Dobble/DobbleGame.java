package Dobble;

import java.util.*;

public class DobbleGame {

    private List<Card> mesa;
    private int numPlayers;
    private Dobble dobble;
    private String mode;
    private List<String> jugadores;
    private List<List<Card>> cartasJugadores;
    private int turno;


    public DobbleGame(int numPlayers, Dobble cards, String mode) {

        this.mesa = new ArrayList<Card>();
        this.numPlayers = numPlayers;
        this.dobble = cards;
        this.mode = mode;
        this.jugadores = new ArrayList<String>();
        this.cartasJugadores = new ArrayList<List<Card>>();
        this.turno = 0;
    }

    public List<Card> stackMode(Dobble cards){

        List<Card> cartasVolteadas = new ArrayList<Card>();

        if (cards.getCards().size() > 2){

            cartasVolteadas.add(cards.getCards().get(0));
            cartasVolteadas.add(cards.getCards().get(1));
        }

        return cartasVolteadas;
    }

    public DobbleGame register(DobbleGame game, String nombreUsuario){

        if (game.getNumPlayers() < game.getJugadores().size()){

            List<String> jugAux = new ArrayList<String>(game.getJugadores());
            List<List<Card>> cartasJugAux = new ArrayList<List<Card>>(game.getCartasJugadores());

            jugAux.add(nombreUsuario);
            game.setJugadores(jugAux);

            List<Card> cartasJug = new ArrayList<Card>();
            cartasJugAux.add(cartasJug);
            game.setCartasJugadores(cartasJugAux);

            game.setTurno((game.getTurno() + 1));

        }

        return game;

    }

    public String whoseTurnIsIt(DobbleGame game){

        return game.getJugadores().get(game.getTurno());
    }

    public DobbleGame play(DobbleGame game, Integer accion, String elemento){

        if (accion.equals(1)){

            game.setMesa(stackMode(game.getDobble()));
            Dobble dobbleAux = game.getDobble();
            List<Card> mazoAux = game.getDobble().getCards().subList(2, game.getDobble().getCards().size());
            dobbleAux.setCards(mazoAux);
            game.setDobble(dobbleAux);

        }

        if (accion.equals(2)){

            if (game.getMesa().get(0).getElementos().contains(elemento) || game.getMesa().get(1).getElementos().contains(elemento)){

                List<List<Card>> cartasJug = new ArrayList<List<Card>>(game.getCartasJugadores());

                List<Card> cartaJug = new ArrayList<Card>();
                cartaJug = cartasJug.get(game.getTurno());

                cartaJug.add(game.getMesa().get(0));
                cartaJug.add(game.getMesa().get(1));

                // TAREA PENDIENTE: HACE QUE LA LISTA DE CARTAS DE UN JUGADOR SE META A LA LISTA DE CARTAS DE LOS JUGADORES TAL Y COMO ESTABA.

            }

        }

        return game;
    }

    public List<Card> getMesa() {
        return mesa;
    }

    public void setMesa(List<Card> mesa) {
        this.mesa = mesa;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public Dobble getDobble() {
        return dobble;
    }

    public void setDobble(Dobble dobble) {
        this.dobble = dobble;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public List<String> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<String> jugadores) {
        this.jugadores = jugadores;
    }

    public List<List<Card>> getCartasJugadores() {
        return cartasJugadores;
    }

    public void setCartasJugadores(List<List<Card>> cartasJugadores) {
        this.cartasJugadores = cartasJugadores;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
}
