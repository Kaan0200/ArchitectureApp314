package com.example.kaan.architecture314app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;

import com.example.kaan.architecture314app.R;

public class ProcessorSearchActivity extends ActionBarActivity {

    public Spinner companySpinner;
    public SeekBar bitSizeSeekBar;
    public SeekBar yearStartSeekBar;
    public SeekBar yearEndSeekBar;
    public SeekBar speedMinSeekBar;
    public SeekBar speedMaxSeekBar;
    public int[] bitSizes = {4, 8, 16, 32, 64};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processor_search);

        // get and populate the company spinner
        companySpinner = (Spinner)findViewById(R.id.companySpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.companies_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        companySpinner.setAdapter(adapter);

        // get and setup the seekbars
        SeekBar.OnSeekBarChangeListener seekbarlistener = new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBar.setProgress(progress);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                ;
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                ;
            }
        };

        bitSizeSeekBar = (SeekBar)findViewById(R.id.bitsizeSeekbar);
        bitSizeSeekBar.setOnSeekBarChangeListener(seekbarlistener);

        yearStartSeekBar = (SeekBar)findViewById(R.id.yearStartSeekbar);
        yearStartSeekBar.setOnSeekBarChangeListener(seekbarlistener);

        yearEndSeekBar = (SeekBar)findViewById(R.id.yearEndSeekbar);
        yearEndSeekBar.setOnSeekBarChangeListener(seekbarlistener);

        speedMinSeekBar = (SeekBar)findViewById(R.id.speedMinSeekbar);
        speedMinSeekBar.setOnSeekBarChangeListener(seekbarlistener);

        speedMaxSeekBar = (SeekBar)findViewById(R.id.speedMaxSeekbar);
        speedMaxSeekBar.setOnSeekBarChangeListener(seekbarlistener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_processor_search, menu);
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

    /**
     * This will execute when the button is pressed.  It should both
     * open the results view as well as tailor the search results
     * or pass the values to the other view to do the same
     * @param view
     */
    public void searchForProcessors(View view){
        //query
        // select * from processors where

        Intent intent = new Intent(ProcessorSearchActivity.this, ProcessorDefinitionListActivity.class);
        startActivity(intent);
    }
}
