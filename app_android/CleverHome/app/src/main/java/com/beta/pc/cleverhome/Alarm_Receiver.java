package com.beta.pc.cleverhome;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by pc on 4/3/2018.
 */

public class Alarm_Receiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        String state = intent.getExtras().getString("extra");
        Log.e("Reciver", "ok");
        Intent ringIntent =new Intent(context,RingtonePlayingService.class);
        Toast.makeText(context,"Wake up",Toast.LENGTH_SHORT).show();
        ringIntent.putExtra("extra", state);
        context.startService(ringIntent);
    }


}
