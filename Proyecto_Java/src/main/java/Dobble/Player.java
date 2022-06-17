package Dobble;

import java.util.Objects;

public class Player {

    String jugador;

    public Player(String jugador) {
        this.jugador = jugador;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return Objects.equals(getJugador(), player.getJugador());
    }

    @Override
    public String toString() {
        return "Player{" +
                "jugador='" + jugador + '\'' +
                '}';
    }
}
