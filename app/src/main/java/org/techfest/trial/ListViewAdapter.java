package org.techfest.trial;

import android.app.FragmentManager;
import android.content.Context;
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

    public ListViewAdapter(FragmentManager fragmentManager, ArrayList<ListViewItem> items) {
        this.fragmentManager = fragmentManager;
        listViewItems = items;
        this.count=items.size();
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
        return null;
    }
}
