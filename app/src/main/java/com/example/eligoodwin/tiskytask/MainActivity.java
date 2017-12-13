package com.example.eligoodwin.tiskytask;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Handler pauseSplash = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pauseSplash.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent makeTasks = new Intent(MainActivity.this, CreateTodoList.class);
                startActivity(makeTasks);
            }
        }, 2000);

    }
}
