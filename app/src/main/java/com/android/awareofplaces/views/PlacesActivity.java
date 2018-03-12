package com.android.awareofplaces.views;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.awareofplaces.Utils.CommonUtils;
import com.android.awareofplaces.Utils.Constants;
import com.android.awareofplaces.R;

public class PlacesActivity extends AppCompatActivity implements PlacesDisplayFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        addFragment();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //addFragment();
    }


    private void addFragment() {
        //if(CommonUtils.checkPlayServiceAvailability(PlacesActivity.this)){
            PlacesDisplayFragment displayFragment = (PlacesDisplayFragment) getSupportFragmentManager().findFragmentByTag(Constants.FRAGMENT_TAG_KEY);
            if (displayFragment == null) {
                displayFragment = new PlacesDisplayFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.fl_place_display, displayFragment, Constants.FRAGMENT_TAG_KEY);
                transaction.commit();
            }
       // }
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
