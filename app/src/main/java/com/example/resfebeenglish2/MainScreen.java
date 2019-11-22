package com.example.resfebeenglish2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class MainScreen extends Activity {
    Button simpleButton;
    String resfebeWarning = "Please wait while the application loads.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        Toast.makeText(getApplicationContext(), resfebeWarning, Toast.LENGTH_LONG).show();
        simpleButton = (Button) findViewById(R.id.simpleButton);
        simpleButton.setOnClickListener(simpleClick);
        simpleButton = (Button) findViewById(R.id.mediumButton);
        simpleButton.setOnClickListener(mediumClick);
        simpleButton = (Button) findViewById(R.id.helpButton);
        simpleButton.setOnClickListener(helpClick);
    }

    private void readWordFile(){
        InputStream stream = getResources().openRawResource(R.raw.kelime);
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream,Charset.forName("UTF-8")));
    }

    public View.OnClickListener simpleClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent simpleIntent = new Intent(MainScreen.this, SimpleScreen.class);
            startActivity(simpleIntent);
        }
    };
    public View.OnClickListener mediumClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent mediumIntent = new Intent(MainScreen.this, MediumScreen.class);
            startActivity(mediumIntent);
        }
    };
    public View.OnClickListener helpClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent helpIntent = new Intent(MainScreen.this, HelpScreen.class);
            startActivity(helpIntent);
        }
    };
}
