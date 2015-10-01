package com.optimizely.tutorialapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.optimizely.Optimizely;
import com.optimizely.integration.DefaultOptimizelyEventListener;
import com.optimizely.integration.OptimizelyExperimentData;

import java.util.List;


public class MainActivity extends ActionBarActivity {

    private static String tag = "OPTLY";

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
        Optimizely.startOptimizelyAsync("AAM7hIkBAJn-txU9ElPJEtwHE1IQLXMA~2225361645", getApplication(), mOptimizelyEventListener);

    }
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
