package com.example.mvvm_example_app;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecycleViewAdapter";
    private ArrayList<String> arr_images = new ArrayList<>();
    private ArrayList<String> arr_longitude = new ArrayList<>();
    private ArrayList<String> arr_latitude = new ArrayList<>();
    private Context rva_context;

    public RecyclerViewAdapter(ArrayList<String> arr_images, ArrayList<String> arr_longitude, ArrayList<String> arr_latitude, Context rva_context) {
        this.arr_images = arr_images;
        this.arr_longitude = arr_longitude;
        this.arr_latitude = arr_latitude;
        this.rva_context = rva_context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG,"onBindViewHolder: called");

        Glide.with(rva_context).asBitmap().load(arr_images.get(position)).into(holder.image);
        holder.image_longitude.setText(arr_longitude.get(position));
        holder.image_latitude.setText(arr_latitude.get(position));

    }

    @Override
    public int getItemCount() {
        return arr_longitude.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView image_longitude;
        TextView image_latitude;
        RelativeLayout parent_layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.list_item_civ_image);
            image_longitude = itemView.findViewById(R.id.list_item_tv_longitude);
            image_latitude = itemView.findViewById(R.id.list_item_tv_latitude);
            parent_layout = itemView.findViewById(R.id.list_item_rl_parent_layout);

        }
    }
}
