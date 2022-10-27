package com.example.aprendaingls.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.aprendaingls.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        getSupportActionBar().setElevation( 0 );
    }
}