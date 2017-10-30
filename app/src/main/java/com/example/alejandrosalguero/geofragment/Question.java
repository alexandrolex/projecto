package com.example.alejandrosalguero.geofragment;

/**
 * Created by alejandrosalguero on 21/09/17.
 */

class Question {
    private int Numero;
    private boolean Respuesta;
    private int pista;

    public int getPista() {
        return pista;
    }

    public void setPista(int pista) {
        this.pista = pista;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        Numero = Numero;
    }

    public boolean isRespuesta() {

        return Respuesta;
    }

    public void setRespuesta(boolean Respuesta) {
        Respuesta = Respuesta;
    }
    public Question(int Numero, boolean Respuesta, int Pistas) {
        this.Numero = Numero;
        this.Respuesta = Respuesta;
        this.pista = Pistas;
    }

    @Override
    public String toString() {
        return "Question{" +
                "Numero=" + Numero +
                ", Respuesta=" + Respuesta +
                ' '+pista;
    }
}
