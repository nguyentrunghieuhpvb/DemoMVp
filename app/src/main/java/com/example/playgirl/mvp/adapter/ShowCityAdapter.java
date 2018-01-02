package com.example.playgirl.mvp.adapter;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.playgirl.mvp.R;
import com.example.playgirl.mvp.utlis.CityInfo;


import java.util.ArrayList;

/**
 * Created by playgirl on 1/2/18.
 */

public class ShowCityAdapter extends RecyclerView.Adapter<ShowCityAdapter.ViewHolder> {

    private ArrayList<CityInfo> listCityInfos;
    private Context context;


    public ShowCityAdapter(ArrayList<CityInfo> listCityInfos, Context context) {
        this.listCityInfos = listCityInfos;
        this.context = context;
        Log.d("ModelContent",""+listCityInfos.size());
    }



    public void setListCityInfos(ArrayList<CityInfo> listCityInfos) {
        this.listCityInfos.clear();
        this.listCityInfos.addAll(listCityInfos);
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return  new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CityInfo cityInfo = listCityInfos.get(position);
        holder.txtID.setText(cityInfo.getId());
        holder.txtPopu.setText(cityInfo.getPopulat());
        holder.txtName.setText(cityInfo.getName());

    }

    @Override
    public int getItemCount() {
        Log.d("ModelContent",listCityInfos.size()+"");
        return listCityInfos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtID, txtName, txtPopu;
        public ViewHolder(View itemView) {
            super(itemView);
            txtID = itemView.findViewById(R.id.txt_id);
            txtName = (TextView) itemView.findViewById(R.id.txt_name);
            txtPopu = (TextView) itemView.findViewById(R.id.txt_population);
        }
    }
}
