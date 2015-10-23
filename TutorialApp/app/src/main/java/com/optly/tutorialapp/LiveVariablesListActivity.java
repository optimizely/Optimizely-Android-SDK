package com.optly.tutorialapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.optimizely.Optimizely;
import com.optimizely.Variable.LiveVariable;

public class LiveVariablesListActivity extends AppCompatActivity {

    // [OPTIMIZELY] Examples of how to declare live variables (Part 1 of 2)
    private static LiveVariable<Float> discountVariable = Optimizely.floatForKey("discountVariable", 0.25f /* default value */);

    private Context context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_live_variables_list);


        GridView gridview = (GridView) findViewById(R.id.activity_live_variables_grid_layout);
        gridview.setAdapter(new LiveVariablesAdapter(this));

        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(LiveVariablesListActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // [OPTIMIZELY] Examples of how to use live variable values (Part 2 of 2)
        TextView discountBannerView = (TextView) findViewById(R.id.activity_live_variables_discount);
        int optlyDiscount = (int) Math.round((double)discountVariable.get()*100);
        String optlyDiscountString = Integer.toString(optlyDiscount);
        String discountBannerText = optlyDiscountString+"% OFF YOUR FIRST ORDER IF YOU SIGN UP BY 9/1";
        discountBannerView.setText(discountBannerText);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_live_variables_list, menu);
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
