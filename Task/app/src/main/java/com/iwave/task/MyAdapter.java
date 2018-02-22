package com.iwave.task;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by user on 2/22/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<String> mValues;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mFirstLineTextView;
        public TextView mSecondLineTextView;

        public ViewHolder(View v) {
            super(v);

            mFirstLineTextView = (TextView) v.findViewById(R.id.TitleOfEntry);
            mSecondLineTextView = (TextView) v.findViewById(R.id.Label);
        }
    }

    public void add(int position, String item) {
        mValues.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        mValues.remove(position);
        notifyItemRemoved(position);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View view =
                inflater.inflate(R.layout.title_label, parent, false);

        ViewHolder viewholder = new ViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final String name = mValues.get(position);
        holder.mFirstLineTextView.setText((CharSequence) Entry.getTitle());
        holder.mSecondLineTextView.setText(Title.getLabel());

    }

    @Override
    public int getItemCount() {

        return mValues.size();
    }



}