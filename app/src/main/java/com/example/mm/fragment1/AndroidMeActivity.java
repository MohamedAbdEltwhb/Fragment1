package com.example.mm.fragment1;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mm.fragment1.data.AndroidImageAssets;

public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        // Only create new fragments when there is no previously saved state
        if(savedInstanceState == null) {

            // Retrieve list index values that were sent through an intent; use them to display the desired Android-Me body part image
            // Use setListindex(int index) to set the list index for all BodyPartFragments

            // Create a new head BodyPartFragment
            BodyPartFragment headFragment = new BodyPartFragment();

            // Set the list of image id's for the head fragment and set the position to the second image in the list
            headFragment.setmImageIds(AndroidImageAssets.getHeads());

            // Get the correct index to access in the array of head images from the intent
            // Set the default value to 0
            int headIndex = getIntent().getIntExtra("headIndex", 0);
            headFragment.setmListIndex(headIndex);

            // Add the fragment to its container using a FragmentManager and a Transaction
            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .add(R.id.head_contaner, headFragment)
                    .commit();

            // Create and display the body and leg BodyPartFragments

            BodyPartFragment bodyFragment = new BodyPartFragment();
            bodyFragment.setmImageIds(AndroidImageAssets.getBodies());
            int bodyIndex = getIntent().getIntExtra("bodyIndex", 0);
            bodyFragment.setmListIndex(bodyIndex);

            fragmentManager.beginTransaction()
                    .add(R.id.bodies_contaner, bodyFragment)
                    .commit();

            BodyPartFragment legFragment = new BodyPartFragment();
            legFragment.setmImageIds(AndroidImageAssets.getLegs());
            int legIndex = getIntent().getIntExtra("legIndex", 0);
            legFragment.setmListIndex(legIndex);

            fragmentManager.beginTransaction()
                    .add(R.id.legs_contaner, legFragment)
                    .commit();
        }

//        if (savedInstanceState == null) {
//
//            FragmentManager manager = getSupportFragmentManager();
//
//            BodyPartFragment headsfragment = new BodyPartFragment();
//            headsfragment.setmImageIds(AndroidImageAssets.getHeads());
//            headsfragment.setmListIndex(1);
//            manager.beginTransaction().add(R.id.head_contaner, headsfragment).commit();
//
//            BodyPartFragment bodyFragment = new BodyPartFragment();
//            bodyFragment.setmImageIds(AndroidImageAssets.getBodies());
//            manager.beginTransaction().add(R.id.bodies_contaner, bodyFragment).commit();
//
//            BodyPartFragment leagFragment = new BodyPartFragment();
//            leagFragment.setmImageIds(AndroidImageAssets.getLegs());
//            manager.beginTransaction().add(R.id.legs_contaner, leagFragment).commit();
//
//        }

    }
}
