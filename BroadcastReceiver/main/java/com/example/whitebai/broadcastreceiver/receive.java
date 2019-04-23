package com.example.whitebai.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class receive extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Double data = intent.getDoubleExtra("broadcast",0);
        Toast.makeText(context,"qieting:"+data,Toast.LENGTH_LONG).show();
    }
}
