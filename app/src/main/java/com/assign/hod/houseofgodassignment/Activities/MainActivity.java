package com.assign.hod.houseofgodassignment.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.assign.hod.houseofgodassignment.Adapters.ReCardAdapter;
import com.assign.hod.houseofgodassignment.Helpers.Constant;
import com.assign.hod.houseofgodassignment.Helpers.DividerItemDecoration;
import com.assign.hod.houseofgodassignment.R;

public class MainActivity extends AppCompatActivity  {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private int overallXScroll = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpVariables();
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);


        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());


        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int firstVisibleItemPosition = mLayoutManager.findFirstVisibleItemPosition();
                int lastVisibleItemPosition = mLayoutManager.findLastVisibleItemPosition();
                int pos = Math.abs((lastVisibleItemPosition + firstVisibleItemPosition) / 2);


                //Constant.pos=pos;
                //mAdapter.notifyDataSetChanged();

                if(Constant.pos==0) {
                    Constant.pos = pos;
                    mRecyclerView.getAdapter().notifyItemChanged(pos);
                }else{
                    Constant.pos = pos;
                    mAdapter.notifyDataSetChanged();
                }

            }
        });


    }



    private void setUpVariables() {

        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ReCardAdapter(this,mLayoutManager,mRecyclerView);
    }
}
