package com.Murray.BobEvansMenu;


import android.widget.ImageButton;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;

import android.view.View;
import android.support.v4.app.ActionBarDrawerToggle;
import android.widget.ListView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.ActionMode;
import android.widget.AdapterView;

import android.support.v4.view.GravityCompat;
import com.google.android.gms.maps.MapFragment;

public class MyActivity extends SherlockFragmentActivity{


    DrawerLayout mDrawerLayout;
    ListView mDrawerList;
    ActionBarDrawerToggle mDrawerToggle;
    MenuListAdapter mMenuAdapter;
    String[] title;
    String[] subtitle;
    String[] rightTitle;
    ImageButton loginButton;
    ImageButton locationButton;
    int[] icon;
    Fragment fragment1 = new Fragments1();
    Fragment fragment2 = new Fragments2();
    Fragment fragment3 = new Fragments3();
    Fragment fragment4 = new Fragments4();

    //ToDo Start Google map V2 Api
    MapFrag1 map_layout = new MapFrag1();
    MapFrag1 mapFrag1 = new MapFrag1();

    MenuListAdapter mMenuAdapterRight;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_main);


        //ActionBarSupport
        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowCustomEnabled(true);
        View view = getLayoutInflater().inflate(R.layout.bottombar_vert, null);


        //ToDO Google Maps
       ImageButton locationButton = (ImageButton)view.findViewById(R.id.locationButton);
       ImageButton loginButton = (ImageButton)view.findViewById(R.id.loginbutton);


        getSupportActionBar().setCustomView(view);

        //Left bar titles
        title = new String[] { "Breakfast", "Lunch", "Dinner", "Drinks" };

        //Left bar subs
        //ToDo Change quotes
        subtitle = new String[] { "Served all day long.", "Satisfying lunchtime hunger.",
                "Dinner quote", "Drink quote" };

        //Left Bar Icons
        //ToDo Change/Fix Icons
        int[] icon = new int[]{R.drawable.action_about, R.drawable.action_settings,
                R.drawable.collections_cloud, R.drawable.location};


        //ToDo Start Actionbar "actions"
        rightTitle = new String[] { "Login", "Signup"," Restaurant Locator"};


        //Left Drawer Setup
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mMenuAdapter = new MenuListAdapter(this, title, subtitle, icon);
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        mDrawerList.setAdapter(mMenuAdapter);

        //Right Drawer Setup
              //TODO


        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_drawer, R.string.drawer_open,
                R.string.drawer_close) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            selectItem(0);
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            if (mDrawerLayout.isDrawerOpen(mDrawerList)) {
                mDrawerLayout.closeDrawer(mDrawerList);
            } else {
                mDrawerLayout.openDrawer(mDrawerList);
            }
        }

        return super.onOptionsItemSelected(item);
    }

    // ListView Listener
    private class DrawerItemClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Locate Position
        switch (position) {
            case 0:
                ft.replace(R.id.content_frame, fragment1);
                break;
            case 1:
                ft.replace(R.id.content_frame, fragment2);
                break;
            case 2:
                ft.replace(R.id.content_frame, fragment3);
                break;
            case 3:
                ft.replace(R.id.content_frame, fragment4);
        }
        ft.commit();
        mDrawerList.setItemChecked(position, true);
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
    @Override
    public ActionMode startActionMode(ActionMode.Callback callback) {
        return null;
    }
}
