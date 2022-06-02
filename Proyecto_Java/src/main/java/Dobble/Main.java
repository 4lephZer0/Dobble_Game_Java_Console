package Dobble;

import java.util.*;

public class Main {
    public static void main(String args[]){
        List Lista = new ArrayList();
        Card Carta1 = new Card(20, Lista);
        System.out.println(Carta1);
        Carta1.setLargo(10);
        System.out.println(Carta1);
    }



}
