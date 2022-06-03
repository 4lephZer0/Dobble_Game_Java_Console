package Dobble;

import java.util.*;

public class Dobble {

    // Atributos
    private int maxC;
    private int orden;
    private List elements;

    public Dobble(int maxC, int orden, List elements) {
        this.maxC = maxC;
        this.orden = orden;
        this.elements = elements;
    }

    public int getMaxC() {
        return maxC;
    }

    public void setMaxC(int maxC) {
        this.maxC = maxC;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public List getElements() {
        return elements;
    }

    public void setElements(List elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        return "Dobble{" +
                "maxC=" + maxC +
                ", orden=" + orden +
                ", elements=" + elements +
                '}';
    }

    // Metodos
    public void GenerarMazo(List elements, int orden, int maxC){

        for(int i = 1; i <= orden+1; i = i + 1){

        }

    }

}



