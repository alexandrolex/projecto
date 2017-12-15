package com.example.alejandrosalguero.geofragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.List;

/**
 * Created by alejandrosalguero on 21/11/17.
 */

public class DialogReinicio extends DialogFragment {
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private int param;
    public DialogReinicio() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static DialogReinicio newInstance(int param) {
        DialogReinicio frag = new DialogReinicio();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param);
        frag.setArguments(args);
        return frag;
    }
    Partida[] Partidas ;
    List<Partida> partidas ;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v= LayoutInflater.from(getActivity()).inflate(R.layout.fragment_dialog_reiniciar,null);
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(getActivity());
        builder.setView(v);
        builder.setMessage("Quieres Reiniciar las  preguntas?");
        builder.setCancelable(false);
        setCancelable(false);
        Geofrag verpista = (Geofrag)getActivity();
        verpista.vergeo(param);
        builder.setPositiveButton(R.string.alert_dialog_ok,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        java.util.Date utilDate = new java.util.Date();
                       // partidas =SinglestonPartida.get(getContext()).getMtuquestion(getContext()) ;


                        //partidas.get(0).getPuntos();

                        Partida[]  Partidas= {
                              new Partida("Alejandro",0,"VF",utilDate)
                        };


                       SinglestonPartida.addve(Partidas[param]);


                    }
                }
        );
        builder.setNegativeButton(R.string.alert_dialog_cancel,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                    }
                }
        );
        return builder.create();

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            param = getArguments().getInt(ARG_PARAM1);

        }
    }


}
