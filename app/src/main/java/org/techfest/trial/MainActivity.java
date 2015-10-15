package org.techfest.trial;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

public class MainActivity extends AppCompatActivity {

    String TAG = "Aman";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//
//        ImageButton btn1 = new ImageButton(this);
//        btn1.setImageResource(R.drawable.img1);
//        ImageButton btn2 = new ImageButton(this);
//        btn2.setImageResource(R.drawable.img2);
//        ImageButton btn3 = new ImageButton(this);
//        btn3.setImageResource(R.drawable.img3);
//        ImageButton btn4 = new ImageButton(this);
//        btn4.setImageResource(R.drawable.img4);
//        ImageButton btn5 = new ImageButton(this);
//        btn5.setImageResource(R.drawable.img5);
//        ImageButton btn6 = new ImageButton(this);
//        btn6.setImageResource(R.drawable.img6);
//
//        ViewFlipper viewFlipper = new ViewFlipper(this);
//        viewFlipper.addView(btn1);
//        viewFlipper.addView(btn2);
//
//        ViewFlipper viewFlipper1 = new ViewFlipper(this);
//        viewFlipper.addView(btn3);
//        viewFlipper.addView(btn4);
//
//        ViewFlipper viewFlipper2 = new ViewFlipper(this);
//        viewFlipper.addView(btn5);
//        viewFlipper.addView(btn6);
//

        Integer[][] slides = new Integer[6][6];

        for(int i=0;i<6;i++)
        {
            slides[i][0] = R.drawable.img1;
            slides[i][1] = R.drawable.img2;
            slides[i][2] = R.drawable.img3;
            slides[i][3] = R.drawable.img4;
            slides[i][4] = R.drawable.img5;
            slides[i][5] = R.drawable.img6;
        }

        ArrayAdapter<Integer[]> arrayAdapter = new CustomAdapter(this, slides);
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
