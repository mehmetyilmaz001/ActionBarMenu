package com.ninjakod.actionbarmenu;

//import android.app.ActionBar;
//import android.app.FragmentManager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.internal.widget.ScrollingTabContainerView;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class MainActivity extends SherlockFragmentActivity {

    ActionBar.Tab Tab1,Tab2,Tab3;
    Fragment fragmentTab1 = new FragmentTab1();
    Fragment fragmentTab2 = new FragmentTab2();
    Fragment fragmentTab3 = new FragmentTab3();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();



        actionBar.setDisplayShowHomeEnabled(true);
        /* tab container */
        ScrollingTabContainerView scroll = new ScrollingTabContainerView(this);

        ActionBar.Tab tab = actionBar.newTab()
                .setText("Android")
                .setTabListener(new TabListener(fragmentTab1));

        actionBar.addTab(tab);
        scroll.addTab(tab, true);
        tab = actionBar.newTab()
                .setText("Apple")
                .setTabListener(new TabListener(fragmentTab2));

        actionBar.addTab(tab);
        scroll.addTab(tab,false);
        scroll.addTab(tab, false);
        scroll.addTab(tab, false);
        scroll.addTab(tab, false);
        scroll.addTab(tab,false);
        scroll.addTab(tab,false);
        scroll.addTab(tab, false);

        scroll.bringToFront();
        actionBar.setCustomView(scroll);
        actionBar.setDisplayShowCustomEnabled(true);
        //actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

    }

    /* creating static menu */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getSupportMenuInflater();

        menu.add("Save")

                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);

        menu.add("Search")

                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);

        menu.add("Refresh")

                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);

        inflater.inflate(R.menu.menu_main , menu);

        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //This uses the imported MenuItem from ActionBarSherlock
        Toast.makeText(this, "Got click: " + item.toString(), Toast.LENGTH_SHORT).show();
        return true;
    }

}