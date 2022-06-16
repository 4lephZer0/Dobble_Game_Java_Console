package Dobble;

import java.util.*;

public class Dobble {

    // Atributos
    private int maxC;
    private int numE;
    private List elements;

    // Metodos Constructores

    public Dobble(int maxC, int numE, List elements) {
        this.maxC = maxC;
        this.numE = numE;
        this.elements = elements;
    }

    // Metodos de pertenencia

    public boolean isDobble(List<Card> mazo) {

    }

    public int getMaxC() {
        return maxC;
    }
    public int getNumE() {
        return numE;
    }
    public List getElements() {
        return elements;
    }

    public void setMaxC(int maxC) {
        this.maxC = maxC;
    }

    public void setNumE(int numE) {
        this.numE = numE;
    }

    public void setElements(List elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        return "Dobble{" +
                "maxC=" + maxC +
                ", orden=" + numE +
                ", elements=" + elements +
                '}';
    }
}



