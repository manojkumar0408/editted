package com.iwave.snackbar;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mNormal, mAction;
    private Snackbar mSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNormal = (Button) findViewById(R.id.mNormalButton);
        mAction = (Button) findViewById(R.id.mActionButton);
        mNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSnackbar = Snackbar.make(mNormal, "i am normal snackbar", Snackbar.LENGTH_LONG);
                mSnackbar.show();
            }
        });
        mAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSnackbar = Snackbar.make(mAction, "i am action snackbar", Snackbar.LENGTH_LONG);
                mSnackbar.setAction("ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "action clicked and i am toast", Toast.LENGTH_LONG).show();
                    }
                });
                mSnackbar.show();
            }
        });

    }
}
