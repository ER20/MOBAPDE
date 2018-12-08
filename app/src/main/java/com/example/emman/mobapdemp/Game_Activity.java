package com.example.emman.mobapdemp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Game_Activity extends AppCompatActivity {

    Ball v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.activity_game_);

        v = new Ball(this);
        setContentView(v);

    }
}
