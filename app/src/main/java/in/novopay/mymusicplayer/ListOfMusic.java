package in.novopay.mymusicplayer;

/**
 * Created by rohitshukla on 8/4/15.
 */

import android.app.Fragment;
import android.app.FragmentBreadCrumbs;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;


public class ListOfMusic extends FragmentActivity {

    private ViewPager viewPager;
    private MusicListFragmentStatePagerAdapter musicFragment;
    private static final int NUMBER_OF_FRAGMENTS=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);


        viewPager = (ViewPager) findViewById(R.id.activity_viewpager);
        musicFragment = new MusicListFragmentStatePagerAdapter(getSupportFragmentManager()) ;
        viewPager.setAdapter(musicFragment);
    }


    private class MusicListFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

        public MusicListFragmentStatePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new First_fragment();
                case 1:
                    return new Second_fragment();

            }
            return null;

        }



        @Override
        public int getCount() {
            return NUMBER_OF_FRAGMENTS;
        }
    }
}
