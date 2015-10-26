package org.techfest.trial;

import android.support.v4.view.ViewPager;

import java.util.ArrayList;

/**
 * Created by DELL on 22-Oct-15.
 */
public class ListViewItem {

    private String idRow;
    private ArrayList<ViewPagerItem> viewPagerItems;

    public ListViewItem(String idRow, ArrayList<ViewPagerItem> viewPagerItems) {
        this.idRow = idRow;
        this.viewPagerItems = viewPagerItems;
    }

    public String getIdRow() {
        return idRow;
    }

    public void setIdRow(String idRow) {
        this.idRow = idRow;
    }
    public void setViewPagerItems(ArrayList<ViewPagerItem> viewPagerItems) {
        this.viewPagerItems = viewPagerItems;
    }


    public ArrayList<ViewPagerItem> getViewPagerItems() {
        return viewPagerItems;
    }
}
