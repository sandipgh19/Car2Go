package com.example.sandipghosh.car2go;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sandipghosh on 27/09/17.
 */

public class CustomAdapter extends /*ArrayAdapter<Car> */RecyclerView.Adapter<CustomAdapter.MyHolder>{

   /* List<Car> carList;
    Context context;
    private LayoutInflater mInflater;

    // Constructors
    public CustomAdapter(Context context, List<Car> objects) {
        super(context, 0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        carList = objects;
    }

    @Override
    public Car getItem(int position) {
        return carList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.activity_card, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        Car item = getItem(position);

        vh.textViewName.setText(item.getName());
        vh.textViewEmail.setText(item.getInterior());

        return vh.rootView;
    }

    private static class ViewHolder {
        public final RelativeLayout rootView;
        public final TextView textViewName;
        public final TextView textViewEmail;

        private ViewHolder(RelativeLayout rootView, TextView textViewName, TextView textViewEmail) {
            this.rootView = rootView;
            this.textViewName = textViewName;
            this.textViewEmail = textViewEmail;
        }

        public static ViewHolder create(RelativeLayout rootView) {
            TextView textViewName = (TextView) rootView.findViewById(R.id.name);
            TextView textViewEmail = (TextView) rootView.findViewById(R.id.interior);
            return new ViewHolder(rootView,  textViewName, textViewEmail);
        }
    }*/

    List<Car> list;

    public CustomAdapter(List<Car> list) {
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card,parent,false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Car product = list.get(position);
        holder.name.setText(product.getName());
        holder.interior.setText(product.getInterior());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView interior;


        public MyHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            interior = (TextView) itemView.findViewById(R.id.interior);

        }


    }
}
