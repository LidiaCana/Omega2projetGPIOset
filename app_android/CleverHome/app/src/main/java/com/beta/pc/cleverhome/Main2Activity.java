package com.beta.pc.cleverhome;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;


// librerias firebase
//import com.firebase.client.DataSnapshot;
//import com.firebase.client.Firebase;
//import com.firebase.client.FirebaseError;
//import com.firebase.client.ValueEventListener;
//import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main2Activity extends AppCompatActivity {

    Switch switch0, switch1, switch2, switch3; // dentro de la "clase" se declaran los objetos que se utilizaran
    ImageView foco0,foco1,foco2,foco3,foco4;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference pin1 = database.getReference("led");
    DatabaseReference PinAlarma = database.getReference("led1/alarma");
    DatabaseReference PinPuerta = database.getReference("led2/puerta");
    DatabaseReference pin4 = database.getReference("led3");
    DatabaseReference pin5 = database.getReference("led4");
    DatabaseReference pin6 = database.getReference("led5");
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // en el metodo que se crea la activity se inicializa los objetos a utilizar
        switch0=(Switch)findViewById(R.id.ID_habitacion1);
        switch1=(Switch)findViewById(R.id.ID_habitacion2);
        switch2=(Switch)findViewById(R.id.ID_habitacion3);
        switch3=(Switch)findViewById(R.id.ID_habitacion4);

        foco0 = (ImageView)findViewById(R.id.ID_img0);
        foco1 = (ImageView)findViewById(R.id.ID_img1);
        foco2 = (ImageView)findViewById(R.id.ID_img2);
        foco3 = (ImageView)findViewById(R.id.ID_img3);

        foco0.setImageResource(R.drawable.foco); // iniciamos con la imagen del foco apagado
        foco1.setImageResource(R.drawable.foco);
        foco2.setImageResource(R.drawable.foco);
        foco3.setImageResource(R.drawable.foco);
//metodo listener para fire base


// metodo listener para switch
       switch0. setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // metodo monitoreo de los cambios del switch
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    foco0.setImageResource(R.drawable.focoon);
                    pin1.setValue(true);
                } else {
                    foco0.setImageResource(R.drawable.foco);
                    pin1.setValue(false);
                }
            }
        }); // fin de metodo monitoreo
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    foco1.setImageResource(R.drawable.focoon);
                    pin4.setValue(true);
                } else {
                    foco1.setImageResource(R.drawable.foco);
                    pin4.setValue(false);

                }
            }
        });
        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    foco2.setImageResource(R.drawable.focoon);
                    pin5.setValue(true);
                } else {
                    foco2.setImageResource(R.drawable.foco);
                    pin5.setValue(false);

                }
            }
        });
    switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean activado) {
            if(activado){
                foco3.setImageResource(R.drawable.focoon);
                pin6.setValue(true);
            }
            else{
                foco3.setImageResource(R.drawable.foco);
                pin6.setValue(false);
            }
        }
    });

pin1.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Boolean estado= dataSnapshot.getValue(Boolean.class);
        switch0.setChecked(estado);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});

pin4.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Boolean estado = dataSnapshot.getValue(Boolean.class);
        switch1.setChecked(estado);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});

pin5.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Boolean estado= dataSnapshot.getValue(Boolean.class);
        switch2.setChecked(estado);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});
pin6.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Boolean estado = dataSnapshot.getValue(Boolean.class);
        switch3.setChecked(estado);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});

    }

}// fin clase{}