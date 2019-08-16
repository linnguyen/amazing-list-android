package com.example.asus.myamazinglist.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.myamazinglist.R;
import com.example.asus.myamazinglist.model.Movie;

import java.util.List;

public class DataVerticalAdapter extends RecyclerView.Adapter<DataVerticalAdapter.VerticalViewHolder> {
    private Context mContext;
    private List<Movie> mData;

    public DataVerticalAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<Movie> lstData) {
        mData = lstData;
        notifyDataSetChanged();
    }

    @Override
    public VerticalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);

        return new VerticalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(VerticalViewHolder holder, int position) {
        Movie movie = mData.get(position);
        holder.tvTitleMovie.setText(movie.getTitle());
        Glide.with(mContext)
                .load(movie.getPosterPath())
                .placeholder(R.drawable.image_placeholder)
                .into(holder.imvThumbnail);
    }

    @Override
    public int getItemCount() {
        if (null == mData) return 0;
        return mData.size();
    }

    public class VerticalViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitleMovie;
        private ImageView imvThumbnail;

        public VerticalViewHolder(View view) {
            super(view);
            imvThumbnail = view.findViewById(R.id.thumbnail);
            tvTitleMovie = view.findViewById(R.id.tv_movie_title);
        }
    }
}
