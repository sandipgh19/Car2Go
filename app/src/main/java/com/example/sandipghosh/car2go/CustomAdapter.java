package com.example.sandipghosh.car2go;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandipghosh on 27/09/17.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyHolder> {

    List<Car> items;
    Context context;



    public CustomAdapter(Context context, String[] name, String[] interior, String[] address, String[] engineType, String[] exterior, String[] fuel, String[] vin, String[] coordinates ) {
        super();
        items = new ArrayList<Car>();
        this.context = context;
        for (int i = 0; i < name.length; i++) {
            Car item = new Car();
            item.setName(name[i]);
            item.setInterior(interior[i]);
            item.setAddress(address[i]);
            item.setEngineType(engineType[i]);
            item.setExterior(exterior[i]);
            item.setFuel(fuel[i]);
            item.setVin(vin[i]);
            item.setCoordinates(coordinates[i]);
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
    public void onBindViewHolder(MyHolder holder, final int position) {
        final Car list = items.get(position);
        holder.name.setText("Name: "+list.getName());
        holder.address.setText("Address: "+list.getAddress());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsView.class);
                intent.putExtra("coordinates", list.getCoordinates());
                intent.putExtra("engine", list.getEngineType());
                intent.putExtra("fuel", list.getFuel());
                intent.putExtra("vin",list.getVin());
                intent.putExtra("address",list.getAddress());
                intent.putExtra("extarior",list.getExterior());
                intent.putExtra("interior",list.getInterior());
                intent.putExtra("name",list.getName());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView interior;
        TextView address;


        public MyHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            address = (TextView) itemView.findViewById(R.id.address);
        }


    }
}
