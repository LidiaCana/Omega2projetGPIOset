package com.beta.pc.cleverhome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("CleverHome:");
            builder.setMessage("Lidia Canales \nin.canaless@gmail.com");
            builder.setPositiveButton("OK",null);
            builder.create();
            builder.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Activity_luces(View view){
        Intent ActivityLuces = new Intent(this,Main2Activity.class);
        startActivity(ActivityLuces);
    }

    public void Activity_Despertador(View view){
        Intent ActivityAlarma = new Intent(this,DespertadorActivity.class);
        startActivity(ActivityAlarma);
    }

    public void Activity_aire(View view){
        Intent ActivityAire = new Intent(this,AireActivity.class);
        startActivity(ActivityAire);
        Toast.makeText(getApplicationContext(),"Estamos en construccion",Toast.LENGTH_SHORT).show();
    }
    public void Activity_puerta(View view){
        Intent ActivityPuerta = new Intent(this,PuertaActivity.class);
        startActivity(ActivityPuerta);
        Toast.makeText(getApplicationContext(),"Estamos en construccion",Toast.LENGTH_SHORT).show();
    }

    public void Activity_alarma(View view){
        Intent ActivityAlarma = new Intent(this,AlarmaActivity.class);
        startActivity(ActivityAlarma);
    }
    public void Activity_tv(View view){
        Intent Activitytv = new Intent(this,TVActivity.class);
        startActivity(Activitytv);
        Toast.makeText(getApplicationContext(),"Estamos en construccion",Toast.LENGTH_SHORT).show();
    }

    public void Activity_ducha(View view){
        Intent Activityducha = new Intent(this,DuchaActivity.class);
        startActivity(Activityducha);
        Toast.makeText(getApplicationContext(),"Estamos en construccion",Toast.LENGTH_SHORT).show();
    }
}
