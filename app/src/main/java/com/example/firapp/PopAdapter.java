package com.example.firapp;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PopAdapter extends FragmentPagerAdapter{

    Context context;
    int totalTabs;

    public PopAdapter(@NonNull FragmentManager fm) {
        super (fm);
    }

    public PopAdapter(Context c, @NonNull FragmentManager fm, int totalTabs) {
        super (fm, totalTabs);
        context = c;
        this.totalTabs = totalTabs;
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                ImgeFragment footballFragment = new ImgeFragment ();
                return footballFragment;
            case 1:
                IndividualFragment cricketFragment = new IndividualFragment ();
                return cricketFragment;
            case 2:
                BusinessFragment nbaFragment = new BusinessFragment ();
                return nbaFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
