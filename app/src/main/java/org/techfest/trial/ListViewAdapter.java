package org.techfest.trial;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by DELL on 22-Oct-15.
 */
public class ListViewAdapter extends BaseAdapter {

    FragmentManager fragmentManager;
    Context context;
    ArrayList<ListViewItem> listViewItems;
    int count;

    public ListViewAdapter(FragmentActivity fragmentActivity, ArrayList<ListViewItem> items) {
        this.fragmentManager = fragmentActivity.getSupportFragmentManager();
        listViewItems = items;
        this.count=items.size();
        context = fragmentActivity;
    }

    @Override
    public int getCount() {
        return this.count;
    }

    @Override
    public Object getItem(int position) {
        return listViewItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View currentView = View.inflate(context, R.layout.custom_row_main, null);
        final ViewPager viewPager = (ViewPager) currentView.findViewById(R.id.pager);
        viewPager.setId(position + 1);
        ViewPagerAdapter adapter = new ViewPagerAdapter(fragmentManager, listViewItems.get(position).getViewPagerItems());
        viewPager.setAdapter(adapter);

        return currentView;
    }
}
