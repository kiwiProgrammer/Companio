package com.companio.login;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.companio.tools.Typefaces;
import com.example.kiwi.companio.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        Typeface type = Typefaces.get(getApplicationContext(), "fonts/monserrat.ttf");
        ((TextView) this.findViewById(R.id.title)).setTypeface(type);
    }

}
