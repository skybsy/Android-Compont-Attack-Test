package com.example.whitebai.activityhacker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BroadcastReceive extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("log","BroadcastReceive");
        double data = intent.getDoubleExtra("broadcast",0);
        Toast.makeText(context,"receive:"+data,Toast.LENGTH_LONG).show();
    }
}
