package org.techfest.trial;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ListViewItem> listViewItems = new ArrayList<>();
        ListView listView =  (ListView) findViewById(R.id.listView);

        for(int i=0;i<10;i++)
        {
            ArrayList<ViewPagerItem> items = new ArrayList<>();
            items.add(new ViewPagerItem(R.drawable.img1, "org.techfest.trial", "CompetitionsFragment"));
            items.add(new ViewPagerItem(R.drawable.img2, "org.techfest.trial", "ExhibitionsFragment"));
            items.add(new ViewPagerItem(R.drawable.img3, "org.techfest.trial", "IdeateFragment"));
            items.add(new ViewPagerItem(R.drawable.img4, "org.techfest.trial", "InitiativesFragment"));
            items.add(new ViewPagerItem(R.drawable.img5, "org.techfest.trial", "LecturesFragment"));
            items.add(new ViewPagerItem(R.drawable.img6, "org.techfest.trial", "OzoneFragment"));

            ListViewItem listViewItem = new ListViewItem(String.valueOf(i), items);
            listViewItems.add(listViewItem);
        }

        ListViewAdapter listViewAdapter = new ListViewAdapter(this, listViewItems);
        listView.setAdapter(listViewAdapter);


    }

}
