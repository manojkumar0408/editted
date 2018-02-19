package com.iwave.okhttprequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private TextView mTExtViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTExtViewResult =findViewById(R.id.textViewResult);

        OkHttpClient client=new OkHttpClient();

        String mUrl="https://reqres.in/api/users?page=2";

        Request mRequest=new Request.Builder().url(mUrl).build();

        client.newCall(mRequest).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (response.isSuccessful()){
                    final String myResponse=response.body().string();

                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTExtViewResult.setText(myResponse);
                        }
                    });
                }
            }
        });
    }
}
