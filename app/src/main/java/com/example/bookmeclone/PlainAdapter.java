package com.example.bookmeclone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PlainAdapter extends FirebaseRecyclerAdapter<Plain, PlainAdapter.PlainViewHolder> {

    Context parent;

    public PlainAdapter(@NonNull FirebaseRecyclerOptions<Plain> options, Context context) {
        super(options);
        parent = context;

    }

    @Override
    protected void onBindViewHolder(@NonNull PlainViewHolder holder, int position, @NonNull Plain model) {


        holder.tvName.setText(model.getName());
        holder.tvDate.setText(model.getDate());
        holder.tvPrice.setText("Rs: " + model.getPrice());

        holder.btnBookVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemKey = getRef(position).getKey();

                // Retrieve the data from the source node using the unique key
                DatabaseReference sourceRef = FirebaseDatabase.getInstance().getReference().child("Plaines").child(itemKey);
                sourceRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        // Retrieve the data from the snapshot
                        if (snapshot.exists()) {
                            // Get the data
                            Plain plain = snapshot.getValue(Plain.class);

                            // Insert the data into the destination node
                            DatabaseReference destinationRef = FirebaseDatabase.getInstance().getReference().child("Booked").push();
                            destinationRef.setValue(plain)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Toast.makeText(parent, "Booked", Toast.LENGTH_SHORT).show();
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            // Handle any errors that occur during the insertion
                                        }
                                    });
            }
        }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    };

                });

    }
            });
        }



    @NonNull
    @Override
    public PlainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_vehicle_design, parent, false);
        return new PlainViewHolder(view);
    }

    public class PlainViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvName, tvDate, tvPrice;
        Button btnBookVehicle;

        public PlainViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvVehicleName);
            tvDate = itemView.findViewById(R.id.tvVehicleDate);
            tvPrice = itemView.findViewById(R.id.tvVehiclePrice);
            btnBookVehicle = itemView.findViewById(R.id.btnBookVehicle);
        }
    }
}
