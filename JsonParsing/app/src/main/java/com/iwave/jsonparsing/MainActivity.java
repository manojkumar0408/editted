package com.iwave.jsonparsing;

import android.nfc.Tag;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private static final Object TAG = MainActivity.class.getName();
    private TextView mColor, mHexValue;
    private Button mParseAndDisplay;
    private Gson mGsonInstance;
    private Colors colors;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mColor = findViewById(R.id.Color);

        mHexValue = findViewById(R.id.HexValue);

        mParseAndDisplay = findViewById(R.id.btnParse);

        mParseAndDisplay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //parse and display

                String jsonString = readFromFile();

                Log.i((String) TAG,jsonString);

                mGsonInstance=new Gson();

                colors=new Colors();

                colors=mGsonInstance.fromJson(jsonString,colors.getClass());
                
                //Log.i(TAG,colors.getColors().get(0),getColorName());

                mColor.setText((CharSequence) colors.getColors().get(0).getColorName());
                mHexValue.setText(colors.getColors().get(0).getHexValue());
            }
        });


    }

    private String readFromFile() {

        String Filename = "color_json";

        StringBuffer sbJsonString = new StringBuffer();

        InputStream is = getResources().openRawResource(R.raw.color_json);

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
