package com.example.whitebai.activityhacker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class HackeredActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hackered);

        Log.d("log","HackeredActivity");
        TextView textView = findViewById(R.id.text);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null&&bundle.containsKey("processname")){

            textView.setText(bundle.getString("processname"));
        }
    }

}
