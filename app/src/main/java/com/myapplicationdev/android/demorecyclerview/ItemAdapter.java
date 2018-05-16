package com.myapplicationdev.android.demorecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;

    public ItemAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override //call when viewHolder is created
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);
        return new ViewHolder(v);
    }

    @Override //call after onCreateViewHolder is call & binds data to ViewHolder
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListItem listItem = listItems.get(position);

        //set item into ViewHolder
        holder.tvHead.setText(listItem.getHead());
        holder.tvDesc.setText(listItem.getDesc());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvHead, tvDesc;

        public ViewHolder(View itemView) {
            super(itemView);

            tvHead = (TextView)itemView.findViewById(R.id. textViewHeading);
            tvDesc = (TextView)itemView.findViewById(R.id. textViewDescription);
        }
    }
}
