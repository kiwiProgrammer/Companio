package com.companio.splash;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.companio.login.LoginActivity;
import com.companio.tools.Typefaces;
import com.example.kiwi.companio.R;


public class SplashActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        this.context = this.getApplicationContext();

        Typeface type = Typefaces.get(getApplicationContext(), "fonts/monserrat.ttf");
        ((TextView) this.findViewById(R.id.title)).setTypeface(type);
        ((TextView) this.findViewById(R.id.description)).setTypeface(type);


        Thread lTimer = new Thread() {

            public void run() {

                try {
                    int lTimer1 = 0;
                    while (lTimer1 < 5000) {
                        sleep(100);
                        lTimer1 = lTimer1 + 100;
                    }
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                finally {
                    finish();
                }
            }
        };
        lTimer.start();

    }

}
