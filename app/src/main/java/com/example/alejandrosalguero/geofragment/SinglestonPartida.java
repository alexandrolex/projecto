package com.example.alejandrosalguero.geofragment;

import android.content.Context;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by alejandrosalguero on 21/11/17.
 */

public class SinglestonPartida {
    private static   SinglestonPartida  singlestonPartida;

    private static List<Partida> Partidas;
    java.util.Date utilDate = new java.util.Date();
    private SinglestonPartida(){


        Partidas = new ArrayList<>();
        Partidas.add(new Partida("Alejandro",0,"VF",utilDate));



    }

    public static SinglestonPartida get(Context context){
        if (singlestonPartida == null){
            singlestonPartida = new SinglestonPartida();
        }

        return singlestonPartida;

    }
    public List<Partida> getMtuquestion(Context context){

        return Partidas;
    }


    public static void addve(Partida text){
        Partidas.add(text);
    }

}
