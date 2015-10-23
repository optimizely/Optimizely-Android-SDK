//
//  VisualEditorActivity.java
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

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;


import android.widget.Button;


import com.optimizely.Optimizely;

public class VisualEditorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visual_editor);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        View signInView = (View) findViewById(R.id.activity_visual_editor);

        // [OPTIMIZELY] Below is an example of if you want to tag
        // views manually http://developers.optimizely.com/android/reference/index.html#tag-your-views
        Button takeToWidgets = (Button)
                signInView.findViewById(R.id.take_to_widgets);
        Optimizely.setOptimizelyId("Widgets", takeToWidgets);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_visual_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
