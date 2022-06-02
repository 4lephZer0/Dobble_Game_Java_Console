package Dobble;

import java.util.ArrayList;
import java.util.List;
public class Card {

    private int largo;
    private List elementos;
    public Card(int largo, List elementos){
        this.largo = largo;
        this.elementos = elementos;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public List getElementos() {
        return elementos;
    }

    public void setElementos(List elementos) {
        this.elementos = elementos;
    }

    @Override
    public String toString() {
        return "Card{" + "largo=" + largo + ", elementos=" + elementos + '}';
    }
}