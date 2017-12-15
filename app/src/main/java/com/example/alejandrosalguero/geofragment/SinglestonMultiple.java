package com.example.alejandrosalguero.geofragment;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alejandrosalguero on 15/11/17.
 */

public class SinglestonMultiple {
    public int[] data = {R.string.multivalor1, R.string.multivalor2,R.string.multivalor3,R.string.multivalor4};
    public int[] data1 = {R.string.multivalor11, R.string.multivalor21,R.string.multivalor31,R.string.multivalor41};
    public int[] data2 = {R.string.multivalor12, R.string.multivalor22,R.string.multivalor32,R.string.multivalor42};
    public int[] data3 = {R.string.multivalor13, R.string.multivalor23,R.string.multivalor33,R.string.multivalor43};
    public int[] data4 = {R.string.multivalor14, R.string.multivalor24,R.string.multivalor34,R.string.multivalor44};
    private static   SinglestonMultiple  singlestonPregunta;

    private static List<Question> mtuquestion2;

    private SinglestonMultiple(){

        mtuquestion2 = new ArrayList<>();
        mtuquestion2.add(new Question(R.string.question_1,data,2, R.mipmap.profesor));
        mtuquestion2.add(new Question(R.string.question_2,data1,1, R.mipmap.sagrada));
        mtuquestion2.add(new Question(R.string.question_3, data2,2, R.mipmap.pajaro));
        mtuquestion2.add(new Question(R.string.question_4,data3 ,3, R.mipmap.suspenso));
        mtuquestion2.add(new Question(R.string.question_5,data4,1, R.mipmap.clase));
    }

    public static SinglestonMultiple get(Context context){
        if (singlestonPregunta == null){
            singlestonPregunta = new SinglestonMultiple();
        }

        return singlestonPregunta;

    }

    public List<Question> getMtuquestion2(Context context){

        return mtuquestion2;
    }
}
