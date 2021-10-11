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
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecycleViewAdapter";
    private List<NasaPhotos> arr_nasa_photos;
    private Context rva_context;


    public RecyclerViewAdapter(Context rva_context, List<NasaPhotos> arr_nasa_photos) {
        this.arr_nasa_photos = arr_nasa_photos;
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

        ((ViewHolder)holder).image_longitude.setText(arr_nasa_photos.get(position).getLongitude());
        ((ViewHolder)holder).image_latitude.setText(arr_nasa_photos.get(position).getLatitude());

        RequestOptions defaultOptions = new RequestOptions()
                .error(R.drawable.ic_launcher_background);
        Glide.with(rva_context)
                .setDefaultRequestOptions(defaultOptions)
                .load(arr_nasa_photos.get(position).getImage())
                .into(((ViewHolder)holder).image);

    }

    @Override
    public int getItemCount() {
        return arr_nasa_photos.size();
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
