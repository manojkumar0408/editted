package com.iwave.toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText mEditName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onDisplay(View view) {
        mEditName = (EditText) findViewById(R.id.mNameEditText);
        String mMessage = mEditName.getText().toString();
        Toast.makeText(MainActivity.this, mMessage, Toast.LENGTH_LONG).show();
    }
}
