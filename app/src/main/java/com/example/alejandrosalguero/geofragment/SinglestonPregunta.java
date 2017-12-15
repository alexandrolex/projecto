package com.example.alejandrosalguero.geofragment;

import android.content.Context;
import android.content.res.Resources;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alejandrosalguero on 15/11/17.
 */

public class SinglestonPregunta {


    private static   SinglestonPregunta  singlestonPregunta;
    private static ArrayList<Question> mtuquestion;


    private SinglestonPregunta(){


        mtuquestion = new ArrayList<>();

    }

    public static SinglestonPregunta get(Context context){
        if (singlestonPregunta == null){
            singlestonPregunta = new SinglestonPregunta();
        }

        return singlestonPregunta;

    }
    public ArrayList<Question> getMtuquestion(Context context){

        return mtuquestion;
    }
    public static void addve(Question text){
        mtuquestion.add(text);
    }

}
