package com.example.whitebai.activityhacker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Intent intent1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ActivityStart = findViewById(R.id.activity1);
        Button ActivityStop = findViewById(R.id.activity2);
        Button BroadcastStart = findViewById(R.id.broadcastStart);
        Button BroadcastStop = findViewById(R.id.broadcastStop);

        ActivityStart.setOnClickListener(this);
        ActivityStop.setOnClickListener(this);
        BroadcastStart.setOnClickListener(this);
        BroadcastStop.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity1:
                Log.d("log","R.id.activity1");
                intent1 = new Intent(MainActivity.this,HackerService.class);
                startService(intent1);
                break;
            case R.id.activity2:
                Log.d("log","R.id.activity2");
                stopService(intent1);
                break;
            case R.id.broadcastStart:
                Log.d("log","R.id.broadcast");
                Intent intent = new Intent();
                intent.setAction("com.white.receive");
                intent.putExtra("broadcast",Math.random());
                sendBroadcast(intent);
                break;
        }
    }
}
