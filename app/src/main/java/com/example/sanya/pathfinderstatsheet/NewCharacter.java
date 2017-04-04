package com.example.sanya.pathfinderstatsheet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

/**
 * Created by sanya on 2017.04.04..
 */

public class NewCharacter extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newcharacter);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ViewPager vP = (ViewPager) findViewById(R.id.viewpager);
        CharacterdatasAdapter characterAdapter = new CharacterdatasAdapter(this, getSupportFragmentManager());
        vP.setAdapter(characterAdapter);

        TabLayout tL = (TabLayout) findViewById(R.id.tabs);
        tL.setupWithViewPager(vP);
    }
}
