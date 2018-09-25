package com.example.andriod.gagile;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.tour_fragment );

        //======================================================//
        // this part configures the sliding tabs, finds the    //
        // pager that allow users to swipe between fragments  //
        // and create and adapter that shows which fragments //
        // should be shown on each page                     //
        //=================================================//

        ViewPager tourPager = findViewById( R.id.tour_viewpager );
        TabLayout tourTab = findViewById( R.id.tour_tablayout );

        GagilFragmentAdapter gagilFragmentAdapter = new GagilFragmentAdapter( this, getSupportFragmentManager() );

        tourPager.setAdapter( gagilFragmentAdapter );
        tourTab.setupWithViewPager( tourPager );
    }
}
