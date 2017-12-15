package com.example.alejandrosalguero.geofragment;
import java.util.Date;
/**
 * Created by alejandrosalguero on 21/11/17.
 */

public class Partida {
    private int puntos;
    private String tipojuego;
    private Date creationDate;
    private String Jugador;
    private String tiempo;

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getTipojuego() {
        return tipojuego;
    }

    public void setTipojuego(String tipojuego) {
        if (tipojuego=="M" || tipojuego=="VF"){
        this.tipojuego = tipojuego;}
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getJugador() {
        return Jugador;
    }

    public void setJugador(String jugador) {
        Jugador = jugador;
    }

    public int getPuntos() {

        return puntos;
    }

    public void setPuntos(int puntos) {

        this.puntos = puntos;
    }

    public Partida(String Jugador, int puntos, String tipojuego,Date creationDate) {
        this.Jugador = Jugador;
        this.puntos = puntos;
        this.tipojuego = tipojuego;
        this.creationDate = creationDate;
    }
    public Partida(String Jugador, int puntos, String tiempo) {
        this.Jugador = Jugador;
        this.puntos = puntos;
        this.tiempo = tiempo;

    }

    @Override
    public String toString() {
        return "Partida{" +
                "puntos=" + puntos +
                ", tipojuego='" + tipojuego + '\'' +
                ", creationDate=" + creationDate +
                ", Jugador='" + Jugador + '\'' +
                tiempo;
    }


}
