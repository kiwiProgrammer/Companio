package com.companio.login;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.companio.tools.Typefaces;
import com.example.kiwi.companio.R;

public class LoginActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        Typeface type = Typefaces.get(getApplicationContext(), "fonts/monserrat.ttf");
        ((TextView) this.findViewById(R.id.title)).setTypeface(type);
        this.context = this.getApplicationContext();

        ImageButton facebook = (ImageButton) this.findViewById(R.id.facebook);
        ImageButton google = (ImageButton) this.findViewById(R.id.google);
        Button login = (Button) this.findViewById(R.id.login);

        facebook.setOnClickListener(click_listener);
        google.setOnClickListener(click_listener);
        login.setOnClickListener(click_listener);
    }

    private View.OnClickListener click_listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(getApplicationContext(), com.companio.greet.GreetingActivity.class);
            startActivity(intent);

        }
    };

}