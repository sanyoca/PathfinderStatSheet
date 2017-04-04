package com.example.sanya.pathfinderstatsheet;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Typeface pathfinderFont;
        pathfinderFont = Typeface.createFromAsset(getAssets(), "fonts/saberregular.ttf");

        Button newCharButton = (Button) findViewById(R.id.button_newchar);
        Button loadCharButton = (Button) findViewById(R.id.button_loadchar);

        newCharButton.setTypeface(pathfinderFont);
        loadCharButton.setTypeface(pathfinderFont);

        newCharButton.setOnClickListener(this);
        loadCharButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId())   {
            case R.id.button_newchar:
                intent = new Intent(this, NewCharacter.class);
                startActivity(intent);
                break;
            case R.id.button_loadchar:
                int intNumberOfCharacters = getSharedPreferences("characterlist", MODE_PRIVATE).getInt("numberofcharacters", 0);
                if(intNumberOfCharacters == 0)  {
                    Toast.makeText(this, getString(R.string.nochartoload), Toast.LENGTH_LONG).show();
                }   else    {
                    intent = new Intent(this, LoadCharacter.class);
                    startActivity(intent);
                }
                break;
            default:
                break;
        }
    }
}
