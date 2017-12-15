package com.example.alejandrosalguero.geofragment;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Geofrag extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
int contador;
    private RecyclerView recyclerView;
    private Resultados mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana);
        String pregunta= getResources().getString(R.string.question_1);
        String pregunta1= getResources().getString(R.string.question_2);
        String pregunta2= getResources().getString(R.string.question_3);
        String pregunta3= getResources().getString(R.string.question_4);
        String pregunta4= getResources().getString(R.string.question_5);
        SinglestonPregunta.get(this).addve(new Question(pregunta, true, R.mipmap.profesor));
        SinglestonPregunta.get(this).addve(new Question(pregunta1, false, R.mipmap.sagrada));
        SinglestonPregunta.get(this).addve(new Question(pregunta2, true, R.mipmap.pajaro));
        SinglestonPregunta.get(this).addve(new Question(pregunta3, true, R.mipmap.suspenso));
        SinglestonPregunta.get(this).addve(new Question(pregunta4, false, R.mipmap.clase));



         FragmentManager fm= getSupportFragmentManager();
         Fragment fragment= new RespuestaMultiple();
        fm.beginTransaction().replace(R.id.fragment1,fragment).addToBackStack(null).commit();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, " Para cambiar lo tienes arriba gfdgdfhdfhdfhdfhdfhdfhhfdhdfdfhfdhdf", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setTitle(null);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        int param =0;
        switch (item.getItemId()) {
            case R.id.action_settings:
                FragmentManager fm= getSupportFragmentManager();
                Fragment fragment= new GeoFragmentos();
                fm.beginTransaction().replace(R.id.fragment1,fragment).addToBackStack(null).commit();
                return true;
            case R.id.action_settings2:
                FragmentManager fm1= getSupportFragmentManager();
                Fragment fragment1= new RespuestaMultiple();
                fm1.beginTransaction().replace(R.id.fragment1,fragment1).addToBackStack(null).commit();
                return true;
            case R.id.action_settings3:
                PreguntaDialogo newFragment =  PreguntaDialogo.newInstance(param);
                newFragment.show(getFragmentManager(),"dialogo");
                return true;
            case R.id.action_settings4:
                FragmentManager fm2= getSupportFragmentManager();
                Resultados fragment2= new Resultados();
                fm2.beginTransaction().replace(R.id.fragment1,fragment2).addToBackStack(null).commit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        int param =0;
        if (id == R.id.nav_camera) {
            FragmentManager fm= getSupportFragmentManager();
            Fragment fragment= new GeoFragmentos();
            fm.beginTransaction().replace(R.id.fragment1,fragment).addToBackStack(null).commit();
            return true;

        } else if (id == R.id.nav_gallery) {
            FragmentManager fm1= getSupportFragmentManager();
            Fragment fragment1= new RespuestaMultiple();
            fm1.beginTransaction().replace(R.id.fragment1,fragment1).addToBackStack(null).commit();

            return true;

        } else if (id == R.id.nav_slideshow) {
            PreguntaDialogo newFragment =  PreguntaDialogo.newInstance(param);
            newFragment.show(getFragmentManager(),"dialogo");
            return true;


        }  else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void doPositiveClick() {

    }

    public void doNegativeClick() {
        // Do stuff here.
    }
    public  void verpista(int pista){
        FragmentManager fm= getSupportFragmentManager();
        Fragment fragment2= fragmentpista.newInstance(pista);
        fm.beginTransaction().replace(R.id.fragment1,fragment2).addToBackStack(null).commit();

    }



    public  void vergeo(int pista){

        FragmentManager fm= getSupportFragmentManager();
        Fragment fragment2= GeoFragmentos.newInstance(pista);
        fm.beginTransaction().replace(R.id.fragment1,fragment2).addToBackStack(null).commit();

    }
    public  void dialogo(int pista){
        Dialogpista newFragment = Dialogpista.newInstance(pista);
        newFragment.show(getSupportFragmentManager(),"dialogo");
    }
    public  void dialogo2(int pista){
        DialogReinicio newFragment = DialogReinicio.newInstance(pista);
        newFragment.show(getSupportFragmentManager(),"dialogo");
    }

    @Override
    public void onBackPressed() {
        int count = getFragmentManager().getBackStackEntryCount();

        if (count>0) {
            getFragmentManager().popBackStack();
       } else {
            super.onBackPressed();
        }

    }


}
