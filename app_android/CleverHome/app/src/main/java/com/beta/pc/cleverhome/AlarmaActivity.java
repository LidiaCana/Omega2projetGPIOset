package com.beta.pc.cleverhome;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.TooltipCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AlarmaActivity extends AppCompatActivity {

    EditText password;
    Button activarAlarm, desactivarAlarm;
    ImageView imagenGuardia;
    String acceso_pasword="1234";
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference on_of_alarma =database.getReference("led1/on_off_alarma");


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarma);
        password = (EditText)findViewById(R.id.ID_pasword);
        activarAlarm = (Button)findViewById(R.id.ID_activarAlarma);
        desactivarAlarm = (Button)findViewById(R.id.ID_desactivarAlarma);
        imagenGuardia = (ImageView)findViewById(R.id.ID_imag_guardia);

        //imagenGuardia.setTooltipText("jjjjj");

    activarAlarm.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String paswordUsuario = password.getText().toString();
    if (acceso_pasword.equals(paswordUsuario)){
        Toast.makeText(getApplicationContext(),"Contraseña correcta \n alarma activada",Toast.LENGTH_SHORT).show();
        on_of_alarma.setValue(true);

    }else {
        Toast.makeText(getApplicationContext(),"Contraseña incorrecta",Toast.LENGTH_SHORT).show();
    }
            password.setText("");
        }
    });

    desactivarAlarm.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String paswordUsuario = password.getText().toString();
            if (acceso_pasword.equals(paswordUsuario)){
                Toast.makeText(getApplicationContext(),"Contraseña correcta \nalarma desactivado",Toast.LENGTH_SHORT).show();
                on_of_alarma.setValue(false);


            }else {
                Toast.makeText(getApplicationContext(),"Contraseña incorrecta",Toast.LENGTH_SHORT).show();
            }
            password.setText("");
    }
    });
    }
}
