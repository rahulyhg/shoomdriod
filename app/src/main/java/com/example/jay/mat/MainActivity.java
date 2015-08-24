package com.example.jay.mat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity
        implements NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private Toolbar mToolbar;
    private TextView tvHome;
    private int i=0;
    private ImageView iv;
    private Button btSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        tvHome = (TextView) findViewById(R.id.toolbar_title);
        setSupportActionBar(mToolbar);
        iv = (ImageView) findViewById(R.id.imageView);
        //btSearch = (Button) findViewById(R.id.editText);

        tvHome.setText("Home");
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_drawer);
                getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Set up the drawer.
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);
        // populate the navigation drawer
        //mNavigationDrawerFragment.setUserData("John Doe", "johndoe@doe.com", BitmapFactory.decodeResource(getResources(), R.drawable.avatar));

        iv.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.d("msg", "msg");
                Intent search = new Intent(MainActivity.this, Search.class);
                startActivity(search);

            }
        });
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        //Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();
        if(i>0){

            Log.isLoggable("List Item",position);
            if(position==0) { // home
                Intent search = new Intent(this, MainActivity.class);
                startActivity(search);
            }
            if(position==1) { // orders
                Intent search = new Intent(this, ShowToShopKeeper.class);
                startActivity(search);
            }
            if(position==2) { // fav shop
                //Intent search = new Intent(this, Notification.class);
                //startActivity(search);
            }
            if(position==3) { // noti
                Intent search = new Intent(this, Notification.class);
                startActivity(search);
            }
            if(position==4) { //order history
                Intent search = new Intent(this, Orders.class);
                startActivity(search);
            }
            if(position==5) { //wishlist
                //Intent search = new Intent(this, Login.class);
                //startActivity(search);
            }
            if(position==6) { // my profile
                Intent search = new Intent(this, Profile.class);
                startActivity(search);
            }
            if(position==7) { // settings
                //Intent search = new Intent(this, Search.class);
                //startActivity(search);
            }
            if(position==8) { //FAQ
                //Intent search = new Intent(this, Notification.class);
                //startActivity(search);
            }
            if(position==9) { // Logout
                Intent search = new Intent(this, Search.class);
                startActivity(search);
            }
            if(position==10) { // Logout
                Intent search = new Intent(this, Login.class);
                startActivity(search);
            }
        }
        i++;

    }


    @Override
    public void onBackPressed() {
        if (mNavigationDrawerFragment.isDrawerOpen())
            mNavigationDrawerFragment.closeDrawer();
        else
            super.onBackPressed();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    public void openSearch(View v)
    {
        Log.d("Msg","Msg");
        Intent search = new Intent(this, Search.class);
        startActivity(search);
    }
}
