package com.example.kaan.architecture314app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.kaan.architecture314app.R;

public class ProcessorSearchActivity extends ActionBarActivity {

    public ListView makerCompanyListView;
    // the values inside the list view


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processor_search);
        // get sliders and hold onto them
        makerCompanyListView = (ListView)findViewById(R.id.companyList);
        // populate listView with companies

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

    }
}
