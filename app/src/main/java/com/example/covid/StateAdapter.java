package com.example.covid;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class StateAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] state ;
    private final Integer[] imageId;
    public StateAdapter(Activity context,
                      String[] state, Integer[] imageId) {
        super(context, R.layout.state_listview_layout, state);
        this.context = context;
        this.state = state;
        this.imageId = imageId;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.state_listview_layout, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.text);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
        txtTitle.setText(state[position]);

        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}

