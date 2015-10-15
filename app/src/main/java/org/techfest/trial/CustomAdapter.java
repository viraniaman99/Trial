package org.techfest.trial;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 14-Oct-15.
 */
public class CustomAdapter extends ArrayAdapter<Integer[]> {
    public CustomAdapter(Context context, Integer[][] resource) {
        super(context,R.layout.custom_row_main ,resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(R.layout.custom_row_main, parent, false);

        View view1 = layoutInflater.inflate(R.layout.content_main, parent, false);

        Integer[] resIds = getItem(position);

        final ViewFlipper viewFlipper1 = (ViewFlipper) view.findViewById(R.id.viewFlipper);

        for(int i=0;i<resIds.length;i++)
        {
            ImageButton imageButton = new ImageButton(getContext());
            imageButton.setBackgroundResource(resIds[i]);
            viewFlipper1.addView(imageButton);
        }

        viewFlipper1.setFlipInterval(5000);

        viewFlipper1.startFlipping();

        viewFlipper1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent to open the required activity
            }
        });

        return view;
    }
}
