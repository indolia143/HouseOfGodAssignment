package com.assign.hod.houseofgodassignment.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.assign.hod.houseofgodassignment.Helpers.Constant;

import com.assign.hod.houseofgodassignment.R;



public class ReCardAdapter extends RecyclerView.Adapter<ReCardAdapter.MyViewHolder> {


    private final Context mContext;
    private final LinearLayoutManager mLayoutManager;
    private final RecyclerView mRecyclerView;




    public ReCardAdapter(Context mContext, LinearLayoutManager mLayoutManager, RecyclerView mRecyclerView) {
        this.mContext = mContext;
        this.mLayoutManager = mLayoutManager;
        this.mRecyclerView = mRecyclerView;




    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.textView.setText(String.valueOf(position));
            if(Constant.pos!=0){
            if(position==Constant.pos){
                holder.cardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.colorAccent));
            }

        }




    }



    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);

    }

    @Override
    public int getItemCount() {
        return 10000;
    }



    public static class MyViewHolder extends  RecyclerView.ViewHolder{
        TextView textView;
        CardView cardView;
        private static  View view;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView  = itemView.findViewById(R.id.txt_view);
            cardView  = itemView.findViewById(R.id.card_view);
            view = itemView;
        }
        public static View getView(){
            return view;
        }
    }
}
