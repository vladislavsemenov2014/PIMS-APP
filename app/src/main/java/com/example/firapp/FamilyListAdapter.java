package com.example.firapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static android.content.ContentValues.TAG;

public class FamilyListAdapter extends RecyclerView.Adapter<FamilyListAdapter.ViewHolder> implements View.OnClickListener {

    private FamilyListData[] listData;

    private ClickListener clickListener;







    public FamilyListAdapter(FamilyListData[]listData) {this.listData = listData;}


    @NonNull
    @Override
    public FamilyListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater layoutInflater = LayoutInflater.from (parent.getContext ());
        View lisItem = layoutInflater.inflate (R.layout.list_item,parent,false);
        ViewHolder viewHolder = new ViewHolder (lisItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FamilyListAdapter.ViewHolder holder, int position) {

        final FamilyListData familyListData = listData[position];
        holder.textView.setText (listData[position].getDescription ());
        holder.imageView.setImageResource (listData[position].getImgId ());
        holder.relativeLayout.setOnClickListener (new View.OnClickListener () {

            private String context;

            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"click on item: "+familyListData.getDescription (),Toast.LENGTH_LONG).show();
                ViewHolder item = new ViewHolder (v);
                switch (v.getVerticalScrollbarPosition ())
                {
                    case 0:
                        Intent intent = new Intent (item.con,PopActivity.class);
                        item.con.startActivity(intent);
                }

            }


        });
    }

    @Override
    public int getItemCount() {
        return listData.length;
    }

    @Override
    public void onClick(View v) {


    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
    public final Context con;
    public ImageView imageView;
        public TextView textView;
        public RelativeLayout relativeLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            con = itemView.getContext ();
            this.imageView = (ImageView)itemView.findViewById (R.id.imageView);
            this.textView = (TextView)itemView.findViewById (R.id.textView);
            relativeLayout = (RelativeLayout)itemView.findViewById (R.id.relativeLayout);
        }
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }
}
