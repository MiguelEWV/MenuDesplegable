package com.miguelewv.menudesplegable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

//===========================================================  Declaracion de variables  ===================================================================
    private DrawerLayout drawerLayout;
    private NavigationView navigationView ;
 //==========================================================================================================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//===================================================== LLamada del navigation view y el drawer Layout ======================================================
        drawerLayout = findViewById(R.id.idDrawerLayout);
        navigationView = findViewById(R.id.idNavigationView);

//==========================================================================================================================================================
//=========================================== Accion de los botones del NavigationView dentro del DrawerLayout =============================================
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.idmenupersona1:
                        Toast.makeText(MainActivity.this, "Persona 1 clicado",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.idmenupersona2:
                        Toast.makeText(MainActivity.this, "Persona 2 clicado",Toast.LENGTH_SHORT).show();
                        return true;
                }
                return true;
            }
        });
//===========================================================================================================================================================
    }

//==========================================  Funcionalidad para que regrese o se cierre el menu drawer despues de dar en el boton de atras=================
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.idDrawerLayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
//==========================================================================================================================================================




}

