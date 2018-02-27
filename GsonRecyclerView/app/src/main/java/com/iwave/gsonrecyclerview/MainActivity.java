package com.iwave.gsonrecyclerview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends Activity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Labels allLabels ;
    private Entry mTitles;
    private Gson mGsonInstance;
    private TextView mLabelOfTitles;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);
        mLabelOfTitles = (TextView) findViewById(R.id.labelTextView);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);

        String jsonString = readFromFile();

        mGsonInstance=new Gson();

        mTitles=new Entry();

        mTitles=mGsonInstance.fromJson(jsonString,mTitles.getClass());

        ArrayList<Entry> entries = new ArrayList<Entry>();
        int count=entries.size();

        ArrayList<String> StrEntries= new ArrayList<String>();


        for (int index = 1; index <= count; index++) {

            Entry allLabels = entries.get(index);
           // StrEntries.add(allLabels.getTitle().getLabel());

            StrEntries.add(allLabels.getTitle().getLabel());

        }
        mAdapter=new MyAdapter(entries);
        mRecyclerView.setAdapter(mAdapter);
    }

    private String readFromFile() {
        String Filename = "label_json";

        StringBuffer sbJsonString = new StringBuffer();

        InputStream is = getResources().openRawResource(R.raw.label_json);

        int character;

        try {
            while ((character= is.read())!=-1) {

                sbJsonString.append((char) character);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return sbJsonString.toString();
    }

}

