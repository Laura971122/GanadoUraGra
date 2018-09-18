package com.laugracianool.ganado_uragra;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private String correo, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle args = getIntent().getExtras();

        if (args !=null){
            correo = args.getString("correo");
            password = args.getString("password");
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //asignar el menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){ //programar el menu
        int id=item.getItemId();
        if (id==R.id.Perfil){
            Intent i= new Intent (MainActivity.this, PerfilActivity.class);
            i.putExtra("correo", correo);
            i.putExtra("password", password);
            startActivity(i);
        }
        else{
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}
