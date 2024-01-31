package com.example.bookmeclone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class BusAdapter extends FirebaseRecyclerAdapter<Bus, BusAdapter.BusViewHolder> {

    //Context parent;


    public BusAdapter(@NonNull FirebaseRecyclerOptions<Bus> options)//, String busDate, String busFrom, String busTo) {
    {   super(options);
        //parent = context;
       /* this.busDate = busDate;
        this.busFrom = busFrom;
        this.busTo = busTo;

        */
    }



    @Override
    protected void onBindViewHolder(@NonNull BusViewHolder holder, int position, @NonNull Bus model) {
//        if (busFrom.equals(model.getFrom()) && busTo.equals(model.getTo()) && busDate.equals(model.getDate()))
//        {

            holder.tvName.setText(model.getName());
            holder.tvDate.setText(model.getDate());
            holder.tvPrice.setText(model.getPrice());

        //}

    }

    @NonNull
    @Override
    public BusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_vehicle_design, parent, false);
        return new BusViewHolder(view);
    }

    public class BusViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvName, tvDate, tvPrice;
        Button btnBookVehicle;

        public BusViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvVehicleName);
            tvDate = itemView.findViewById(R.id.tvVehicleDate);
            tvPrice = itemView.findViewById(R.id.tvVehiclePrice);
            btnBookVehicle = itemView.findViewById(R.id.btnBookVehicle);
        }
    }


}
