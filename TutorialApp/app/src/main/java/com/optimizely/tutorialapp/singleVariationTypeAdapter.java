//
//  SingleVariationTypeAdapter
//  TutorialApp
//
//  This Optimizely Tutorial app will teach you how to use Optimizely's iOS SDK's
//  3 key features:
//     - Visual Editor
//     - Live Variables
//     - Code Blocks
//
//  Created by Pam Ongchin on 10/19/15.
//  Copyright (c) 2015 Optimizely. All rights reserved.
//

package com.optimizely.tutorialapp;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class singleVariationTypeAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] values;

    public singleVariationTypeAdapter(Context context, String[] values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_single_variation_type, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.firstLine);
        TextView secondLineTextView = (TextView) rowView.findViewById(R.id.secondLine);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        textView.setText(values[position]);

        String fontPath1 = "fonts/Gotham-Bold.otf";
        String fontPath2 = "fonts/Gotham-Light.otf";


        Typeface tf1 = Typeface.createFromAsset(context.getAssets(),fontPath1);
        textView.setTypeface(tf1);

        Typeface tf2 = Typeface.createFromAsset(context.getAssets(),fontPath2);
        secondLineTextView.setTypeface(tf2);


        // change the icon for Windows and iPhone
        String s = values[position];
        if (s.startsWith("Visual Editor")) {
            imageView.setImageResource(R.drawable.visual_editor_icon);
            secondLineTextView.setText(R.string.visual_editor_desc);
        }
        else if (s.startsWith("Live Variables")) {
            imageView.setImageResource(R.drawable.live_variables_icon);
            secondLineTextView.setText(R.string.live_variables_desc);
        }
        else if (s.startsWith("Code Blocks")) {
            imageView.setImageResource(R.drawable.code_blocks_icon);
            secondLineTextView.setText(R.string.code_blocks_desc);
        }

        return rowView;
    }



}
