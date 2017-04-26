package com.example.mwars.sinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.mwars.sinfo.ui.SubjectTaskFragment;

/**
 * An activity representing a single Subject detail screen. This
 * activity is only used narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link SubjectListActivity}.
 */
public class SubjectTaskActivity extends AppCompatActivity {

    private final static String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private final static String EXTRAS_ID = "EXTRAS_ID";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_detail);

//        FragmentManager fManager = getSupportFragmentManager();
//        fManager.beginTransaction().replace(R.id.subject_detail_container, new SubjectTaskFragment(), "SUB_DETAIL_FRAGMENT").commit();

        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
                if(appBarLayout.getCollapsedTitleGravity() != 0)
                    Snackbar.make(view, "TITLE IS ENABLED", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                else{
                    Snackbar.make(view, "TITLE ISN'T ENABLED", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }

            }
        });

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.

            Log.d("__BD_EXTRAS_: ", String.valueOf(getIntent().getBundleExtra(BUNDLE_EXTRAS)));
            Bundle extras = new Bundle();
            extras.putString(SubjectTaskFragment.ARG_ITEM_ID,
                    String.valueOf(getIntent().getBundleExtra(BUNDLE_EXTRAS).getInt(EXTRAS_ID)));


//                            .getStringExtra(SubjectTaskFragment.ARG_ITEM_ID));
            SubjectTaskFragment fragment = new SubjectTaskFragment();
            fragment.setArguments(extras);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.subject_detail_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            navigateUpTo(new Intent(this, SubjectListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
