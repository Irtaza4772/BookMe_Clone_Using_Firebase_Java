package com.example.bookmeclone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class BookedAdapder extends FirebaseRecyclerAdapter<Book, BookedAdapder.BookViewHolder> {

    public BookedAdapder(@NonNull FirebaseRecyclerOptions<Book> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull BookViewHolder holder, int position, @NonNull Book model) {
        holder.tvName.setText(model.getName());
        holder.tvDate.setText(model.getDate());
        holder.tvPrice.setText("Rs: " + model.getPrice());
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_booked_design, parent, false);
        return new BookedAdapder.BookViewHolder(view);
    }

    public class BookViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvName, tvDate, tvPrice;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvItemName);
            tvDate = itemView.findViewById(R.id.tvItemDate);
            tvPrice = itemView.findViewById(R.id.tvItemPrice);
        }
    }
}
