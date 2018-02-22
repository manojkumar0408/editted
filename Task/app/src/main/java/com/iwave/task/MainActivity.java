package com.iwave.task;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button mParseAndDisplay;
    private Gson mGsonInstance;
    private Title mLabels;
    private Entry mTitles;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private TextView mTitleOfEntry,mLabel;

    private static final Object TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        mRecyclerview.setAdapter(mAdapter);

        mRecyclerView.setHasFixedSize(true);

        mTitleOfEntry=findViewById(R.id.TitleOfEntry);
        mLabel=findViewById(R.id.Label);
        mParseAndDisplay = findViewById(R.id.ButtonParse);

        mParseAndDisplay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                String jsonString = readFromFile();

                mGsonInstance=new Gson();

                mTitles=new Entry();

                mLabels = new Title();

                mTitles=mGsonInstance.fromJson(jsonString, (Type) Entry.class);

                mLabels=mGsonInstance.fromJson(jsonString,Title.class);

                mTitleOfEntry.setText((CharSequence) Entry.getTitle());
                mLabel.setText(Title.getLabel());
            }
        });
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
