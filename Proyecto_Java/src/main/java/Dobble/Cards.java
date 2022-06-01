package Dobble;

import java.util.ArrayList;
import java.util.List;
public class Cards {
    public Cards() {
    }

    List<String> Carta = new ArrayList<String>();

    public void push(List<String> Elements, int index){
        String Elemento = Elements.get(index);
        Carta.add(Elemento);


    }
}
