package com.example.alejandrosalguero.geofragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RespuestaMultiple#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RespuestaMultiple extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public RespuestaMultiple() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RespuestaMultiple.
     */
    // TODO: Rename and change types and number of parameters
    public static RespuestaMultiple newInstance(String param1, String param2) {
        RespuestaMultiple fragment = new RespuestaMultiple();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    public int[] data = {R.string.multivalor1, R.string.multivalor2,R.string.multivalor3,R.string.multivalor4};
    public int[] data1 = {R.string.multivalor11, R.string.multivalor21,R.string.multivalor31,R.string.multivalor41};
    public int[] data2 = {R.string.multivalor12, R.string.multivalor22,R.string.multivalor32,R.string.multivalor42};
    public int[] data3 = {R.string.multivalor13, R.string.multivalor23,R.string.multivalor33,R.string.multivalor43};
    public int[] data4 = {R.string.multivalor14, R.string.multivalor24,R.string.multivalor34,R.string.multivalor44};
    List<Question> mtuquestion2 ;
    public Question[] TuQuestion = {
            new Question(R.string.question_1,data,2, R.mipmap.profesor),
            new Question(R.string.question_2,data1,1, R.mipmap.sagrada),
            new Question(R.string.question_3, data2,2, R.mipmap.pajaro),
            new Question(R.string.question_4,data3 ,3, R.mipmap.suspenso),
            new Question(R.string.question_5,data4,1, R.mipmap.clase),


    };
    RadioGroup grupo1;
    int opciones;
    int n = 0;
    Button botonpista;
    static final int PICK_REQUEST = 1;
    int actualizar = 0;
    private TextView mQuestionTextView, punt;
    RadioButton pregunta1,pregunta2,pregunta3,pregunta4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_respuesta_multiple, container, false);
        if (savedInstanceState != null) {

            actualizar = savedInstanceState.getInt("pregunta");
            n = savedInstanceState.getInt("numero");
        } else {

        }
        grupo1 =(RadioGroup)v.findViewById(R.id.grupo1);
        mQuestionTextView =(TextView)v.findViewById(R.id.pregunta);
        punt = (TextView) v.findViewById(R.id.puntos);
        botonpista = (Button) v.findViewById(R.id.botonPista);
        mtuquestion2=SinglestonMultiple.get(getContext()).getMtuquestion2(getContext());
        pregunta1 =(RadioButton)v.findViewById(R.id.pregunta1);
        pregunta2 =(RadioButton)v.findViewById(R.id.pregunta2);
        pregunta3 =(RadioButton)v.findViewById(R.id.pregunta3);
        pregunta4 =(RadioButton)v.findViewById(R.id.pregunta4);
        updateQuestion();

        grupo1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                // Check which radio button was clicked


                switch (id) {
                    case R.id.pregunta1:
                        opciones=0;
                        comprobar(opciones);
                        actualizar = actualizar + 1;

                        updateQuestion();

                        break;
                    case R.id.pregunta2:
                        opciones=1;
                        comprobar(opciones);
                        updateQuestion();

                        break;
                    case R.id.pregunta3:
                        opciones=2;
                        comprobar(opciones);
                        actualizar = actualizar + 1;

                        updateQuestion();

                        break;
                    case R.id.pregunta4:
                        opciones=3;
                        comprobar(opciones);
                        actualizar = actualizar + 1;

                        updateQuestion();

                        break;
                    default:
                        actualizar = actualizar + 1;

                        updateQuestion();
                        break;
                }
            }
        });
        botonpista.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                updateQuestion();

                Geofrag verpista = (Geofrag)getActivity();
                verpista.dialogo(mtuquestion2.get(actualizar).getPista());



            }
        });
        return v;
    }
    private void comprobar(int opciones) {


        //mQuestionTextView.setText(mQuestionTextView.getText()+""+TuQuestion[m].getNumero());

        if (mtuquestion2.get(actualizar).getOpcion() == opciones) {
            n = n + 1;
            punt.setText("" + n);

            Toast.makeText(getActivity(), "has acertado", Toast.LENGTH_SHORT).show();
        } else {
            n = n - 1;
            punt.setText("" + n);

            Toast.makeText(getActivity(), "Has fallado", Toast.LENGTH_SHORT).show();
        }


    }

    private void updateQuestion() {
        actualizar = (actualizar) % mtuquestion2.size();
        int question = mtuquestion2.get(actualizar).getNumero();
        mQuestionTextView.setText(question);
        int []question2 = mtuquestion2.get(actualizar).getPreguntas();
        pregunta1.setText(question2[0]);
        pregunta2.setText(question2[1]);
        pregunta3.setText(question2[2]);
        pregunta4.setText(question2[3]);
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
