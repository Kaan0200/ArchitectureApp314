package com.example.kaan.architecture314app;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;


/**
 * An activity representing a list of ProcessorDefinitions. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ProcessorDefinitionDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p/>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link ProcessorDefinitionListFragment} and the item details
 * (if present) is a {@link ProcessorDefinitionDetailFragment}.
 * <p/>
 * This activity also implements the required
 * {@link ProcessorDefinitionListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class ProcessorDefinitionListActivity extends FragmentActivity
        implements ProcessorDefinitionListFragment.Callbacks {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processordefinition_list);
        // Show the Up button in the action bar.
        //-------------------------getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (findViewById(R.id.processordefinition_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((ProcessorDefinitionListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.processordefinition_list))
                    .setActivateOnItemClick(true);
        }

        //----------------------------------------------------------------
        //-------SQL DATA ENTRIES-----------------------------------------
        //----------------------------------------------------------------

        addProcessor("4004", "Intel", 1971, "4bit BCD", 4, null, 0.74, "This was the first microprocessor, and first general purpose programmable microprocessor, on market.");
        addProcessor("4040", "Intel", 1974, "4bit BCD", 4, null, 0.5, "This microprocessor was the Intel 4004's successor, with new features and extensions available.");
        addProcessor("8080", "Intel", 1974, "8080", 8, null, 2.0, "This was Intel's second 8 bit processor and popularly labeled as 'The First truly usable microprocessor'.");
        addProcessor("8086", "Intel", 1979, "x86-16", 16, null, 5.0, "This processor gave rise to the extremely successful x86 line of Intel processors.");
            //--
        //addProcessor("Pentium Pro", "Intel", "x86", 32, 60.0);
        //addProcessor("Itanium", "Intel", "Itanium", 64, 733.0);
            //--
        addProcessor("Am29000", "AMD", 1987, "RISC Design", 32, null, 25.0, "These were the most popular RISC chips on the market for a period of time, and were used in machines like laser printers.");
        addProcessor("Am5x86", "AMD", 1995, "IA-32", 32, "x86", 133.0, "This was popular for ordinary, entry-level PC systems.");
        addProcessor("K6", "AMD", 1997, "MMX", 32, "x86", 166.0, "This became a sizable competitior to Intel's Pentium II.");

        addProcessor("Snapdragon S1 MSM7225", "Qualcomm", 2007, "ARMv6", 32, "ARM11", 528.0, null);
        addProcessor("Snapdragon 200 8225Q", "Qualcomm", 2013, "ARMv7", 32, "ARM Cortex-A5", 1400.0, null);
        addProcessor("Snapdragon 610 8936", "Qualcomm", 2014, "ARMv8", 64, "ARM Cortex-A53", 1700.0, null);

        addProcessor("Cortex-R4", "ARM", 2011, "ARMv7", 32, "ARM Cortex-R4", 265.0, null);
        addProcessor("Cortex-M7", "ARM", 2014, "ARMv7-M", 32, "ARM Cortex-M7", 400.0, null);
        addProcessor("Cortex-A72", "ARM", 2015, "ARMv8-A", 64, "ARM Cortex-A72", 2500.0, null);

        //IBM
        addProcessor("POWER1", "IBM", 1990, "POWER", 32, null, 25.0, "This microprocessor was IBM's first in the POWER line and was their high performance solution for their line of servers and supercomputers.");
        addProcessor("POWER2", "IBM", 1993, "POWER", 32, null, 55.0, "This microprocessor was the fastest at the time, surpassed by the Alpha21064A in 1993.");
        addProcessor("POWER3", "IBM", 1998, "PowerPC", 64, null, 200.0, "This microprocessor was first to move to the PowerPC instruction set which was the same as POWER but much more optimized.");
        addProcessor("POWER4", "IBM", 2001, "PowerPC", 64, null, 1100.0, "This microprocessor was a dual core and was the first non-embedded microprocessor to have two cores on a single die.");
        addProcessor("POWER5", "IBM", 2004, "PowerPC", 64, null, 1900.0, "This microprocessor was an improvement to the POWER4 by adding 2 threads a core and on-die memory controlling over the previous version");
        addProcessor("POWER6", "IBM", 2007, "PowerPC", 64, null, 3600.0, "This microprocessor improved on previous generations by executing instructions in-order instead of out-of-order, while still managing to be faster");
        addProcessor("POWER7", "IBM", 2010, "PowerPC", 64, null, 2400.0, "This microprocessor was funded by DARPA, who collaberated with IBM to enable POWER7 to have clusters perform as single systems.");
        addProcessor("POWER8", "IBM", 2014, "PowerPC", 64, null, 3500.0, "Based on Power Architecture, POWER8 was designed to be massively multithreading, allowing each of its cores (4,6,8,10, or 12 variants) to be able to handle 8 threads simultaniously.");
        //----------------------------------------------------------------

        // TODO: If exposing deep links into your app, handle intents here.
    }

    private void addProcessor(String name,
                              String company,
                              int year,
                              String instructionSet, //nullable
                              int bitsize,
                              String microarchitecture, //nullable
                              Double speed, //nullable
                              String other //nullable
    ) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COL_NAME, name);
        values.put(DatabaseHelper.COL_COMPANY, company);
        values.put(DatabaseHelper.COL_YEAR, year);
        if (instructionSet != null) { // don't put in nulls
            values.put(DatabaseHelper.COL_INSTRUCTIONSET, instructionSet);
        }
        values.put(DatabaseHelper.COL_BITSIZE, bitsize);
        if (microarchitecture != null){ // dont put in nulls
            values.put(DatabaseHelper.COL_MICROARCH, microarchitecture);
        }
        if (speed != null) {
            values.put(DatabaseHelper.COL_SPEED, speed);
        }
        if (other != null) {
            values.put(DatabaseHelper.COL_OTHER, other);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. Use NavUtils to allow users
            // to navigate up one level in the application structure. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Callback method from {@link ProcessorDefinitionListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(String id) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(ProcessorDefinitionDetailFragment.ARG_ITEM_ID, id);
            ProcessorDefinitionDetailFragment fragment = new ProcessorDefinitionDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.processordefinition_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, ProcessorDefinitionDetailActivity.class);
            detailIntent.putExtra(ProcessorDefinitionDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }
}
