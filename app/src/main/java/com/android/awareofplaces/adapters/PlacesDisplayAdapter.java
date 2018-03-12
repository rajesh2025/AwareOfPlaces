package com.android.awareofplaces.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.awareofplaces.R;

/**
 * Created by user on 27-02-2018.
 */

public class PlacesDisplayAdapter extends RecyclerView.Adapter<PlacesDisplayAdapter.DataHolder>{
private Context mContext;

    PlacesDisplayAdapter(Context context){
        mContext = context;
    }

    class DataHolder extends RecyclerView.ViewHolder{

        DataHolder(View view){
            super(view);
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public DataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DataHolder(LayoutInflater.from(mContext).inflate(R.layout.places_display_view,parent,false));
    }

    @Override
    public void onBindViewHolder(DataHolder holder, int position) {

    }
}
