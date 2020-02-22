package com.example.konataandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.LinearViewHolder>
{

    private Context mContext;
    private OnItemClickListener mListener;

    public StaggeredGridAdapter(Context context, OnItemClickListener listener)
    {
        this.mContext = context;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public StaggeredGridAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_staggeredgrid_recycler_item, viewGroup, false));
    }


    //具体设置图片是在Adapter的Bind方法中
    @Override
    public void onBindViewHolder(@NonNull StaggeredGridAdapter.LinearViewHolder viewHolder, final int i)
    {
        if (i % 2 == 0)
            viewHolder.imageView.setImageResource(R.drawable.image15_2);
        else
            viewHolder.imageView.setImageResource(R.drawable.image13_00000);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mListener.onClick(i);
//                Toast.makeText(mContext, "click..." + i, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return 50;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder
    {

        private ImageView imageView;

        public LinearViewHolder(@NonNull View itemView)
        {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);
        }
    }

    public interface OnItemClickListener
    {
        void onClick(int pos);
    }
}