package com.example.asus.myamazinglist.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.asus.myamazinglist.R;
import com.example.asus.myamazinglist.model.Data1;

import java.util.List;

public class DataHorizontalAdapter extends RecyclerView.Adapter<DataHorizontalAdapter.HorizontalViewHolder> {
    private Context mContext;
    private List<Data1> mData;
    private HorizontalAdapterOnClickHandler mOnClickHandler;

    public DataHorizontalAdapter(Context context, HorizontalAdapterOnClickHandler onClickHandler) {
        mContext = context;
        mOnClickHandler = onClickHandler;
    }

    public void setData(List<Data1> lstData) {
        mData = lstData;
        notifyDataSetChanged();
    }

    @Override
    public HorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_horizontal, parent, false);
        return new HorizontalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HorizontalViewHolder holder, int position) {
        Data1 data = mData.get(position);
        Glide.with(mContext)
                .load(data.getImage())
                .apply(RequestOptions.circleCropTransform())
                .placeholder(R.drawable.circle_image_placeholder)
                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        if (null == mData) return 0;
        return mData.size();
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView thumbnail;

        public HorizontalViewHolder(View view) {
            super(view);
            thumbnail = view.findViewById(R.id.thumbnail);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            mOnClickHandler.onClick(mData.get(adapterPosition));
        }
    }

    public interface HorizontalAdapterOnClickHandler {
        void onClick(Data1 data1);
    }
}
