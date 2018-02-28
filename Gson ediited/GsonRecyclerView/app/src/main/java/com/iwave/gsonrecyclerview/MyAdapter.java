package com.iwave.gsonrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Entry> mValues;

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mLabelOfTitles;
        private View mLayout;

        public ViewHolder(View v) {
            super(v);
            mLayout = v;
            mLabelOfTitles = (TextView) v.findViewById(R.id.labelTextView);
        }
    }

    public MyAdapter(List<Entry> entries) {
        mValues = entries;
    }

    public void add(int position, Entry item) {
        mValues.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        mValues.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v = inflater.inflate(R.layout.label_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {

        final Entry Label = mValues.get(position);
        holder.mLabelOfTitles.setText(Label.getTitle().getLabel());

    }

    @Override
    public int getItemCount() {

        return mValues.size();

    }
}
