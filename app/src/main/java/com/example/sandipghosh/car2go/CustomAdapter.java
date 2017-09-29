package com.example.sandipghosh.car2go;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandipghosh on 27/09/17.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyHolder> {

    List<Car> items;
    Context context;



    public CustomAdapter(Context context, String[] name, String[] interior) {
        super();
        items = new ArrayList<Car>();
        this.context = context;
        for (int i = 0; i < name.length; i++) {
            Car item = new Car();
            item.setName(name[i]);
            item.setInterior(interior[i]);
            items.add(item);
        }
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card, parent, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;

    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Car list = items.get(position);
        holder.name.setText(list.getName());
        holder.interior.setText(list.getInterior());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView interior;


        public MyHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            interior = (TextView) itemView.findViewById(R.id.interior);
        }


    }
}
