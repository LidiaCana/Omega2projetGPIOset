package com.beta.pc.cleverhome;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.Calendar;
import java.util.Random;

public class DespertadorActivity extends AppCompatActivity {
 AlarmManager alarmaManager;
 TimePicker alarmaTime;
 Button BotonOn, BotonOff;
 Calendar calendar = Calendar.getInstance();
 Context context;
 PendingIntent pending;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despertador);
        this.context=this;
// inicializamos los objetos alarma

        alarmaManager =(AlarmManager)getSystemService(ALARM_SERVICE);
        alarmaTime = (TimePicker)findViewById(R.id.ID_clock);
        final Intent my_intent = new Intent(this.context,Alarm_Receiver.class);

        BotonOn = (Button)findViewById(R.id.ID_botonOn);
        BotonOff = (Button)findViewById(R.id.ID_botonOff);



        BotonOn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                calendar.add(Calendar.SECOND, 3);
                Toast.makeText(getApplicationContext(),"alarma activada",Toast.LENGTH_SHORT).show();


                final int hora = alarmaTime.getHour();
                final int min = alarmaTime.getMinute();
                Log.e("MyActivity", "In the receiver with " + hora + " and " + min);

                calendar.set(Calendar.HOUR_OF_DAY, hora);
                calendar.set(Calendar.MINUTE, min);
                my_intent.putExtra("extra", "yes");

                pending = PendingIntent.getBroadcast(DespertadorActivity.this,0,my_intent,PendingIntent.FLAG_UPDATE_CURRENT);
                // set alarm manager
                alarmaManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pending);

            }
        });

        BotonOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){



                my_intent.putExtra("extra", "no");
                sendBroadcast(my_intent);

                alarmaManager.cancel(pending);

                //setAlarmText("You clicked a " + " canceled");
            }

        });
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.e("MyActivity", "on Destroy");
    }
}
