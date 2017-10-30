package com.example.alejandrosalguero.geofragment;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Geofrag extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geofrags);
        final FragmentManager fm= getSupportFragmentManager();
        final GeoFragmentos fragment= new GeoFragmentos();
        fm.beginTransaction().replace(R.id.fragment1,fragment).commit();
        final Fragment fragment2= new fragmentpista();
        fm.beginTransaction().replace(R.id.fragment1,fragment2).commit();



        Button boton3 = (Button) findViewById(R.id.button3);

        boton3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment1,  fragment2);

                transaction.addToBackStack(null);


                transaction.commit();

            }
        });

    }

}
