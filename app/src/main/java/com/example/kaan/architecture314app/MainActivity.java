package com.example.kaan.architecture314app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.*;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get the objects
    }


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

    /**
     * This opens up the Glossary Activity when the button is pressed
     * @param v
     */
    public void openGlossaryActivity(View v){
        Intent intent = new Intent(MainActivity.this, GlossaryDefinitionListActivity.class);
        startActivity(intent);
    }

    /**
     * This opens up the Processor Search when the button is pressed.
     * @param v
     */
    public void openProcessorSearchActivity(View v){
        Intent intent = new Intent(MainActivity.this, ProcessorSearchActivity.class);
        startActivity(intent);
    }

    /**
     * This opens up the processor definition List
     * @param v
     */
    public void openProcessorDictionaryActivity(View v){
        ProcessorDefinitionListActivity.searchBy = ""; //clear it to return everything
        Intent intent = new Intent(MainActivity.this, ProcessorDefinitionListActivity.class);
        startActivity(intent);
    }
}
