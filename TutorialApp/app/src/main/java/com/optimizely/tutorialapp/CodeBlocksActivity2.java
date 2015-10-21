//
//  CodeBlocksActivity2
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

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class CodeBlocksActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_blocks2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_code_blocks_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if(id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void goToVisualEditor(View view) {
        Intent intent = new Intent(this, VisualEditorActivity.class);
        startActivity(intent);
    }
}
