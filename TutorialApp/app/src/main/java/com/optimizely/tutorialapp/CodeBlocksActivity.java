//
//  CodeBlocksActivity
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

import com.optimizely.CodeBlocks.CodeBranch;
import com.optimizely.CodeBlocks.DefaultCodeBranch;
import com.optimizely.CodeBlocks.OptimizelyCodeBlock;
import com.optimizely.Optimizely;

public class CodeBlocksActivity extends AppCompatActivity {

    // [OPTIMIZELY] Example how to declare a code block (Part 1 of 2)
    private static OptimizelyCodeBlock onboardingFlow = Optimizely.codeBlock("CheckoutFlow").withBranchNames("addOnboarding");
    private static String returning_customer = "true";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_blocks);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_code_blocks, menu);
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

        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void goToVisualEditor(View view) {

        // [OPTIMIZELY] (OPTIONAL) Example Custom Tag
        // If you have information about your users on the client side in your app, based on those
        // values you can set the value of the custom tag.
        // These values should be set prior to startOptimizely or before refreshExperiments is called.
        returning_customer = "true";

        Optimizely.setCustomTag("returning_customer", returning_customer);
        Optimizely.refreshExperiments();


        // [OPTIMIZELY] Example how to declare a code block (Part 2 of 2)
        onboardingFlow.execute(new DefaultCodeBranch() {
            @Override
            public void execute() {
                Intent signUpIntent = new Intent(CodeBlocksActivity.this, VisualEditorActivity.class);
                CodeBlocksActivity.this.startActivity(signUpIntent);
            }
        }, new CodeBranch() {
            @Override
            public void execute() {
                Intent signUpIntent = new Intent(CodeBlocksActivity.this, CodeBlocksActivity2.class);
                CodeBlocksActivity.this.startActivity(signUpIntent);
            }
        });


    }
}