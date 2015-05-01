package com.example.kaan.architecture314app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class ProcessorSearchActivity extends ActionBarActivity {

    public Spinner companySpinner;
    public SeekBar bitSizeSeekBar;
    public SeekBar yearStartSeekBar;
    public SeekBar yearEndSeekBar;
    public SeekBar speedMinSeekBar;
    public SeekBar speedMaxSeekBar;

    public TextView bitSizeSeekBarText;
    public TextView yearStartText;
    public TextView yearEndText;
    public TextView speedMinText;
    public TextView speedMaxText;

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

        // grab all the seekbars
        bitSizeSeekBar = (SeekBar)findViewById(R.id.bitsizeSeekbar);
        yearStartSeekBar = (SeekBar)findViewById(R.id.yearStartSeekbar);
        yearEndSeekBar = (SeekBar)findViewById(R.id.yearEndSeekbar);
        speedMinSeekBar = (SeekBar)findViewById(R.id.speedMinSeekbar);
        speedMaxSeekBar = (SeekBar)findViewById(R.id.speedMaxSeekbar);
        // grab the texts that will change
        bitSizeSeekBarText = (TextView)findViewById(R.id.bitsizeSeekbarLabel);
        yearStartText = (TextView)findViewById(R.id.yearStartLabel);
        yearEndText = (TextView)findViewById(R.id.yearEndLabel);
        speedMinText = (TextView)findViewById(R.id.speedMinLabel);
        speedMaxText = (TextView)findViewById(R.id.speedMaxLabel);

        //set up the listener for the bitsize seekbar
        bitSizeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
              bitSizeSeekBarText.setText(bitSizes[progress]);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
              //nothing
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
              //nothing
            }
        });
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
     * This will execute when the button is pressed.  It should both open the results view
     * as well as tailor the search results or pass the values to the other view to do the same
     */
    public void searchForProcessors(View view){
        // the top seekbar in each pair must be lower then the bottom
        if (!seekBarValuesGood()) {
            new AlertDialog.Builder(this).setTitle("Bad Seekbar Values")
                    .setMessage("The top of each pair of seekbars must be a lower value then the " +
                            "bottom seekbar.").setNeutralButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // do nothing
                }
            })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
        // seekbars are good
        else {
            // pass in the "having" part of an SQL statment here.
            String whereString = "company like " + companySpinner.getSelectedItem().toString();
            whereString += " and ";
            whereString += "bitsize = " + bitSizes[bitSizeSeekBar.getProgress()];
            whereString += " and ";
            whereString += "year BETWEEN " + (yearStartSeekBar.getProgress()+1971) +" AND "+ (yearEndSeekBar.getProgress()+1971);
            whereString += " and ";
            whereString += "speed BETWEEN " + speedMinSeekBar.getProgress() + " AND " + speedMaxSeekBar.getProgress();
            Log.d("check",whereString);
            ProcessorDefinitionListActivity.searchBy = whereString;
            Intent intent = new Intent(ProcessorSearchActivity.this, ProcessorDefinitionListActivity.class);
            startActivity(intent);
        }
    }

    private boolean seekBarValuesGood(){
        return ((yearStartSeekBar.getProgress() < yearEndSeekBar.getProgress())
                &&(speedMinSeekBar.getProgress() < speedMaxSeekBar.getProgress()));
    }
}
