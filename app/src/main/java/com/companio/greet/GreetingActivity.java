package com.companio.greet;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;

import com.companio.recommend.RecommendActivity;
import com.example.kiwi.companio.R;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class GreetingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_greeting);

        final Activity me = this;
        final RelativeLayout layout = (RelativeLayout) findViewById(R.id.greet_root);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.greeting);

        ViewTreeObserver vto = layout.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                layout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                mp.start();
            }
        });

        findViewById(R.id.fullscreen_greet_btn).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                // TODO: Add change to next screen here
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    System.out.println("Hi");
                    Intent intent = new Intent(me.getApplicationContext(), RecommendActivity.class);
                    startActivity(intent);
                }

                return false;
            }
        });
    }
}
