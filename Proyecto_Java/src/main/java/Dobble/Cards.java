package Dobble;

import java.util.*;

public class Cards {

    private int largo;
    private List<Card> mazo;

    public Cards(int largo, List<Card> mazo) {
        this.largo = largo;
        this.mazo = mazo;
    }

    public int getLargo() {
        return largo;
    }

    public List getMazo() {
        return mazo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public void setMazo(List<Card> mazo) {
        this.mazo = mazo;
    }

    @Override
    public String toString() {
        return "Cards{" +
                "largo=" + largo +
                ", mazo=" + mazo +
                '}';
    }
}
