package com.example.alejandrosalguero.geofragment;

import java.util.Arrays;

/**
 * Created by alejandrosalguero on 21/09/17.
 */

class Question {
    private int Numero;
    private boolean Respuesta;
    private int pista;
    private int [] preguntas;
    private int opcion;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int[] getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(int[] preguntas) {
        this.preguntas = preguntas;
    }

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

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



    public Question(String nombre, boolean Respuesta, int Pistas) {
        this.nombre = nombre;
        this.Respuesta = Respuesta;
        this.pista = Pistas;
    }

    @Override
    public String toString() {
        return "Question{" +
                "Numero=" + Numero +
                ", pista=" + pista +
                ", preguntas=" + Arrays.toString(preguntas) +
                ", opcion=" + opcion +
                '}';
    }

    public Question(int Numero, int [] preguntas, int opcion, int Pistas) {
        this.Numero = Numero;
        this.preguntas = preguntas;
        this.opcion = opcion;
        this.pista = Pistas;
    }
    public Question(String Nombre, boolean Respuesta) {
        this.nombre = Nombre;
        this.Respuesta = Respuesta;

    }
}
