package com.miguelewv.menudesplegable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public boolean onNavigationItemSelected (MenuItem item){
        int id = item.getItemId();
        FragmentManager fm = getSupportFragmentManager(); //llamada del suporte del gestor de fragment
        if (id == R.id.idmenupersona1){
            Toast.makeText(this, "Persona 1", Toast.LENGTH_SHORT).show();
            fm.beginTransaction().replace(R.id.elprincipal,new Persona1Fragment()).commit();//opcion para hacer la transferencia
        } else if (id == R.id.idmenupersona2){
            fm.beginTransaction().replace(R.id.fragmentContainerView,new Persona2Fragment()).commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.persona2Fragment);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}