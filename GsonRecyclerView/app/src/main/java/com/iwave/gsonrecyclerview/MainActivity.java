package com.iwave.gsonrecyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    //intializing
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static OkHttpClient mClient = new OkHttpClient();
    public static List<Entry> entries = new ArrayList<>();
    public static Data data;
    private static String mResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //saving the present state
        super.onCreate(savedInstanceState);

        //Setting the content view from main xml
        setContentView(R.layout.activity_main);

        //finding view of recyclerView using id
        mRecyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);

        /*Avoid unnecessary layout passes by setting setHasFixedSize using
        setHasFixedSize*/
        mRecyclerView.setHasFixedSize(true);

        //Setting context in linearLayout
        mLayoutManager = new LinearLayoutManager(this);

        //inserting above linearLayout into recyclerView
        mRecyclerView.setLayoutManager(mLayoutManager);

        //calling the method
        getEntryData();

        //setting Entries by creating adapter
        mAdapter = new MyAdapter(MainActivity.entries);

        //Attaching adapter using SetAdapter for recyclerView
        mRecyclerView.setAdapter(mAdapter);
    }

    public void getEntryData() {

        //Creating a request to make a cal and building url
        Request request = new Request.Builder()
                .url("http://itunes.apple.com/us/rss/topalbums/limit=10/json")
                .build();

        //To make Asynchronous calls we use enqueue method
        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

                //on failure of call we will know where the issue is
                e.printStackTrace();
            }

            //code for if we get respose for the cal
            @Override
            public void onResponse(Response response) throws IOException {

                //getting the response in
                mResponse = response.body().string();

                //creating gson instance
                Gson gson = new Gson();

                /*In below line converting Json to java objects
                our mResponse is in String Format and methods are
                in Data.class.They are taken into data                 */
                data = gson.fromJson(mResponse, Data.class);

                //getting those data from Data.class using this path
                List<Entry> entry2 = data.getFeed().getEntry();

                //clearing the entries to store new Data after running the prgrm
                entries.clear();

                //Using for Each loop to take data from entry2 to entry1
                for (Entry entry1 : entry2) {

                    //adding the label one by one from entry1 into entries
                    entries.add(entry1);

                }

                //running code on UIThread and syncing
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub

                        /* Notifies the observers that data has been changed and
                           View reflecting the data will refresh itself*/
                        mAdapter.notifyDataSetChanged();

                    }
                });


            }
        });
    }
}

