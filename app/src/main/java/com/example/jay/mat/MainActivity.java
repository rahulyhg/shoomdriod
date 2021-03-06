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
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.inputmethod.EditorInfo;

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
    private EditText etProSearch, etAreaSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        tvHome = (TextView) findViewById(R.id.toolbar_title);
        setSupportActionBar(mToolbar);
        iv = (ImageView) findViewById(R.id.imageView);
        etProSearch = (EditText) findViewById(R.id.etProductSearch);
        etAreaSearch = (EditText) findViewById(R.id.etAreaProduct);

        tvHome.setText("Home");
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_drawer);
                getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Set up the drawer.
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);

        /*iv.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.d("msg", "msg");
                Intent search = new Intent(MainActivity.this, Search.class);
                startActivity(search);

            }
        });*/

        /*etProSearch.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int keyCode, KeyEvent keyevent) {
                //If the keyevent is a key-down event on the "enter" button
                if ((keyevent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    //...
                    // Perform your action on key press here
                    // ...
                    System.out.println("Pressed Enter");
                    Intent search = new Intent(MainActivity.this, Search.class);
                    startActivity(search);
                    return true;
                }
                return false;
            }
        });*/

        etProSearch.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    //submit_btn.performClick();
                    System.out.println("Pressed Enter");
                    Intent search = new Intent(MainActivity.this, Product4.class);
                    startActivity(search);
                    return true;
                }
                return false;
            }
        });

        etAreaSearch.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    //submit_btn.performClick();
                    System.out.println("Pressed Enter");
                    Intent search = new Intent(MainActivity.this, Search.class);
                    startActivity(search);
                    return true;
                }
                return false;
            }
        });


    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        //Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();
        if(i>0){

            if(position==0) { // home
                Intent search = new Intent(this, MainActivity.class);
                startActivity(search);
            }
            if(position==1) { // orders
                Intent search = new Intent(this, Walletproduct.class);
                startActivity(search);
            }
            if(position==2) { // fav shop
                Intent search = new Intent(this, FavShops.class);
                startActivity(search);
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
                Intent search = new Intent(this, Wishlist.class);
                startActivity(search);
            }
            if(position==6) { // my profile
                Intent search = new Intent(this, Profile.class);
                startActivity(search);
            }
            if(position==7) { // settings
                Intent search = new Intent(this, Settings.class);
                startActivity(search);
            }
            if(position==8) { //FAQ
                Intent search = new Intent(this, Faq.class);
                startActivity(search);
            }
            if(position==9) { // Logout
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
        Intent search = new Intent(this, Search.class);
        startActivity(search);
    }

    public void openSprite(View v)
    {
        Intent sprite = new Intent(this, Product2.class);
        startActivity(sprite);
    }

    public void openLays(View v)
    {
        Intent lays = new Intent(this, Product.class);
        startActivity(lays);
    }

}
