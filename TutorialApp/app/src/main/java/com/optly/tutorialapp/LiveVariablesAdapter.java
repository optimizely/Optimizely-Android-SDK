//
//  LiveVariablesActivity
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

package com.optly.tutorialapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.optimizely.Optimizely;
import com.optimizely.Variable.LiveVariable;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LiveVariablesAdapter extends BaseAdapter {
    private Context context;

    String[] msrpArray = {"3.99", "6.99", "9.99", "12.99", "15.99", "18.99"};
    String[] itemNameArray = {"Standard Widget", "Standard Widget Pack", "Deluxe Widget", "Deluxe Widget Pack", "Premium Widget", "Premium Widget Pack"};

    // [OPTIMIZELY] Examples of how to declare live variables (Part 1 of 2)
    private static LiveVariable<Float> discountVariable = Optimizely.floatForKey("discountVariable", 0.25f /* default value */);
    private static LiveVariable<Integer> numberOfItems = Optimizely.integerForKey("numberOfItems", 4 /* default value */);
    //String[] itemNameArray = context.getResources().getStringArray(R.array.item_name_array);

    public LiveVariablesAdapter(Context c) {
        context = c;
    }

    public int getCount() {
        if (numberOfItems.get() <= 6)
            // [OPTIMIZELY] Examples of how to use live variable values (Part 2 of 2)
            return numberOfItems.get();
        else
            return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 1;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.activity_live_variables_item, null);



            // set image based on selected text
            ImageView imageView = (ImageView) gridView
                    .findViewById(R.id.product_image_view);

            TextView nameView = (TextView) gridView.findViewById(R.id.text_view_name);
            nameView.setText(itemNameArray[position]);

            TextView msrpView = (TextView) gridView.findViewById(R.id.test_view_msrp);
            msrpView.setText(msrpArray[position]);
            double discount = 0.25;




            TextView saleView = (TextView) gridView.findViewById(R.id.text_view_sales_price);

            // [OPTIMIZELY] Examples of how to use live variable values (Part 2 of 2)
            saleView.setText(Float.toString(round((1.0f - discountVariable.get()) * Float.parseFloat(msrpArray[position]), 2)));

            imageView.setImageResource(mThumbIds[position]);


        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.gear1, R.drawable.gear2,
            R.drawable.gear3, R.drawable.gear4,
            R.drawable.gear5, R.drawable.gear6
    };

    public static float round(float value, int places) {
        // http://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return (float) bd.doubleValue();
    }
}