package com.example.sandipghosh.car2go;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by sandipghosh on 27/09/17.
 */

public class CustomAdapter extends ArrayAdapter<String> {

    private String[] name;
    private String[] interior;
    private Activity context;

    public CustomAdapter(Activity context, String[] name, String[] interior) {
        super(context, R.layout.activity_card, name);
        this.context = context;
        this.name = name;
        this.interior = interior;
    }
    //list item init.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.activity_card, null, true);
        TextView nametxt = (TextView) listViewItem.findViewById(R.id.name);
        TextView interiortxt = (TextView) listViewItem.findViewById(R.id.interior);

        nametxt.setText(name[position]);
        interiortxt.setText(interior[position]);


        return listViewItem;
    }
}
