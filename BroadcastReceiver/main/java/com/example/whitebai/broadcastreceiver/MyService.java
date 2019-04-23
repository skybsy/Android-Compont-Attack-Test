package com.example.whitebai.broadcastreceiver;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.white.receive");
        intentFilter.setPriority(1000);
        receive receive = new receive();
        registerReceiver(receive,intentFilter);
        return super.onStartCommand(intent, flags, startId);
    }


}
