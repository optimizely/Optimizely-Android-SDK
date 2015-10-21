//
//  LandingTableActivity
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
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class LandingTableActivity extends AppCompatActivity {

    private ArrayList<String> variationTypes;
    private singleVariationTypeAdapter variationTypesAdapter;
    private ListView variationTypesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_table);

        variationTypesListView = (ListView) findViewById(R.id.variationTypes);
        variationTypes = new ArrayList<String>();

        String[] values = new String[]{ "Visual Editor", "Live Variables", "Code Blocks"};

        variationTypesAdapter = new singleVariationTypeAdapter(this, values);
        variationTypesListView.setAdapter(variationTypesAdapter);

        variationTypesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch(position){
                    case 0:  Intent newActivity = new Intent(LandingTableActivity.this, VisualEditorActivity.class);
                        startActivity(newActivity);
                        break;
                    case 1:  Intent newLiveVariablesActivity = new Intent(LandingTableActivity.this, LiveVariablesListActivity.class);
                        startActivity(newLiveVariablesActivity);
                        break;
                    case 2:  Intent newCodeBlocksActivity = new Intent(LandingTableActivity.this, CodeBlocksActivity.class);
                        startActivity(newCodeBlocksActivity);
                        break;


                }

            }
            @SuppressWarnings("unused")
            public void onClick(View v){
            };
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_landing_table, menu);
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


        return super.onOptionsItemSelected(item);
    }




}
