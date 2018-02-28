package com.iwave.gsonrecyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.RequiresPermission;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends Activity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Labels allLabels;
    private Entry mTitles;
    private Gson mGsonInstance;
    private TextView mLabelOfTitles;
    private static OkHttpClient mClient = new OkHttpClient();
    public static List<Entry> entries = new ArrayList<>();
    public static Data data;
    private static String mResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);
        mLabelOfTitles = (TextView) findViewById(R.id.labelTextView);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);

      /*  String jsonString = readFromFile();

        mGsonInstance = new Gson();

        mTitles = new Entry();

        mTitles = mGsonInstance.fromJson(jsonString, mTitles.getClass());

        ArrayList<String> StrEntries = new ArrayList<String>(); */

       getEntryData();
        mAdapter = new MyAdapter(MainActivity.entries);
        mRecyclerView.setAdapter(mAdapter);
    }

    public  void getEntryData() {

        Request request = new Request.Builder()
                .url("http://itunes.apple.com/us/rss/topalbums/limit=10/json")
                .build();
        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                mResponse = response.body().string();
                Gson gson = new Gson();
                data = gson.fromJson(mResponse,Data.class);
                List<Entry> entry2 = data.getFeed().getEntry();
                entries.clear();
                for (Entry entry1 : entry2) {
                    entries.add(entry1);
                }
                mAdapter.notifyDataSetChanged();

            }
        });
    }

   /* private String readFromFile() {
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
*/
}

