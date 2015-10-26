package org.techfest.trial;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by DELL on 25-Oct-15.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<ViewPagerItem> items;

    @Override
    public Fragment getItem(int position) {
        return FragmentItemViewPager.newInstance(items.get(position));
    }

    @Override
    public int getCount() {
        return items.size();
    }

    public ViewPagerAdapter(FragmentManager fm, ArrayList<ViewPagerItem> items) {
        super(fm);
        this.items = items;
    }
}
