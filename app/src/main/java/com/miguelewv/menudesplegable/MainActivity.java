package com.miguelewv.menudesplegable;

import androidx.appcompat.app.AppCompatActivity;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity

    implements NavigationView.OnNavigationItemSelectedListener, Persona1Fragment.OnFragmentInterationListener
//OJO 19. Navigation Drawer. (Programación Android Studio tutorial español) minuto 35
{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
//Funcionalidad para que regrese o se cierre el menu drawer despues de dar en el boton de atras=================
    @Override public void onBackPressed(){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.elprincipal);
        if (drawer.isDrawerOpen(GravityCompat.START)){drawer.closeDrawer(GravityCompat.START);
        }else{
        super.onBackPressed();
        }
    }
//=============================================================================================================

    public boolean onNavigationItemSelected (MenuItem item){
        int id = item.getItemId();

        boolean FragmentTransantion = false;
       // Fragment fragmentpersona1 = null;
        FragmentManager fm = getSupportFragmentManager(); //llamada del suporte del gestor de fragment


         if (id == R.id.idmenupersona1){
             Fragment fragmentpersona1 = new Persona1Fragment();// Llama por las importaciones el fragment persona (Ojo el tipo de importacion deve ser igual en el mainactivity como en el fragment "import androidx.fragment.app.Fragment;")
             FragmentTransantion = true;

             Toast.makeText(this, "Persona 1", Toast.LENGTH_SHORT).show();
            fm.beginTransaction().replace(R.id.fragmentContainerView,new Persona1Fragment()).commit();//opcion para hacer la transferencia
        }
        else
            if (id == R.id.idmenupersona2){
                Fragment fragmentpersona2 = new Persona2Fragment();// Llama por las importaciones el fragment persona (Ojo el tipo de importacion deve ser igual en el mainactivity como en el fragment "import androidx.fragment.app.Fragment;")
                FragmentTransantion = true;


                
            Toast.makeText(this, "Persona 2", Toast.LENGTH_SHORT).show();
            fm.beginTransaction().replace(R.id.elprincipal,new Persona2Fragment()).commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.elprincipal);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


   


    }

