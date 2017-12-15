package com.example.alejandrosalguero.geofragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.category;
import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GeoFragmentos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GeoFragmentos extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private static int mParam1 ;



    public GeoFragmentos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GeoFragmentos.
     */
    // TODO: Rename and change types and number of parameters
    public static GeoFragmentos newInstance(int param1) {
        GeoFragmentos fragment = new GeoFragmentos();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);        }
    }

    int n = 0;
    static final int PICK_REQUEST = 1;
    int actualizar = 0;
    private TextView mQuestionTextView;

    List<Question> mtuquestion ;
    List<Partida> partidas ;

/*
    public Question[] TuQuestion = {
            new Question(R.string.question_1, true, R.mipmap.profesor),
            new Question(R.string.question_2, false, R.mipmap.sagrada),
            new Question(R.string.question_3, true, R.mipmap.pajaro),
            new Question(R.string.question_4, true, R.mipmap.suspenso),
            new Question(R.string.question_5, false, R.mipmap.clase),


    };*/

    private TextView punt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_geofragmentos, container, false);
        if (savedInstanceState != null) {

            actualizar = savedInstanceState.getInt("pregunta");
            n = savedInstanceState.getInt("numero");
        } else {

        }
        mtuquestion=SinglestonPregunta.get(getContext()).getMtuquestion(getContext());

        ImageButton boton1 = (ImageButton) v.findViewById(R.id.button);
        ImageButton boton2 = (ImageButton) v.findViewById(R.id.button2);
        Button boton3 = (Button) v.findViewById(R.id.button3);
        Button boton5 = (Button) v.findViewById(R.id.button5);

        punt = (TextView) v.findViewById(R.id.puntuacion);
        partidas =SinglestonPartida.get(getContext()).getMtuquestion(getContext()) ;
                mQuestionTextView = (TextView) v.findViewById(R.id.question);

        updateQuestion();

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              /*  for(n=0;n<TuQuestion.length;n++){
                if(TuQuestion[n].isRespuesta()==true && TuQuestion[n].isRespuesta()==false){
                    Toast.makeText(GeoText.this, "es verdad muy bien", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(GeoText.this, "Has fallado", Toast.LENGTH_SHORT).show();
                }}*/
                Toast.makeText(getActivity(), " Le has dado a cierto", Toast.LENGTH_SHORT).show();
                comprobar(true);
                actualizar = actualizar + 1;

                updateQuestion();
               /* if(puntuacion>=5) {
                    mQuestionTextView.setText(TuQuestion[puntuacion].getNumero());
                }*/
            }


        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  if(TuQuestion[n].isRespuesta()==false){
                    Toast.makeText(GeoText.this, "es falso muy bien", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(GeoText.this, "Has fallado", Toast.LENGTH_SHORT).show();
                }*/
                Toast.makeText(getActivity(), "Le has dado a falso", Toast.LENGTH_SHORT).show();
                comprobar(false);
                actualizar = actualizar + 1;
                updateQuestion();

/*if(puntuacion>=5){
                mQuestionTextView.setText(TuQuestion[puntuacion].getNumero());
            }*/

            }
        });

        boton3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                updateQuestion();

                Geofrag verpista = (Geofrag)getActivity();

               verpista.dialogo(mtuquestion.get(actualizar).getPista());



            }
        });
        boton5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



               // Intent valorar = new Intent(getActivity(), Valorar.class);
                //startActivity(valorar);
            }
        });
        return v;
    }

    private void comprobar(boolean pulsado) {



        //mQuestionTextView.setText(mQuestionTextView.getText()+""+TuQuestion[m].getNumero());

        if (mtuquestion.get(actualizar).isRespuesta() == pulsado) {
            n = n + 1;

                partidas.get(partidas.size()-1).setPuntos(n);      punt.setText("" + n);




                Toast.makeText(getActivity(), "has acertado", Toast.LENGTH_SHORT).show();
        } else {
            n = n - 1;



                partidas.get(partidas.size()-1).setPuntos(n);

                punt.setText("" + n);



            Toast.makeText(getActivity(), "Has fallado", Toast.LENGTH_SHORT).show();
        }


    }

    private void updateQuestion() {
        mtuquestion=SinglestonPregunta.get(getContext()).getMtuquestion(getContext());
        Geofrag verpista = (Geofrag)getActivity();
int param=0;

        if(actualizar==mtuquestion.size()){
            actualizar=actualizar-1; verpista.dialogo2(param);

        }else{
        String question = mtuquestion.get(actualizar).getNombre();


        mQuestionTextView.setText(question);}
       // mQuestionTextView.setText(question2);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == PICK_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {

            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("pregunta", actualizar);
        outState.putInt("numero", n);

    }


}

