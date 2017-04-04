package com.example.sanya.pathfinderstatsheet;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by sanya on 2017.04.04..
 */

public class LoadCharacter extends AppCompatActivity {
    String[] stringCharacters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loadcharacter);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Typeface pathfinderFont;
        pathfinderFont = Typeface.createFromAsset(getAssets(), "fonts/saberregular.ttf");

        TextView textviewSelectToLoad= (TextView) findViewById(R.id.textview_selectload);
        Button buttonLoad = (Button) findViewById(R.id.button_load);

        textviewSelectToLoad.setTypeface(pathfinderFont);
        buttonLoad.setTypeface(pathfinderFont);

        Spinner spinnerCharacters = (Spinner) findViewById(R.id.spinner_characterstoload);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_character_load, stringCharacters);
        spinnerCharacters.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinnerCharacters.setAdapter(adapter);
    }
}
