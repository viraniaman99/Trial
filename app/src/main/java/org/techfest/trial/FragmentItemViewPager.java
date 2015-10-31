package org.techfest.trial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by DELL on 25-Oct-15.
 */
public class FragmentItemViewPager extends Fragment
{
    private int image;
    private String className;
    private String fragName;

    public static Fragment newInstance(ViewPagerItem item)
    {
        FragmentItemViewPager fragmentItemViewPager = new FragmentItemViewPager();
        Bundle bundle = new Bundle();
        bundle.putString("CLASS", item.getClassName());
        bundle.putInt("IMAGE", item.getImage());
        bundle.putString("FRAG", item.getFragName());
        fragmentItemViewPager.setArguments(bundle);
        return fragmentItemViewPager;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        className = getArguments().getString("CLASS");
        image = getArguments().getInt("IMAGE");
        fragName = getArguments().getString("FRAG");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewpager_item_main, container, false);
        ((LinearLayout) view.findViewById(R.id.viewpager_item)).setBackgroundResource(image);
        ((LinearLayout) view.findViewById(R.id.viewpager_item)).setOnClickListener(new View.OnClickListener() {
            Class finalFrag;

            @Override
            public void onClick(View v) {
                try {
                    finalFrag = Class.forName(className + ".Main2Activity");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(getContext(), finalFrag);
                intent.putExtra("FRAG", fragName);
                intent.putExtra("PATH", className);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public FragmentItemViewPager() {
    }
}
