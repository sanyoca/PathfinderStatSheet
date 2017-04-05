package com.example.sanya.pathfinderstatsheet;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;

import static android.app.Activity.RESULT_OK;

public class Basicdatas extends Fragment implements View.OnClickListener{
    ImageView imageCharPic;
    View rootView;
    Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_basicdatas, container, false);
        imageCharPic = (ImageView) rootView.findViewById(R.id.image_charpic);
        Resources res = getResources();

        Spinner spinnerCharRace = (Spinner) rootView.findViewById(R.id.spinner_charrace);
        NewSpinnerAdapter racesAdapter = new NewSpinnerAdapter(getActivity(), R.layout.custom_spinner, getResources().getStringArray(R.array.races));

        spinnerCharRace.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Spinner spinnerCharClass = (Spinner) rootView.findViewById(R.id.spinner_charclass);
        ArrayAdapter<String> classesAdapter = new NewSpinnerAdapter(getActivity(), R.layout.custom_spinner, getResources().getStringArray(R.array.classes));

        spinnerCharClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerCharClass.setAdapter(classesAdapter);
        spinnerCharRace.setAdapter(racesAdapter);

        int[] intViewIds = {R.id.text_charname, R.id.text_charrace, R.id.text_charclass};
        Typeface pathfinderFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/saberregular.ttf");
        TextView textviewChangeFont;

        for(int i=0; i<=intViewIds.length-1; i++) {
            textviewChangeFont = (TextView) rootView.findViewById(intViewIds[i]);
            textviewChangeFont.setTypeface(pathfinderFont);
        }

        imageCharPic.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)  {
        // Check which request we're responding to
        if (requestCode == 1) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                Uri selectedImage = data.getData();
                try {
                    Bitmap imageToShow = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), selectedImage);
                    imageCharPic.setImageBitmap(imageToShow);
                }   catch (IOException e)  {
                    e.printStackTrace();
                }
            }
        }
    }
}
