//
//  MainActivity
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

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.optimizely.Optimizely;
import com.optimizely.integration.DefaultOptimizelyEventListener;
import com.optimizely.integration.OptimizelyExperimentData;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static String tag = "OPTLY";
    private static String returning_customer = "true";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String fontPath = "fonts/Gotham-Light.otf";

        TextView welcomeTitle = (TextView) findViewById(R.id.textView);

        Typeface tf = Typeface.createFromAsset(getAssets(),fontPath);

        welcomeTitle.setTypeface(tf);

        TextView welcomeText = (TextView) findViewById(R.id.welcome_text);
        welcomeText.setTypeface(tf);


        // Below are instructions for initial setup, lines marked as optional
        // are options, lines marked as required are required
        // Throughout the code, you can search for [OPTIMIZELY] to find reference code
        // related to Optimizely
        // All lines that say [OPTIMIZELY] (REQUIRED) are necessary for you to
        // get started!

        // [OPTIMIZELY] (OPTIONAL) Add this line of code to debug issues.  Please note that this line of code
        // should not be included when your app is in production
        Optimizely.setVerboseLogging(true);

        // [OPTIMIZELY] (OPTIONAL) Example Custom Tag
        // If you have information about your users on the client side in your app, based on those
        // values you can set the value of the custom tag.
        // These values should be set prior to startOptimizely or before refreshExperiments is called.
        // For the refreshExperiments example, you can go to the CodeBlocksActivity.java file.
        returning_customer = "true";
        Optimizely.setCustomTag("returning_customer", returning_customer);

        // [OPTIMIZELY] (OPTIONAL) Customize how often the datafile is downloaded (By default network calls are made every 2 minutes)
        // Optimizely.setDataFileDownloadInterval(120);

        // [OPTIMIZELY] (REQUIRED) Replace this line with your API token, and don't forget to go to
        // your AndroidManifest.xml (e.g. it should look like optly123456, replace 123456 with your project id)
        // Replace <YOUR_API_TOKEN> with your API Token from your Optimizely Dashboard
        // optimizely.com/dashboard.  It should look like: "AAMseu0A6cJKXYL7RiH_TgxkvTRMOCvS~123456"

        Optimizely.startOptimizelyWithAPIToken(<YOUR_API_TOKEN>, getApplication(), mOptimizelyEventListener);

        // [OPTIMIZELY] (OPTIONAL) Register the plugin for the integration you would like to use
        // For information, refer to: http://developers.optimizely.com/android/reference/index.html#analytics-integrations
        // Optimizely.registerPlugin(new Optimizely<ANALYTICS_PROVIDER>Integration());

    }

    // [OPTIMIZELY] (OPTIONAL) The following listeners will trigger when certain events happen in the SDK
    // such as when an experiment is running.  To learn more, you can refer to the following article:
    // https://help.optimizely.com/hc/en-us/articles/205014107-How-Optimizely-s-SDKs-Work-SDK-Order-of-execution-experiment-activation-and-goals

    private static DefaultOptimizelyEventListener mOptimizelyEventListener = new DefaultOptimizelyEventListener() {
        public void onOptimizelyStarted() {
            Log.i(tag, "Optimizely started.");
        }

        public void onOptimizelyFailedToStart(String errorMessage) {
            Log.i(tag, "Failed to start");
        }

        public void onOptimizelyExperimentViewed(OptimizelyExperimentData experimentState) {
            Log.i(tag, "Experiment Viewed");
        }

        public void onOptimizelyEditorEnabled() {
            Log.i(tag, "Optimizely is ready to connect to the editor.");
        }

        public void onOptimizelyDataFileLoaded() {
            Log.i(tag, "Optimizely experiment data file loaded.");
        }

        public void onGoalTriggered(String description,
                                    List<OptimizelyExperimentData> affectedExperiments) {
            Log.i(tag, "Goal Triggered");
        }

        public void onMessage(String source, String messageType, Bundle payload) {
            Log.i(tag, "Received message");
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void goToMainScreen(View view) {
        Intent intent = new Intent(this, LandingTableActivity.class);
        startActivity(intent);
    }
}
