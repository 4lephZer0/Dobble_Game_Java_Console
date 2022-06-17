package Dobble;


import java.util.*;

public class Cards {

    private int maxC;
    private int numE;
    private List<String> elements;
    private List<Card> cards;

    // CONSTRUCTOR


    public Cards(int maxC, int numE, List<String> elements) {
        this.maxC = maxC;
        this.numE = numE;
        this.elements = elements;

        int n = numE - 1;

        List<Card> mazo = new ArrayList<Card>();
        List<Integer> carta  = new ArrayList<Integer>();
        for (int i = 1; i<= n+1; i++) {
            carta.add(i);
        }
        List<Integer> cartaAux  = new ArrayList<Integer>(carta);
        Card carta1 = new Card(cartaAux.size(),cartaAux);
        mazo.add(carta1);
        for (int j=1; j<=n; j++) {
            carta.clear();
            carta.add(1);

            for (int k=1; k<=n; k++) {
                carta.add(n * j + (k+1));
            }
            cartaAux  = new ArrayList<Integer>(carta);
            carta1 = new Card(cartaAux.size(),cartaAux);
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
                carta1 = new Card(cartaAux.size(),cartaAux);
                mazo.add(carta1);
            }
        }

        this.cards = mazo;

    }

    // METODOS DE PERTENENCIA

    public boolean isDobble(Cards cards) {

        List<Card> mazo = cards.getCards();

        for (int i= 1; i<=mazo.size(); i++){

            if (i+1 == mazo.size()){}
        }

        return true;
    }

    public int getMaxC() {
        return maxC;
    }

    public void setMaxC(int maxC) {
        this.maxC = maxC;
    }

    public int getNumE() {
        return numE;
    }

    public void setNumE(int numE) {
        this.numE = numE;
    }

    public List<String> getElements() {
        return elements;
    }

    public void setElements(List<String> elements) {
        this.elements = elements;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Cards{" +
                "maxC=" + maxC +
                ", numE=" + numE +
                ", elements=" + elements +
                ", cards=" + cards +
                '}';
    }
}
