package com.example.alejandrosalguero.geofragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ViewPagers extends AppCompatActivity {
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        mPager =(ViewPager) findViewById(R.id.pager);
        FragmentManager fm = getSupportFragmentManager();

        mPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                return DetallesFrag.newInstance(position);
            }

            @Override
            public int getCount() {
               return SinglestonPartida.get(getApplicationContext()).getMtuquestion(getApplicationContext()).size();
            }
        });
int posicion = getIntent().getIntExtra("posicion",0);
        mPager.setCurrentItem(posicion);
    }
}
