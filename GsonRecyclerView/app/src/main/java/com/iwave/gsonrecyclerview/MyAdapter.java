package com.iwave.gsonrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    //intializing
    private List<Entry> mValues;


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mLabelOfTitles;
        private View mLayout;

        //it describes the view and its and place in recyclerView
        public ViewHolder(View v) {
            super(v);
            mLayout = v;

            //finding  textView by its ID 
            mLabelOfTitles = (TextView) v.findViewById(R.id.labelTextView);
        }
    }

    public MyAdapter(List<Entry> entries) {

        //Storing values into mValues
        mValues = entries;
    }

    public void add(int position, Entry item) {
        mValues.add(position, item);

        /*notifying the observers that new item is
        inserted at this position*/
        notifyItemInserted(position);
    }

    public void remove(int position) {
        mValues.remove(position);

        /*Notifying the obeservers that
         an item has been removed from this particular position*/
        notifyItemRemoved(position);
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        /*Creating a instance for layout and
        and its corresponding View Objects*/
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v = inflater.inflate(R.layout.label_row, parent, false);

        //attaching the inflated part to viewHolder
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    //updating the at item at given position
    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {

        //getting position of mValues and storing in Label
        final Entry Label = mValues.get(position);

        //Setting text to textView from Below path
        holder.mLabelOfTitles.setText(Label.getTitle().getLabel());

    }

    @Override
    public int getItemCount() {

        /*Returns size if mValues has any entries
         If not returns Zero */
        if (mValues != null) {
            return mValues.size();
        } else {
            return 0;
        }
    }
}
