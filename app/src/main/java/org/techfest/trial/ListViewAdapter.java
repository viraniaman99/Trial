package org.techfest.trial;

import android.os.Handler;
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
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by DELL on 22-Oct-15.
 */
public class ListViewAdapter extends BaseAdapter {

    FragmentManager fragmentManager;
    Context context;
    ArrayList<ListViewItem> listViewItems;
    ArrayList<Integer> itemsLastPosition;
    int count;

    public ListViewAdapter(FragmentActivity fragmentActivity, ArrayList<ListViewItem> items) {
        this.fragmentManager = fragmentActivity.getSupportFragmentManager();
        listViewItems = items;
        this.count=items.size();
        context = fragmentActivity;
        itemsLastPosition = new ArrayList<>();
        for(int i=0;i<count;i++)
        {
            itemsLastPosition.add(0);
        }
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

        Integer pagerPosition = itemsLastPosition.get(position);
        viewPager.setCurrentItem(pagerPosition);
        viewPager.addOnPageChangeListener(new MyPageChangeListener(viewPager, position));

//
//        final Handler handler = new Handler();
//        final Runnable Update = new Runnable() {
//            public void run() {
//                int currentPage = viewPager.getCurrentItem();
//                int NUM_PAGES = viewPager.getChildCount();
//                if (currentPage == NUM_PAGES) {
//                    currentPage = 0;
//                }
//                viewPager.setCurrentItem(currentPage++, true);
//            }
//        };
//
//        Timer swipeTimer = new Timer();
//        swipeTimer.schedule(new TimerTask() {
//
//            @Override
//            public void run() {
//                handler.post(Update);
//            }
//        }, 100, 1000);

        return currentView;
    }

    private class MyPageChangeListener extends
            ViewPager.SimpleOnPageChangeListener {

        private int mId;
        ViewPager pager1;

        public MyPageChangeListener(ViewPager pager, int id) {
            mId = id;
            pager1 = pager;
        }

        @Override
        public void onPageSelected(int position) {
            if (pager1.isShown()) {
                itemsLastPosition.set(mId, position);
            }
        }
    }
}
