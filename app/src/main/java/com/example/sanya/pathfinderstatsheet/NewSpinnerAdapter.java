package com.example.sanya.pathfinderstatsheet;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by sanya on 2017.04.05..
 */

public class NewSpinnerAdapter extends ArrayAdapter<String> {
    // Initialise custom font, for example:
    Typeface font = Typeface.createFromAsset(getContext().getAssets(),
            "fonts/saberregular.ttf");

    // (In reality I used a manager which caches the Typeface objects)
    // Typeface font = FontManager.getInstance().getFont(getContext(), BLAMBOT);

    public NewSpinnerAdapter(Context context, int resource, String[] items) {
        super(context, resource, items);
    }

    // Affects default (closed) state of the spinner
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view = (TextView) super.getView(position, convertView, parent);
        view.setTypeface(font);
        return view;
    }

    // Affects opened state of the spinner
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView view = (TextView) super.getDropDownView(position, convertView, parent);
        view.setTypeface(font);
        return view;
    }
}