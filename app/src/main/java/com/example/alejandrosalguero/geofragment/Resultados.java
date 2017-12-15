package com.example.alejandrosalguero.geofragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Resultados.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Resultados#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Resultados extends Fragment{

boolean enable=false;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private int mParam1;


    public Resultados() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Resultados.
     */
    // TODO: Rename and change types and number of parameters
    public static Resultados newInstance(int param1) {
        Resultados fragment = new Resultados();
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
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v= inflater.inflate(R.layout.fragment_resultados, container, false);
        partidas =SinglestonPartida.get(getContext()).getMtuquestion(getContext()) ;


        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);

        Resultados2 mAdapters = new Resultados2(partidas);
        recyclerView.setAdapter(mAdapters);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        return v;


    }
    public void mostrar(){

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());

        SharedPreferences.Editor editor = prefs.edit();


        editor.putString("dat", partidas.get(0).getJugador());
        editor.putInt("dat1", partidas.get(0).getPuntos());
        editor.putString("dat2", partidas.get(0).getCreationDate().toString());
        editor.putString("dat3", partidas.get(1).getJugador());
        editor.putInt("dat4", partidas.get(1).getPuntos());
        editor.putString("dat5", partidas.get(1).getCreationDate().toString());
        editor.putString("dat6", partidas.get(2).getJugador());
        editor.putInt("dat7", partidas.get(2).getPuntos());
        editor.putString("dat8", partidas.get(2).getCreationDate().toString());
        editor.commit();

    }

   private void getProfile() {

        //Para obtener los datos previamente guardados
        // simplemente empleamos el método getString()
        // del objeto SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());

        String jugador = prefs.getString("dat",null);

        int punto = prefs.getInt("dat1",0);

        String data = prefs.getString("dat2", null);

        String jugador2 = prefs.getString("dat3",null);

        int punto2 = prefs.getInt("dat4",0);

        String data2 = prefs.getString("dat5", null);

        String jugador3 = prefs.getString("dat6",null);

        int punto3 = prefs.getInt("dat7",0);

        String data3 = prefs.getString("dat8", null);
if(enable==false){
        Partida partida1= new Partida(jugador,punto,data);
       SinglestonPartida.addve(partida1);
       Partida partida2= new Partida(jugador2,punto2,data2);
       SinglestonPartida.addve(partida2);
       Partida partida3= new Partida(jugador3,punto3,data3);
       SinglestonPartida.addve(partida3);
   }
    }


    public class Resultados2 extends RecyclerView.Adapter<Resultados2.MyViewHolder> {


        public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            public TextView Nombre, puntos, date;
            public ImageView copa1, copa2, copa3;

            public MyViewHolder(View view)  {
                super(view);
                Nombre = (TextView) view.findViewById(R.id.resul1);
                puntos = (TextView) view.findViewById(R.id.resul2);
                date = (TextView) view.findViewById(R.id.resul3);
                copa1 = (ImageView) view.findViewById(R.id.copa1);
                copa2 = (ImageView) view.findViewById(R.id.copa2);
                copa3 = (ImageView) view.findViewById(R.id.copa3);


                view.setOnClickListener(this) ;

            }
            @Override
            public void onClick(View view) {

                int position = getAdapterPosition();
                Intent intent = new Intent(getContext(),ViewPagers.class);
                intent.putExtra("posicion",position);
                startActivity(intent);

            }
        }


        private List<Partida>mPartida;

        public Resultados2(List<Partida>mPartida){
            this.mPartida=mPartida;
        }
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.holder, null);
            //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);


            Collections.sort(partidas, new Comparator<Partida>() {
                @Override
                public int compare(Partida partida, Partida t1) {

                    return new Integer(t1.getPuntos()).compareTo(new Integer(partida.getPuntos()));

                }
            });
            mostrar();

            return new MyViewHolder(itemView);

        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            Partida partida = mPartida.get(position);
            holder.Nombre.setText(partida.getJugador());
            holder.puntos.setText(""+partida.getPuntos());
            holder.date.setText(partida.getCreationDate().toString());



                if(partidas.get(position)==partidas.get(0)){
                    Drawable myDrawable = getResources().getDrawable(R.drawable.trophy);
                    holder.copa1.setImageDrawable(myDrawable);

                }
                if(partidas.get(position)==partidas.get(1)){
                    Drawable myDrawable = getResources().getDrawable(R.drawable.trophy2);
                    holder.copa2.setImageDrawable(myDrawable);
                }
                if(partidas.get(position)==partidas.get(2)){
                    Drawable myDrawable = getResources().getDrawable(R.drawable.trophy3);

                    holder.copa3.setImageDrawable(myDrawable);
                }
        }

        @Override
        public int getItemCount() {
            return mPartida.size();
        }


    }


}
