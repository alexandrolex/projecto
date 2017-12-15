package com.example.alejandrosalguero.geofragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DetallesFrag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DetallesFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetallesFrag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private int mParam1;


    public DetallesFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetallesFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static DetallesFrag newInstance(int param1) {
        DetallesFrag fragment = new DetallesFrag();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
        }
    }
    List<Partida> partidas ;
    TextView detall1,detall2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_detalles, container, false);
        partidas =SinglestonPartida.get(getContext()).getMtuquestion(getContext()) ;

        Collections.sort(partidas, new Comparator<Partida>() {
            @Override
            public int compare(Partida partida, Partida t1) {

                return new Integer(t1.getPuntos()).compareTo(new Integer(partida.getPuntos()));

            }
        });
        detall1 = (TextView) v.findViewById(R.id.detall1);
        detall2 = (TextView) v.findViewById(R.id.detall2);
        detall1.setText(partidas.get(mParam1).getJugador());
        detall2.setText(""+partidas.get(mParam1).getPuntos());

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event

}
