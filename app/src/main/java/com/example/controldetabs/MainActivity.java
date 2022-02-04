package com.example.controldetabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.controldetabs.Controles.PagerController;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem tab1,tab2,tab3,tab4;

    PagerController pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        tab1 = findViewById(R.id.btContacto);
        tab2 = findViewById(R.id.btCorreo);
        tab3 = findViewById(R.id.btTelefono);
        tab4=findViewById(R.id.btMensaje);


// Este adaptador servirá para controlar los cambios de los fragment
        pagerAdapter = new PagerController(getSupportFragmentManager(),
                tabLayout.getTabCount());
        // los fragment se mostratán en este vista viewPager
        viewPager.setAdapter(pagerAdapter);
        // Evento clic para los tabs
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // Obtenemos la posición del tab a mostrar
                viewPager.setCurrentItem(tab.getPosition());
                // Determinar cual fragment se presenta
                if(tab.getPosition()==0){
                    pagerAdapter.notifyDataSetChanged();
                }
                if(tab.getPosition()==1){
                    pagerAdapter.notifyDataSetChanged();
                }
                if(tab.getPosition()==2){
                    pagerAdapter.notifyDataSetChanged();
                }
                if(tab.getPosition()==3){
                    pagerAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

// Aquí ViewPager en la activity sabe cual frafment mostrar
        viewPager.addOnPageChangeListener(new
                TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
}

